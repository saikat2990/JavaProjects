package file;

import java.io.File;

public class Rfi {


	public static void main(String args[]) {
		
		try {
			File file  = new File("C:\\Users\\ASUS\\Desktop\\100CANON");
			
			File dt = new File("C:\\Users\\ASUS\\Desktop\\destination");
			
			boolean success = file.renameTo(new File(dt,file.getName()));
			
			
			if(!success) {
				System.out.println("File Moved"); 
			}
			
		}catch(Exception ioe){
			
			ioe.printStackTrace();
		}
		
		
		
	}
}
