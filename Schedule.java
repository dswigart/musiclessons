import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Schedule implements Serializable {

	private static final long serialVersionUID = -2634776297551164590L;
	
	List<Lesson> Registration;
    HashMap<Month, ArrayList<Lesson>> Lessons;
    
    Schedule() {
    	if (Registration == null) {
    		Registration = new ArrayList<Lesson>();
    	}
    	if (Lessons == null) {
    		Lessons = new HashMap<Month, ArrayList<Lesson>>();
    		for (int x = 1; x < 13; x++) {
    			Lessons.put(Month.of(x), new ArrayList<Lesson>());
    			System.out.println(Month.of(x));
    		}
    	}	
    	for (int y = 1; y < 13; y++) {
    	System.out.println(Lessons.get(y));
    	}
    }
    
    void displayLessons() {
    	
    	 for (Month m : Lessons.keySet()) {
    		 
    		 System.out.println(m);
    		 System.out.println(": \n");
    		 
    		 ArrayList<Lesson> list = Lessons.get(m);
    		 
    		 if (list != null) {
    		 for (int x = 0; x < list.size(); x++) {
    			 Lesson l = list.get(x);
    			 System.out.println(l.mStudent.getName() + " has a lesson with " 
    			 + l.mTeacher.getName() + " at " + l.mStart);
    		 	}
    		} else { System.out.println("No Lessons this month"); }
    	 }
    }
    boolean checkRegistration(DayOfWeek day, LocalTime start, Teacher Teacher) {
        
    	boolean check = true;
        for (int a = 0; a < Registration.size(); a++) {
        	Lesson x = Registration.get(a);
        	if (Teacher.getName().equals(x.mTeacher.getName())) {
        		if (x.mStart.getDayOfWeek().equals(day)) {
        			if (x.mStart.getHour() == (start.getHour())) {
        				if (x.mStart.getMinute() == (start.getMinute())) {
        					check = false;
        					return check;
        				}
        			}
        		}
        	}
        }
        for (int b = 0; b < Registration.size(); b++) {
        	Lesson x = Registration.get(b);
        	LocalTime s = Registration.get(b).mStart.toLocalTime();
        	LocalTime f = Registration.get(b).mFinish.toLocalTime();
        	
        	if (Teacher.getName().equals(x.mTeacher.getName())) {
        		if (s.isBefore(start) && f.isAfter(start)) {
        			check = false;
        			return check;
        		}
        	}
        }					
        return check;  
    }
    
    boolean checkLessons(LocalDateTime y, Long r, Teacher Teacher) {
    	
    	boolean check = true;
    	Month x = y.getMonth();
    	ArrayList<Lesson> z = Lessons.get(x);
    	if (z == null) {
    		System.out.println(" inside null check");
    		return check;
    	}
    	for (int s = 0; s < z.size(); s++) {
    		Lesson t = z.get(s);
    		
    		if (Teacher.getName().equals(t.mTeacher.getName())) {
    			if (t.mStart.equals(y)) {
    				check = false;
    				return check;
    			}
    		}
    	}
    	for (int s = 0; s < z.size(); s++) {
     		Lesson t = z.get(s);
     		if (Teacher.getName().equals(t.mTeacher.getName())) {
     			if (t.mStart.isBefore(y) && t.mFinish.isAfter(y)) {
     				check = false;
     				return check;
     			}
     		}
    	}
    	return check;
    }
    
    void Register(Lesson x) {
    	Registration.add(x);	
    }
    
    void addToLessons(Lesson x) {
    	Month y = x.mStart.getMonth();
    	ArrayList<Lesson> z = Lessons.get(y);
    	z.add(x);
    	Lessons.put(y, z);
    }
    void unRegister() {
    	
    	
    }
}
