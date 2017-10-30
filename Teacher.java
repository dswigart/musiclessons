import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Teacher extends Person {
  
	private static final long serialVersionUID = -6998606385122240852L;

	int mRatePerLesson = 5;
    List<Lesson> Schedule = new ArrayList<Lesson>();
    HashMap<DayOfWeek, TimeObject> Availability = new HashMap<DayOfWeek, TimeObject>();
    
    Teacher(String firstName, String lastName, String street, String city, String zip, 
    		String emailAddress, String cellPhone, String birthdate, String type) {
        
        mFirstName = firstName;
        mLastName = lastName;
        mStreet = street;
        mCity = city;
        mZip = zip;
        mEmailAddress = emailAddress;
        mCellPhone = cellPhone;
        mBirthdate = birthdate;
        mType = type;
        
    }
    
    public Teacher() {
		
	}

	void setAvailability(DayOfWeek thisDay, LocalTime start, LocalTime finish) {
        
        TimeObject Time = new TimeObject(start, finish);
        Availability.put(thisDay, Time);
        
    }
    
    void displayAvailability() {
        
        System.out.println("");
        TimeObject Time = null;
        
        for (int x = 1; x < 8; x++) {
                System.out.println(DayOfWeek.of(x));
                Time = Availability.get(DayOfWeek.of(x));
                if (Time == null) {
                	System.out.println("No set Availability");
                }
                if (Time != null) {
                	System.out.println(Time.mStart + " to " + Time.mFinish);
                }
        System.out.println("");
        }
    }
    
    boolean checkAvailability(DayOfWeek thisDay, LocalTime start, LocalTime finish) {
        
        boolean check = true;
        TimeObject time;
        
        time = Availability.get(thisDay);
        if (time == null) {
        	check = false;
        	return check;
        }
        if (time != null) {
        	if (time.mStart.isBefore(start) && time.mFinish.isAfter(finish)) {
        		check = true;
        		
        	}
        }
        return check;
    }
    
    void addLesson(Lesson x) {
    	Schedule.add(x);
    }
}



