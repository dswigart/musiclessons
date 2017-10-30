import java.time.LocalDateTime;

class Student extends Person {
    
	private static final long serialVersionUID = -110408056243228889L;
	
	Teacher mTeacher;
	//Date value is irrelevant
    LocalDateTime mLessonDayTime;
    private int mLevel;
    protected Parent mParent;
    
    
    // underage student, one parent
    Student(String firstName, String lastName, String street, String city, 
    		String zip, String birthdate, String type, Parent Parent) {
        
        mFirstName = firstName;
        mLastName = lastName;
        mStreet = street;
        mCity = city;
        mZip = zip;
        mBirthdate = birthdate;
        //mLevel = level;
        mType = type;
        mParent = Parent;
        
    }
    
  /*  //underage student, two parents
    Student(String firstName, String lastName, String street, String city, String zip, String birthdate, int level, Parent Parent, Parent Parent2) {
        
        mFirstName = firstName;
        mLastName = lastName;
        mStreet = street;
        mCity = city;
        mZip = zip;
        mBirthdate = birthdate;
        mLevel = level;
        mParent = Parent;
        mParent2 = Parent2;
        
    }*/
    
    // Adult student
    Student(String firstName, String lastName, String street, String city, 
    		String zip, String emailAddress, String cellPhone, 
    		String birthdate, String type) {
        
        mFirstName = firstName;
        mLastName = lastName;
        mStreet = street;
        mCity = city;
        mZip = zip;
        mEmailAddress = emailAddress;
        mCellPhone = cellPhone;
        mBirthdate = birthdate;
        //mLevel = level;
        mType = type;
        
    }
    
    public Student() {
		//default constructor
	}

	Parent getParent() {
        return mParent;
        
    }
    
	boolean hasParent() {
		if (getParent() == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
    void setTeacher(Teacher x) {
    	mTeacher = x;
    }
    
    void setLessonDateTime(LocalDateTime x) {
    	//Date value is irrelevant
    	mLessonDayTime = x;
    }
}
