import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import org.apache.commons.dbcp.BasicDataSource;

public class Database {
	
	static BasicDataSource ds = null;
	public Database() throws SQLException {
		ds = new BasicDataSource(); 
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/PianoLessons?useSSL=false");
	}
	
	public void displayData(String x) throws SQLException {
		
		Connection con = ds.getConnection("David", "12345");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT firstname, lastname FROM person WHERE type='" + x + "'");
		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print(" ");
			System.out.print(rs.getString(2));
			System.out.println();
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (con != null) con.close();
		
	}
	//should this be static? concurrency problems?
	public static <T extends Person> void SaveNewPerson(T ob) throws SQLException {
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		Savepoint save = null;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PianoLessons?useSSL=false", "David", "12345");
		con.setAutoCommit(false);
		
		try {
			save = con.setSavepoint();
			pstmt = con.prepareStatement("INSERT INTO Person (type,firstname,lastname) "
				+ "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, ob.getType());
			pstmt.setString(2, ob.getFirstName());
			pstmt.setString(3, ob.getLastName());
			pstmt.executeUpdate();
		
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			int autoID = rs.getInt(1);
			
			pstmt2 = con.prepareStatement("INSERT INTO " + ob.getType() + "Detail" + 
							"(" + ob.getType() + "ID, Street, City, Zip, Cell, Email, Birthdate)"
							+ "VALUES (?,?,?,?,?,?,?)");
			pstmt2.setInt(1, autoID);
			pstmt2.setString(2, ob.getStreet());
			pstmt2.setString(3, ob.getCity());
			pstmt2.setString(4, ob.getZip());
			pstmt2.setString(5, ob.getCellPhone());
			pstmt2.setString(6, ob.getEmailAddress());
			pstmt2.setString(7, ob.getBirthdate());
			pstmt2.executeUpdate();
			
			con.commit();
		
		} catch (Exception x) {
			//if this rollback fails, how to handle data corrupt?
			try {
				con.rollback(save);
			}catch (SQLException z) {
				System.out.println(z);
				System.out.println("unable to rollback database entry. data corrupted");
			}
			throw new SQLException();
		} finally {
			if (pstmt != null) pstmt.close();
			if (pstmt2 != null) pstmt2.close();
			if (con != null) {
				con.setAutoCommit(true);
				con.releaseSavepoint(save);
				con.close();
			}
		}						
	}
	
	public static void CreateDB() {
		
	}

	

}
