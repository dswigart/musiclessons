import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBCP {
	
	Connection con;
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PianoLessons?useSSL=false");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
}
	
}

}