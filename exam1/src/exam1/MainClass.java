package exam1;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MainClass {
	
	public static void main(String [] args)throws IOException  {
		
		File fp = new File("dataset.txt");
		
		Scanner input = new Scanner(System.in);
		
		long registrationID;
		String str;
		
		//registrationID = 20150515;
		
		Administration ad = new Administration();
		
		ad.initializeStudents(fp);
		ad.showAverageAge();
		
		registrationID =input.nextLong();
		ad.showdDetails(registrationID);
		
		str = input.nextLine();
		
		str = input.nextLine();
		ad.showLastInDepartment(str);
		
		str = input.nextLine();
		ad.showTop3InSession(str);
		
		ad.splitStudentInfo();
		
	}
}
