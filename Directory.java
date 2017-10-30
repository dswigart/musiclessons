import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

public class Directory {
	
    static void displayData(String x) throws DirectoryException { 
       try {
    	   Database.displayData(x);
       }catch (SQLException sql) {
    	   System.out.println(sql);
    	   throw new DirectoryException();
       }    
    }

    static <T extends Person> void SavePerson(T ob) throws DirectoryException {
    	try {
    		Database.SavePerson(ob);
    	} catch (SQLException x) {
    		System.out.println(x);
    		throw new DirectoryException();
    	}	
    }
    
	static <T extends Person> T LoadPerson(String name, String type, T ref) throws DirectoryException {
        
   
    }
	
    static void DeletePerson(String name, String type) throws DirectoryException {
        
        
        
}
    
    static void SaveSchedule(Schedule x) throws DirectoryException {
        
        
    }
    
    static Schedule LoadSchedule() throws DirectoryException {
        
    	
    }
    


