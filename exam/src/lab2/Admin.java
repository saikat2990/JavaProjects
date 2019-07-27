package lab2;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.FileWriter;
import java.io.IOException;
//import java.util.Arrays;

//import javax.swing.JOptionPane;


public class Admin {
	
	Student [] sk = new Student [13];
	//public void studentcreation()
	private int i=0 ;
	int [] stuage = new int [12];
	
	char [] ch = new char[12];
	String  str;
	
	Student temp = new Student();
	
	public void studentLoading(File file)throws IOException {
		
		
			
			FileReader fin = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fin);
			
			String line ="";
					
			while(true) {
				
				line = br.readLine();
				
				if(line==null)break;
				
				String [] word = line.split(",");
				
				//for(String s:word)
					//System.out.println(s);
				
				sk[i] = new Student(word[0], word[1], word[2], word[3], word[4]);
				
				//System.out.println(sk[i].getage());
				//str=word[1];
				
				stuage[i]=Integer.parseInt(word[3]);
				
				//ch[i]=str[0];
				
			
				
				//System.out.println(line);
				
				i++;
				
			}
			
			
		for(int j=0;j<i;j++)sk[j].tostring();
		br.close();
	
	}
	public void sortingByage() {
		
		 int max=0;
		 
		for(int k=0;k<i;k++) {
			max=stuage[k];
			for(int j=0;j<i;j++) {
				if(max<stuage[j]) {
					temp=sk[j];
					sk[j]=sk[k];
					sk[k]=temp;
				}

			}
			
		}
		
		for(int j=0;j<i;j++)sk[j].tostring();
	}
	
	public void sortingByNmae() {
			
	
		for(int j=0;j<i;j++) {
			
			str=(sk[j].getname());
			
			for(int k=0;k<i;k++) {
				
				if(str.compareTo(sk[k].getname())<0) {
					temp=sk[j];
					sk[j]=sk[k];
					sk[k]=temp;
				}
			}
			
		}
		
		for(int j=0;j<i;j++)sk[j].tostring();
		
	}
 
	public void studentcreation(File file)throws IOException {
		
		FileWriter w = new FileWriter(file,true);
		
		Scanner input = new Scanner(System.in);
		
		String age = input.nextLine();
		String name = input.nextLine();
		String dept = input.nextLine();
		String session = input.nextLine();
		String reg = input.nextLine();
		
		
		
		//w.write(reg+","+name+","+dept+","+age+","+session);
		
		String str =reg+","+name+","+dept+","+age+","+session+'\n';
		w.write(str);
		input.close();
		w.close();
		
		
	}
}
	

