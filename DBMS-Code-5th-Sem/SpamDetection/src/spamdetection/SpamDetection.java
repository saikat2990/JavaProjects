package spamdetection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.Spring;

public class SpamDetection {
	
	public static void main(String[]args) throws IOException {
		
		 
		   ArrayList<String> list = new ArrayList<String>();
		   
	 		String fileName = "dataset.txt";
	 		int spamCount=0,hamCount=0;
	 		///0 for spam 
	 		///1 for ham
	 		
	 		HashSet<String> spamData = new HashSet<String>();
	 		HashSet<String> hamData = new HashSet<String>();
	 		HashSet<String> finalData = new HashSet<String>();
	 		
	 		HashMap<String,Integer> spamMap = new HashMap<String,Integer>();
	 		HashMap<String,Integer> hamMap = new HashMap<String,Integer>();
	 		
	 		ArrayList<List<String>>store = new ArrayList<List<String>>(); 
	 		
	 		
	 		try {
				
	 			FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				
				String line="";
				
				while((line=br.readLine())!=null) {
					
					String [] word ;
					word = line.split(",");
					
					if(word[word.length-1].equals("1")) {
						
						spamCount++;
						
					}else {						
						hamCount++;	
					}
					
					List<String> temp = new ArrayList<String>();
					for(String s:word) {
						
						temp.add(s);
					}
					
					store.add(temp);
					
				}
				
				//System.out.println("");
				//System.out.println(spamData);
				for(String i:finalData) {
					for(Map.Entry<String, Integer>entry:hamMap.entrySet()) {
						//System.out.println(((double)hamMap.get(i)/(double)hamCount)*100+"%");
					}
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		
	 		
	 		int totalCount = spamCount+hamCount;
	 		
	 		Random rn = new Random();
	 		
	 		HashSet<Integer>randValue =new  HashSet<Integer>();
	 		
	 		ArrayList<List<String>>testData = new ArrayList<List<String>>(); 
	 		ArrayList<List<String>>trainData = new ArrayList<List<String>>(); 
	 		
	 		Integer testNumber = (totalCount/10); 
	 		
	 		while(true) {
	 			Integer val = rn.nextInt(totalCount);
	 			randValue.add(val);
	 			if(randValue.size()==testNumber)break;
	 		}
	 		//System.out.println(store.size()+" "+totalCount);
	 		System.out.println(randValue);
	 		
	 		System.out.println(randValue.size()+" "+totalCount);
	 		for(int i=0;i<totalCount;i++){
	 			if(!randValue.contains(i)) {
	 				trainData.add(store.get(i));
	 			}else{
	 				testData.add(store.get(i));
	 			}
	 		}
	 		
	 		List<String> tp = new ArrayList<String>();
	 		tp=testData.get(4);
	 		//System.out.println("hello");
	 		//System.out.println(tp.get(tp.size()-1));
	 		System.out.println("hamsize "+hamCount+"spamSize "+spamCount);
	 		spamCount=0;
	 		hamCount=0;
	 		
	 		for(List<String> l:trainData) {
	 			
				for(int i=0;i<l.size()-1;i++) {
					
					//System.out.print(l.get(i));
					Integer index=l.size()-1;
					if(l.get(index).equals("1")) {
						spamCount++;
						if(!spamData.contains(l.get(i))) {
							spamMap.put(l.get(i), 1);
							spamData.add(l.get(i));
							finalData.add(l.get(i));
							
						}else {
							spamMap.put(l.get(i),spamMap.get(l.get(i))+1);
						}

					}else {
							hamCount++;
						if(!hamData.contains(l.get(i))) {
							hamMap.put(l.get(i), 1);
							hamData.add(l.get(i));
							finalData.add(l.get(i));
							
						}else {
							hamMap.put(l.get(i),hamMap.get(l.get(i))+1);
						}
						
					}
	
				}
			}
	 		
	 		
	 		int hamDataSize = hamData.size();
	 		int spamDataSize = spamData.size();
	 		
	 		System.out.println("hamsize "+hamCount+"spamSize "+spamCount);
	 		for(List<String> l:testData) {
	 			
				for(int i=0;i<l.size()-1;i++) {
					
					double prob=1.0;
					if(finalData.contains(l.get(i))) {
						
						System.out.println(spamMap.get(l.get(i))+" "+hamMap.get(l.get(i)));
						
						////spam
						double spamProb=1.0;
						if(spamData.contains(l.get(i))) {
							spamProb*=((double)spamMap.get(l.get(i))/(double)spamDataSize);
						}else {
							spamProb*=(1-((double)spamMap.get(l.get(i))/(double)spamDataSize));
						}
						
						
						////ham
						double hamProb=1.0;
						if(hamData.contains(l.get(i))) {
							hamProb*=((double)hamMap.get(l.get(i))/(double)hamDataSize);
						}else {
							hamProb*=(1-((double)hamMap.get(l.get(i))/(double)hamDataSize));
						}
						//System.out.println(spamProb+" "+hamProb);
					}
					
				}
			}
	}
	
}
