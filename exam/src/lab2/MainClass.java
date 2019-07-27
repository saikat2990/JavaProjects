package lab2;

import java.io.File;
import java.io.IOException;

//import javax.swing.JOptionPane;

public class MainClass {

	public static void main(String[] args)throws IOException  {
		// TODO Auto-generated method stub
		//JOptionPane.showInputDialog(null,"asya");
		
		//Student [] sk = new Student [13];
		File file = new File("studentstucture.txt");
		
		Admin ad = new Admin();
		
		ad.studentLoading(file);
		//ad.studentcreation(file);
		//ad.studentLoading(file);
		ad.sortingByNmae();
		ad.sortingByage();
		ad.studentcreation(file);
	}

}
