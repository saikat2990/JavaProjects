package file;

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.filechooser.FileFilter;

public class ListingFile {

	public static void main(String args []) {
		try {
			File dir = new File("D:\\harry potter");
			String [] child  = dir.list();
		
			for(String i:child) {
				System.out.println(i);
			}
		
		
			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return !name.startsWith(".");
				}
			};
		
			child = dir.list(filter);
			File [] files = dir.listFiles();
		
			FileFilter filefilter  = new FileFilter() {
			
			
				@Override
				public boolean accept(File file) {
					// TODO Auto-generated method stub
					return file.isDirectory();
				}

				@Override
				public String getDescription() {
					// TODO Auto-generated method stub
					return null;
				}

			};
		
			files = dir.listFiles((FilenameFilter) filefilter);
			
		}catch(Exception ioe) {
			
			ioe.printStackTrace();
		}
		
		
	}
	
}
