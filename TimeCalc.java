import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

/*  This class is poorly designed. It breaks a lot of best practices
 *  and it is not loosely coupled. For instance,
 *  enterday() and entertime() must be run before execute()
 *  and conversion(). This will result in accidental errors and unneccessary programming steps
 *  making this class unsuitable for reuse. entereddate() must be run before
 *  findnextlesson(). etc. One possible solution would
 *  be to create a constructor and refigure the main piano lessons program.
 */
public class TimeCalc {
	
	String day = null;
    int startHour = 0; 
    int startMinute = 0; 
    Long LessonDuration = 0L;
    
    DayOfWeek[] weekArray = null;
    boolean run2;
    
    void excute(Scanner input, String control) {
    	
    	this.enterDay(input);
    	this.enterTime(input, control);
    	this.conversions();
    }
    
    void enterDay(Scanner input) {
    	run2 = true;
    	while (run2) {
        
    		System.out.print("\nEnter a Day of the Week:");
    
    		day = input.nextLine().toUpperCase();
    		weekArray = DayOfWeek.values();
    		for (DayOfWeek x : weekArray) {
    			if (day.equals(x.toString())) {
    				run2 = false;
    			}
    		}  
    		if (run2) {
    			System.out.println("\nInvalid choice. Please enter a valid day of the week");
    		}
    	}
    }
    
    /* control can be set to "Lesson" or "Availability" */
    void enterTime(Scanner input, String control) {
    	run2 = true;
    	while (run2) {
            System.out.print("\nEnter the Hour of the Start Time (24 hour. Ex. '14'): ");
            startHour = Integer.parseUnsignedInt(input.nextLine());
            
            System.out.print("Enter the Minute of the Start Time (up to 59): ");
            startMinute = Integer.parseUnsignedInt(input.nextLine());
            
            System.out.println("Enter a duration for the Availability/Lesson: ");
            Integer x = Integer.parseUnsignedInt(input.nextLine());
            LessonDuration = x.longValue();
            
            if (startHour > 23) {
                System.out.println("\nInvalid entry. Make sure to enter an hour below 24:00");
            }
            else if (startMinute > 59) {
                System.out.println("\nInvalid entry. Make sure to enter a minute below 00:60");
            }
            else if (control.equals("Lesson") && LessonDuration > 61) {
            	System.out.println("\nInvalid entry. Lesson max is 60 minutes");
            }
            else {
                run2 = false;
            }
    	}
    }  
    
    
    LocalTime start = null, finish = null;
    DayOfWeek thisDay = null;
    
    void conversions() {
    	start = LocalTime.of(startHour, startMinute);
    	finish = start.plusMinutes(LessonDuration);
    	for (int x = 0; x < weekArray.length; x++) {
    		if (weekArray[x].toString().equals(day)) {
    			thisDay = weekArray[x];
    		}
    	}
    }
    
    LocalDate Date = null;
    LocalDate enterDate(Scanner input) {
    	//Using Birthdate from validate even though this is not a Birthdate.
    	 Date = LocalDate.parse(Validate.Birthdate(input, "\nEnter the date "
    	 		+ "of the first lesson in the following format (YYYY-MM-DD): "));
    	 return Date;
    }
    
    LocalDateTime findNextLesson() {
    	LocalDate x = LocalDate.now();
    	LocalDateTime y = null;
    	run2 = true;
    	while (run2) {
    		if (x.getDayOfWeek().equals(thisDay)) {
    			y = x.atTime(start);
    			run2 = false;
    		}
    		else {
    			x = x.plusDays(1);
    		}
    	}
    	return y;
    }
    
    
    LocalTime getStart() {
    	return start;
    }
    
    LocalTime getFinish() {
    	return finish;
    }
    
    Long getLessonDuration() {
    	return LessonDuration;
    }
    
    DayOfWeek getThisDay() {
    	return thisDay;
    }
    
    LocalDate getDate() {
    	return Date;
    }
}

    
