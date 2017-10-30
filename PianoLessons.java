
// This is a piano lessons business program

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class PianoLessons {

    static String[] arguments;

    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        arguments = args;
        
        Teacher Teacher = new Teacher();
        Student Student = new Student();
        TimeCalc timeCalc = new TimeCalc();
        Lesson Lesson;
       
        String choice;
        String nextChoice;
        String nextnextChoice = null;
        
        try {
        	Database db = new Database();
        } catch (SQLException sql) {
        	System.out.println("Error in loading the database");
        }
        
        Schedule Schedule = null;
        try {
        	Schedule = Directory.LoadSchedule();
        } catch (DirectoryException x) {
        	
        }
        	
 
        String userInputString;
        
        boolean run = true;
        boolean run2 = true;
        while (run) {
            try {
        	Display.mainMenu();
            choice = input.nextLine();
            
            //Displays info
            if (choice.equals("1")) {
                
                Display.chooseBetweenTAndS();               
                nextChoice = input.nextLine();
                
                if (nextChoice.equals("1")) {
                    
                	run2 = true;
                	while (run2) {
                		Directory.displayData("teacher"); 
                		System.out.print("\nEnter a Teacher name: ");
                		userInputString = input.nextLine();
                		if (Validate.person(userInputString, "teacher")) {
                			Teacher = Directory.Load(userInputString, "teacher", Teacher);
                			Teacher.displayAttributes();
                			run2 = false;
                		}
                	}
                }
                
                else if (nextChoice.equals("2")) {
                    
                	run2 = true;
                		while (run2) {
                			Directory.displayData("student");
                			System.out.print("\nEnter a Student name: ");
                			userInputString = input.nextLine();
            				if (Validate.person(userInputString, "student")) {
            					Student = Directory.Load(userInputString, "student", Student);
            					Student.displayAttributes();
            					run2 = false;
            				}
                		}
                	}    
                
                else {
                    Display.invalidChoice();   
                }
            }
            
            //adds new teacher or student
            else if (choice.equals("2")) {
                
                Display.chooseBetweenTAndS();
                nextChoice = input.nextLine();
                
                if (nextChoice.equals("2")) {
                    
                    System.out.println("\nIs the student underage?\n");
                    
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    
                    System.out.print("\nEnter a number: ");
                    
                    nextnextChoice = input.nextLine();
                    
                    String sFirstName = null, sLastName = null, sStreet = null;
                	String sCity = null, sZip = null, sBirthdate = null;
                	String pFirstName = null, pLastName = null, pEmailAddress = null, pCellPhone = null;
                	String sEmailAddress = null, sCellPhone = null;
                	
                    if (nextnextChoice.equals("1")) {
                    	
                    	sFirstName = Validate.lettersOnly(input, "\nEnter First Name: ");
                        sLastName = Validate.lettersOnly(input, "\nEnter Last Name: ");		
                    	
                        System.out.print("\nEnter Street: ");
                        sStreet = input.nextLine();
                        
                        sCity = Validate.lettersOnly(input, "\nEnter City: ");
                        sZip = Validate.Zip(input, "\nEnter Zip: ");
                        sBirthdate = Validate.Birthdate(input, "\nEnter Birthdate: ");
                        
                        pFirstName = Validate.lettersOnly(input, "\nEnter Parent's First Name: ");
                        pLastName = Validate.lettersOnly(input, "\nEnter Parent's Last Name: ");		
                        pEmailAddress = Validate.Email(input, "\nEnter Parent's Email Address: ");
                        pCellPhone = Validate.Cell(input, "\nEnter Parent's Cell Phone: ");
                        
                        String sType = "student";
                        
                        Student = new Student(sFirstName, sLastName, sStreet, sCity, 
                        		sZip, sBirthdate, sType, new Parent(pFirstName, 
                        				pLastName, pEmailAddress, pCellPhone));
                        
                        Directory.Save(Student);
                        
                    }
                    
                    else if (nextnextChoice.equals("2")) {
                        
                    	sFirstName = Validate.lettersOnly(input, "\nEnter First Name: ");
                        sLastName = Validate.lettersOnly(input, "\nEnter Last Name: ");		
                    	
                        System.out.print("\nEnter Street: ");
                        sStreet = input.nextLine();
                        
                        sCity = Validate.lettersOnly(input, "\nEnter City: ");
                        sZip = Validate.Zip(input, "\nEnter Zip: ");
                        sEmailAddress = Validate.Email(input, "\nEnter Email Address: ");
                        sCellPhone = Validate.Cell(input, "\nEnter Cell Phone: ");
                        sBirthdate = Validate.Birthdate(input, "\nEnter Birthdate: ");
                        
                        String sType = "student";
                        
                        Student = new Student(sFirstName, sLastName, sStreet,
                                        sCity, sZip, sEmailAddress, sCellPhone,
                                        sBirthdate, sType);
                        
                        Directory.Save(Student);
                        
                    }
                    
                    else {
                        System.out.println("\nInvalid Choice");
                        
                    }
                }
                
                else if (nextChoice.equals("1")) {
                    
                	String tFirstName = null, tLastName = null, tStreet = null;
                    String tCity = null, tZip = null, tEmailAddress = null, tCellPhone = null;
                    String tBirthdate = null;
                    
                    tFirstName = Validate.lettersOnly(input, "\nEnter First Name: ");
                    tLastName = Validate.lettersOnly(input, "\nEnter Last Name: ");		
                	
                    System.out.print("\nEnter Street: ");
                    tStreet = input.nextLine();
                    
                    tCity = Validate.lettersOnly(input, "\nEnter City: ");
                    tZip = Validate.Zip(input, "\nEnter Zip: ");
                    tEmailAddress = Validate.Email(input, "\nEnter Email Address: ");
                    tCellPhone = Validate.Cell(input, "\nEnter Cell Phone: ");
                    tBirthdate = Validate.Birthdate(input, "\nEnter Birthdate: ");
                    
                    String tType = "teacher";
                    
                    Teacher = new Teacher(tFirstName, tLastName, tStreet,
                                            tCity, tZip, tEmailAddress, tCellPhone,
                                            tBirthdate, tType);
                    
                    Directory.Save(Teacher);
                  
                }
                
                else {
                    System.out.println("\nInvalid Choice");
                    
                }
            }
            
            //removes old info
            else if (choice.equals("3")) {
                
                Display.chooseBetweenTAndS();
                nextChoice = input.nextLine();
                
                if (nextChoice.equals("1")) {
                    
                	run2 = true;
                	while (run2) {
                		Directory.displayData("teacher");
                		System.out.print("\nEnter a Teacher name: ");
                		userInputString = input.nextLine();
                		if (Validate.person(userInputString, "teacher")) {
                			Directory.Delete(userInputString, "teacher");
                			run2 = false;
                		}
                		System.out.println("Please select a valid teacher");
                	}
                }
                else if (nextChoice.equals("2")) {
                    
                	run2 = true;
                	while (run2) {
                		Directory.displayData("student");
                		System.out.print("\nEnter a Student name: ");
                		userInputString = input.nextLine();
                		if (Validate.person(userInputString, "student")) {
                			Directory.Delete(userInputString, "student");
                			run2 = false;
                		}
                		System.out.println("Please select a valid student");
                	}
                }
            }
            
            //edit's info
            else if (choice.equals("4")) {
                
                Display.chooseBetweenTAndS();
                nextChoice = input.nextLine();
                
                if (nextChoice.equals("1")) {
                	
                	run2 = true;
                	while (run2) {
                		Directory.displayData("teacher");
                		System.out.print("\nEnter a Teacher name: ");
                		userInputString = input.nextLine();
                		if (Validate.person(userInputString, "teacher")) {
                			Teacher = Directory.Load(userInputString, "teacher", Teacher);
                            Teacher.displayAttributes();
                			run2 = false;
                		}
                		System.out.println("Please select a valid teacher");
                	}
                	
                    System.out.println("\nSelect an Attribute to Edit:");
                
                    System.out.print("\n1. First Name");
                    System.out.print("\n2. Last Name");
                    System.out.print("\n3. Street");
                    System.out.print("\n4. City");
                    System.out.print("\n5. Zip");
                    System.out.print("\n6. Email");
                    System.out.print("\n7. Cell");
                    System.out.print("\n8. Birthdate");
                
                    System.out.print("\n\nEnter a Number: ");
                
                    nextnextChoice = input.nextLine();
                
                    if (nextnextChoice.equals("1")) {
                        Teacher.setFirstName(Validate.lettersOnly(input, "\nEnter new First Name: "));
                    }
                    if (nextnextChoice.equals("2")) {
                        Teacher.setLastName(Validate.lettersOnly(input, "\nEnter new Last Name: "));
                    }
                    if (nextnextChoice.equals("3")) {
                        System.out.print("\nEnter new Street: ");
                        Teacher.setStreet(input.nextLine());
                    }
                    if (nextnextChoice.equals("4")) {
                        Teacher.setCity(Validate.lettersOnly(input, "\nEnter new City: "));
                    }
                    if (nextnextChoice.equals("5")) {
                        Teacher.setZip(Validate.Zip(input, "\nEnter new Zip: "));
                    }
                    if (nextnextChoice.equals("6")) {
                        Teacher.setEmailAddress(Validate.Email(input, "\nEnter new Email: "));
                    }
                    if (nextnextChoice.equals("7")) {
                        Teacher.setCellPhone(Validate.Cell(input, "\nEnter new Cell: "));
                    }
                    if (nextnextChoice.equals("8")) {
                        System.out.print("\nEnter new Birthdate: ");
                        Teacher.setBirthdate(Validate.Birthdate(input, "\nEnter new Birthdate: "));
                    }
                
                    Directory.Save(Teacher);
                    
                    System.out.println(Teacher.getFirstName() + " " + Teacher.getLastName() + " has been updated as following:");
                    Teacher.displayAttributes();
                }
                
                else if (nextChoice.equals("2")) {
                	
                	run2 = true;
                	while (run2) {
                		Directory.displayData("student");
                		System.out.print("\nEnter a Student name: ");
                		userInputString = input.nextLine();
                		if (Validate.person(userInputString, "student")) {
                			Student = Directory.Load(userInputString, "Student", Student);
                            Student.displayAttributes();
                            if (Student.hasParent()) {
                            	Student.mParent.displayAttributes();
                            }
                			run2 = false;
                		} 
                		else {
                			System.out.println("Please select a valid student");
                		}
                	}
                	
                	if (Student.hasParent()) {
                		
                		run2 = true;
                		while (run2) {
                			Display.underageStudentMenu();
                    		System.out.print("\n\nEnter a Number: ");
                    		userInputString = input.nextLine();
                    		if (Validate.underageStudentMenu(userInputString)) {
                    			nextnextChoice = userInputString;
                    			run2 = false;
                    		}
                		}
                	}
                	if (!Student.hasParent()) {
                		
                		run2 = true;
                		while (run2) {
                			Display.adultStudentMenu();
                    		System.out.print("\n\nEnter a Number: ");
                    		userInputString = input.nextLine();
                    		if (Validate.adultStudentMenu(userInputString)) {
                    			nextnextChoice = userInputString;
                    			run2 = false;
                    		}
                		}
                	}
                	
                	
                	if (nextnextChoice.equals("1")) {
                        Student.setFirstName(Validate.lettersOnly(input, "\nEnter new First Name: "));
                    }
                    else if (nextnextChoice.equals("2")) {
                        Student.setLastName(Validate.lettersOnly(input, "\nEnter new Last Name: "));
                    }
                    else if (nextnextChoice.equals("3")) {
                        System.out.print("\nEnter new Street: ");
                        Student.setStreet(input.nextLine());
                    }
                    else if (nextnextChoice.equals("4")) {
                        Student.setCity(Validate.lettersOnly(input, "\nEnter new City: "));
                    }
                    else if (nextnextChoice.equals("5")) {
                        Student.setZip(Validate.Zip(input, "\nEnter new Zip: "));
                    }
                    else if (nextnextChoice.equals("6")) {
                        Student.setBirthdate(Validate.Birthdate(input, "\nEnter new Birthdate: "));
                    }    
                    else if (nextnextChoice.equals("7")) {
                    	Student.setEmailAddress(Validate.Email(input, "\nEnter new Email: "));
                    }
                    else if (nextnextChoice.equals("8")) {
                        Student.setCellPhone(Validate.Cell(input, "\nEnter new Cell: "));
                    }
                    else if (nextnextChoice.equals("9")) {
                        Student.mParent.setFirstName(Validate.lettersOnly(input, "\nEnter new Parent First Name: "));
                    }
                    else if (nextnextChoice.equals("10")) {
                        Student.mParent.setLastName(Validate.lettersOnly(input, "\nEnter new Parent Last Name: "));
                    }
                    else if (nextnextChoice.equals("11")) {
                        Student.mParent.setEmailAddress(Validate.Email(input, "\nEnter new Parent Pmail: "));
                    }
                    else if (nextnextChoice.equals("12")) {
                        Student.mParent.setCellPhone(Validate.Cell(input, "\nEnter new Parent Cell: "));
                    }
                    else {
                        System.out.println("\nInvalid Choice");    
                        }
                	
                	Directory.Save(Student);
                    
                	System.out.println("\n" + Student.getFirstName() + " " + Student.getLastName() + " has been updated as following:");
                    if (Student.hasParent()) {
                    	Student.displayAttributes();
                    	Student.mParent.displayAttributes();
                    }
                    else {
                    	Student.displayAttributes();
                    }
                }        
                else {
                    Display.invalidChoice();   
                }
            }
            
            //Set/Edit teacher availability
            else if (choice.equals("5")) {
                
            	run2 = true;
            	while (run2) {
            		Directory.displayData("teacher"); 
            		System.out.print("\nEnter a Teacher name: ");
            		userInputString = input.nextLine();
            		if (Validate.person(userInputString, "teacher")) {
            			Teacher = Directory.Load(userInputString, "teacher", Teacher);
            			System.out.println("\nAvailability for: " + Teacher.getFirstName() + " " + Teacher.getLastName());
            			Teacher.displayAvailability();
            			run2 = false;
            		}
            	}
         
                timeCalc.excute(input, "Availability");
                Teacher.setAvailability(timeCalc.getThisDay(), timeCalc.getStart(), 
                		timeCalc.getFinish());
                Directory.Save(Teacher);
            }
                
            //display teacher availability settings     
            else if (choice.equals("6")) {
                run2 = true;
                while (run2) {
            	Directory.displayData("teacher"); 
        		System.out.print("\nEnter a Teacher name: ");
        		userInputString = input.nextLine();
        		if (Validate.person(userInputString, "teacher")) {
        			Teacher = Directory.Load(userInputString, "teacher", Teacher);
        			System.out.println("\nAvailability for: " + Teacher.getFirstName() + " " + Teacher.getLastName());
        			Teacher.displayAvailability();
        			run2 = false;
        			}
                }
            }
            
            //Schedule lesson
            else if (choice.equals("7")) {
            	run2 = true;
                while (run2) {
            	Directory.displayData("teacher"); 
        		System.out.print("\nEnter a Teacher name: ");
        		userInputString = input.nextLine();
        		if (Validate.person(userInputString, "teacher")) {
        			Teacher = Directory.Load(userInputString, "teacher", Teacher);
        			run2 = false;
        			}
                }
                run2 = true;
                while (run2) {
            	Directory.displayData("student"); 
        		System.out.print("\nEnter a Student name: ");
        		userInputString = input.nextLine();
        		if (Validate.person(userInputString, "student")) {
        			Student = Directory.Load(userInputString, "student", Student);
        			run2 = false;
        			}
                }
        
                System.out.println("\nAvailability Settings for: " + Teacher.getFirstName() + " " + Teacher.getLastName());
                Teacher.displayAvailability();
                //here we  need to add at least a month worth of actual lessons
                //instead of just displaying the availability setting
                
                timeCalc.excute(input, "Lesson");
                if (Schedule == null) {
                	Schedule = new Schedule();
                }
               
                if (Student.mTeacher == null) {
                	if (Teacher.checkAvailability(timeCalc.getThisDay(), timeCalc.getStart(), 
                			timeCalc.getFinish())) {
                		if (Schedule.checkRegistration(timeCalc.getThisDay(), 
                				timeCalc.getStart(), Teacher)) {
                			System.out.println("\nAvailable dates for first lesson: \n");
                			LocalDateTime z = timeCalc.findNextLesson();
                			System.out.println(z);
                			for (int j = 0; j < 4; j++) {
                				System.out.println(z.toString());
                				z = z.plusDays(7);
                			}
                			
                			LocalDate w = timeCalc.enterDate(input);
                			LocalDateTime y = w.atTime(timeCalc.getStart());
                			Long r = timeCalc.getLessonDuration();
                			if (Schedule.checkLessons(y, r, Teacher)) {
                				Lesson = new Lesson(Teacher, Student, y, r);
                				Schedule.Register(Lesson);
                				Schedule.addToLessons(Lesson);
                				Student.setTeacher(Teacher);
                				Student.setLessonDateTime(y);
                				Teacher.addLesson(Lesson);
                				
                				LocalDate endSeason = Season.returnEndOfSeason(Lesson.mStart.toLocalDate()); 
                				while (Lesson.mStart.toLocalDate().isBefore(endSeason)) {
                					
                					Lesson = new Lesson(Lesson.mTeacher, Lesson.mStudent, 
                							Lesson.mStart, Lesson.mDuration);
                					Lesson.advanceOneWeek();
                					if (Schedule.checkLessons(Lesson.mStart, Lesson.mDuration, Lesson.mTeacher)) {
                						Schedule.addToLessons(Lesson);
                						Teacher.addLesson(Lesson);
                					}
                				}
                				Directory.Save(Teacher);
                				Directory.Save(Student);
                				Directory.SaveSchedule(Schedule);
                			}
                		}
                		else {
                			System.out.println("Teacher already has a student at this time");
                		}
                	}
                	else {
                		System.out.println("Teacher is unavailable at this time");
                	}
                }
                else {
                	System.out.println("Student is already scheduled with another teacher");
                }   
            }
            
            else if (choice.equals("8")) {
            	Schedule.displayLessons();
            }
            //exits program
            else if (choice.equals("x")) {
                
               run = false;
            }
            
            else {
                System.out.println("\nInvalid Choice");
                
            }
        } catch (DirectoryException x) {
        	
        }
        }
    }
}


