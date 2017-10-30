
class Display {
    
    static void mainMenu() {
        
        System.out.println("\nDirectory Options:");
        
        System.out.println("\n1. Display Info");
        System.out.println("2. Add New");
        System.out.println("3. Remove Old");
        System.out.println("4. Edit Current");
        
        System.out.println("\nSchedule Options:");
        
        System.out.println("\n5. Set/Edit Teacher Availability");
        System.out.println("6. Display Teacher Availability Settings");
        System.out.println("7. Schedule Lessons");
        
        System.out.println("\nTo Exit:");
        System.out.println("\nx. Exit Program");
        
        System.out.print("\nEnter a number: ");   
    }
    
    static void chooseBetweenTAndS() {
    	
    	System.out.println("\n\nDisplay info on:\n");
    
    	System.out.println("1. Teachers");
    	System.out.println("2. Students and Parents");
    
    	System.out.print("\nEnter a number: "); 
    }
    
    static void fileErrMessage() {
    	System.out.println("\nThe File could not be found. Entries are case "
    			+ "sensitive and must be entered in the following "
    			+ "format: firstname.lastname");
    }
    
    static void invalidChoice() {
    	System.out.println("\nInvalid Choice");
    }
    
    public static void adultStudentMenu() {
    	System.out.println("\nSelect a Student Attribute to Edit:");
        
        System.out.print("\n1. First Name");
        System.out.print("\n2. Last Name");
        System.out.print("\n3. Street");
        System.out.print("\n4. City");
        System.out.print("\n5. Zip");
        System.out.print("\n6. Birthdate");
        
        System.out.println("\n\nAdult Student Attributes:");
        
        System.out.print("\n7. Email");
        System.out.print("\n8. Cell");
    }
    
    public static void underageStudentMenu() {
    	System.out.println("\nSelect a Student Attribute to Edit:");
        
        System.out.print("\n1. First Name");
        System.out.print("\n2. Last Name");
        System.out.print("\n3. Street");
        System.out.print("\n4. City");
        System.out.print("\n5. Zip");
        System.out.print("\n6. Birthdate");
        
        System.out.println("\n\nUnderage Student Attributes:");
        
        System.out.print("\n9. Parent First Name");
        System.out.print("\n10. Parent Last Name");
        System.out.print("\n11. Parent Email");
        System.out.print("\n12. Parent Cell");
    }
    
    
}
