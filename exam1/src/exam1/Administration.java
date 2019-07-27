package exam1;


	//import java.util.Scanner;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	//import java.io.FileWriter;
	import java.io.IOException;

	public class Administration {
		
		Student1 [] ob = new Student1 [15];
		//public void studentcreation()
		private int i=0 ;
		int [] stuage = new int [14];
		long [] stureg = new long [14];
		double [] stucgpa = new double [14];
		String [] dpt = new String[14];
		String [] session = new String[14];
		String [] hall = new String[14];
		Boolean [] tag = new Boolean [14];
		
		
		String  str1,str2,str3,str4,str5;
		
		Student1 temp = new Student1();
		
		public void initializeStudents(File file)throws IOException {
			
			
				
				FileReader fin = new FileReader(file);
				
				BufferedReader br = new BufferedReader(fin);
				
				String line ="";
						
				while(true) {
					
					line = br.readLine();
					
					if(line==null)break;
					
					String [] word = line.split(",");
					
					//for(String s:word)
						//System.out.println(s);
				    if(i!=0) {
				    	
						ob[i-1] = new Student1(word[0], word[1], word[2], word[3], word[4],word[5],word[6]);
					
						//System.out.println(sk[i].getage());
						//str=word[1];
						
						str2 = word[4].replaceAll(" ", "");
						
						stuage[i-1]=Integer.parseInt(str2);
						
					    str1 = word[1].replaceAll("-", "");
					    str1 = str1.replaceAll(" ", "");
					    
					    stureg[i-1] = Long.parseLong(str1);
					    
					    str3 = word[5].replaceAll(" ","");
					    stucgpa[i-1] = Double.parseDouble(str3);
					    
					    str4 = word[2].replaceAll(" ","");
					    dpt[i-1] = str4;
					    
					    str5 = word[3].replaceAll(" ","");
					    session[i-1] = str5;
					    
					    str5 = word[6].replaceFirst(" ", "");
					    hall[i-1] = str5;
					    
				    }
						i++;
					
				}
				
				
			//for(int j=0;j<i;j++)ob[j].tostring();
			
			/*for(int j=0;j<i;j++) {
				System.out.println(stuage[j]);
			}
			
			for(int j=0;j<i;j++) {
				System.out.println(stucgpa[j]);
			}
			
			for(int j=0;j<i-1;j++) {
				System.out.println(hall[j]);
			}*/
			
			br.close();
		
		}
		
		public void showAverageAge() {
			
			double age=0;
			
			for(int j=0;j<i-1;j++) {
				age=age+(double)stuage[j];
			}
			
			double avgage = age/(double)(i-1);
			System.out.println("The average value is "+avgage);
			
			
		}
		
		public void showdDetails(long registrationID) {
			
			for(int j=0;j<i-1;j++) {
				if(stureg[j]==registrationID) {
					ob[j].tostring();
				}
				
				
			}
			
		}
		public void showLastInDepartment(String departmentName) {
			
			double [] rank =new double [15];
			int k=0;
			
			for(int j=0;j<i-1;j++ ) {
				
				if(dpt[j].equals(departmentName)) {
					
					rank[k]=ob[j].getcgpa();
					k++;
					//System.out.println(dpt[j]);
				}
				
			}
			double min;
			min=rank[0];
			for(int j=0;j<k;j++) {
				if(min>rank[j])min=rank[j];
			}
			
			for(int j=0;j<i-1;j++)
				if(ob[j].getcgpa()==min && dpt[j].equals(departmentName))ob[j].tostring();
					
			//System.out.println("lowest cgpa is : "+min);
		}
		
		public void showTop3InSession(String sessionID) {
			
			double [] rank =new double [15];
			int k=0;
			
			for(int j=0;j<i-1;j++ ) {
				
				if(session[j].equals(sessionID)) {
					rank[k]=ob[j].getcgpa();
					k++;
					//System.out.println(dpt[j]);
				}
				
			}
			double min;
			
			for(int j=0;j<k;j++) {
				min = rank[j];
				
				for(int m=0;m<k;m++ ) {
					
					if(min>rank[m]) {
						min=rank[m];
						rank[m]=rank[j];
						rank[j]=min;
					}
					
				} 
			
			}
			for(int j=0;j<i-1;j++ ) {
				
				if(session[j].equals(sessionID) && ob[j].getcgpa()==rank[0]) {
					ob[j].tostring();
				}
				
			}
			for(int j=0;j<i-1;j++ ) {
				
				if(session[j].equals(sessionID) && ob[j].getcgpa()==rank[1]) {
					ob[j].tostring();
				}
				
			}
			for(int j=0;j<i-1;j++ ) {
				
				if(session[j].equals(sessionID) && ob[j].getcgpa()==rank[2]) {
					ob[j].tostring();
				}
				
			}
					
		}
		
	public void splitStudentInfo() throws IOException{
		
		for(int j=0;j<i-1;j++ ) {
			tag[j] = true;
			System.out.println(tag[j]);
		}
		
		for(int j=0;j<i-1;j++ ) {
			
			String hallname;
			hallname = hall[j];
			for(int m=j+1;m<i-1; m++) {
				
				if(hallname.equals(hall[m])) {
					tag[m]=false;
				}
			
			}
			System.out.println(tag[j]);
		}
		
		
		for(int j=0;j<i-1;j++ ) {
			
			if(tag[j]==true) {
				
				File file = new File(hall[j]); 
				System.out.println(hall[j]);
				FileWriter fwrite = new FileWriter(file);
				
				for(int m=0;m<i-1;m++) {
					
					if(hall[j].equals(hall[m])) {
						fwrite.write(ob[m].rakha());
						fwrite.write('\n');
						System.out.println("paisi hall ta re "+hall[m]+"raktisi eta "+ob[m].rakha());
						
					}
				}
				
			
				fwrite.close();
			
			}
		}
		
		
	
		
	}
		
		
}
