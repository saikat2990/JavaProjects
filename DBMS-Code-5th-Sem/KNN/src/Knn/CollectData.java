package Knn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CollectData {
	
	static int Max = 99999;
	static double[][] arr = new double [Max][3];
	static String [] st = new String[Max];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
		
		
		String line  = reader.readLine();
		int lineNum=0;
		while(line!=null) {
			
			String [] word = line.split(",");
			//System.out.println(word[0]);
			line  = reader.readLine();
			
			for(int i=0;i<3;i++) {
				arr[lineNum][i] = Integer.parseInt(word[i]);
				
			}
			st[lineNum] = word[3];
			lineNum++;
		}
		
		
		
		for(int i=0;i<lineNum;i++) {
			System.out.println(st[i]);
			
			for(int j=0;j<3;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		/*int value = (lineNum/10);
		
		//lol rand 
		Integer[] rand = new Integer[10];
		for(int i=1;i<=value;i++) {
			
			rand[i-1]=i;
		}*/
		
		
		
	}

}