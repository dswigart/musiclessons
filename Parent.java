
class Parent extends Person {
   
	private static final long serialVersionUID = 6965776211213715848L;

	// Underage student, one parent. *home address is stored with student
    Parent(String firstName, String lastName, String emailAddress, String cellPhone) {
        
        mFirstName = firstName;
        mLastName = lastName;
        mEmailAddress = emailAddress;
        mCellPhone = cellPhone;
       
        
    }
    
   /* // 2nd/divorced parent option. *Parent 2 has its own address
    Parent(String firstName, String lastName, String street, String city, String zip, String emailAddress, String cellPhone) {
        
        mFirstName = firstName;
        mLastName = lastName;
        mStreet = street;
        mCity = city;
        mZip = zip;
        mEmailAddress = emailAddress;
        mCellPhone = cellPhone;
        
    }*/
}
