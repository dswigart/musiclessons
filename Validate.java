import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	
	static String[] args = PianoLessons.arguments;
	public static boolean person(String userInput, String type) {
		
		Path one = Paths.get(args[0] + type);
        
        System.out.println("\n" + type + ": \n");
        
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(one)) {
            for (Path file: stream) { 
            	if (userInput.toLowerCase().equals(file.getFileName().toString().toLowerCase())) {
            		return true;
            	}	
            }
            System.out.println("Name wasn't found in the directory");
			return false;
        } catch (IOException | DirectoryIteratorException exc) {
            System.out.println(exc);
            return false;
        }
	}
	
	private static boolean match(String regex, String userInput) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(userInput);
		boolean b = m.matches();
		return b;
	}
	
	private static String Run(Scanner input, String promptUser, String regex, String errMsg) {
		String userInput;
		
		while (true) {
			System.out.print(promptUser);
			userInput = input.nextLine();
			if (Validate.match(regex, userInput)) {
				return userInput;
			}
			System.out.println(errMsg);
		}
	}
	
	public static String lettersOnly(Scanner input, String usrPrmt) {
		String regex = "[a-zA-z]+";
		String prompt = usrPrmt;
		String errMsg = "only letters A through Z are allowed";
		String value = Validate.Run(input, prompt, regex, errMsg);
		return value;
				
	}
	
	public static String Zip(Scanner input, String usrPrmt) {
		String regex = "[0-9]{5}";
		String prompt = usrPrmt;
		String errMsg = "Please enter a five digit ZIP Code";
		String value = Validate.Run(input, prompt, regex, errMsg);
		return value;
	}
	
	public static String Birthdate(Scanner input, String usrPrmt) {
		String regex = "[1-2][0||9][0-9]{2}[-]([0][0-9]||[1][0-2])[-]([0-2][0-9]||[3][0-1])";
		String prompt = usrPrmt;
		String errMsg = "Please enter date in the following format yyyy-mm-dd";
		String value = Validate.Run(input, prompt, regex, errMsg);
		return value;
	}
	
	public static String Email(Scanner input, String usrPrmt) {
		String regex = "[\\w]+@[\\w]+\\.[a-zA-Z]{3}";
		String prompt = usrPrmt;
		String errMsg = "Please enter an email address in the following format xxxxx@xxxxx.xxx";
		String value = Validate.Run(input, prompt, regex, errMsg);
		return value;
	}
	
	public static String Cell(Scanner input, String usrPrmt) {
		String regex = "([0-9]{3})[-]([0-9]{3})[-]([0-9]{4})";
		String prompt = usrPrmt;
		String errMsg = "Please enter a cell phone in the following format xxx-xxx-xxxx";
		String value = Validate.Run(input, prompt, regex, errMsg);
		return value;
	}
	
	public static boolean adultStudentMenu(String userInput) {
		String regex = "[1-8]";
		boolean value = Validate.match(regex, userInput);
		if (!value) {
			System.out.println("Please enter a number between 1 and 8");
		}
		return value;
	}
	
	public static boolean underageStudentMenu(String userInput) {
		String regex = "[1-6||9||10||11||12]";
		boolean value = Validate.match(regex, userInput);
		if (!value) {
			System.out.println("Please enter a number between 1-6 or 9-12");
		}
		return value;
	}
}

