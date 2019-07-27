package spamdetection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class SpamCount {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for(int ii=47;ii<55;ii++) {
	 		Random rn = new Random(ii);
	 		String fileName = "dataset.txt";
			FileReader fr = null;
			
			try {
				fr = new FileReader(fileName);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedReader br = new BufferedReader(fr);
			
			
			String line="";
			Integer totalCount=0;
			Integer rowNumber = 0;
			ArrayList<List<Double>> store = new ArrayList<List<Double>>();
			ArrayList<List<Double>> train = new ArrayList<List<Double>>();
			ArrayList<List<Double>> test = new ArrayList<List<Double>>();
			List<Integer>classStore = new ArrayList<Integer>();
			List<Integer>classtest = new ArrayList<Integer>();
			
			while((line=br.readLine())!=null) {
				
				String [] word ;
				word = line.split(",");
				
				rowNumber=word.length;
				
				List<Double>tp = new ArrayList<Double>();
				
				for(String s:word)
					tp.add(Double.parseDouble(s));
				
				store.add(tp);
				
				
				
				//System.out.println(tp);
				totalCount++;
			}
			
			//System.out.println(store.size() + " "+ totalCount);
			
			
	 		Integer testNumber = (totalCount/10); 
	 		HashSet<Integer>randValue = new HashSet<Integer>();
	 		
	 		
	 		while(true) {
	 			
	 			Integer val = rn.nextInt(totalCount);
	 			randValue.add(val);
	 			if(randValue.size()==testNumber)break;
	 			
	 		}
	 		
	 		
	 		for(Integer i=0;i<totalCount;i++) {
	 			if(randValue.contains(i)) {
	 				test.add(store.get(i));
	 				List<Double>tp = new ArrayList<Double>();
	 				tp=store.get(i);
	 				classtest.add((tp.get(tp.size()-1).intValue()));				
	 			}else {
	 				train.add(store.get(i));
	 				//System.out.println(store.get(i));
	 				List<Double>tp = new ArrayList<Double>();
	 				tp=store.get(i);
	 				classStore.add((tp.get(tp.size()-1).intValue()));
	 			}
	 		}
	 		
	 		//System.out.println(train.size()+" "+test.size()+" "+classStore.size()+classStore);
	 		
	 		List<Double>spam = new ArrayList<Double>(rowNumber);
	 		List<Double>ham = new ArrayList<Double>(rowNumber);
	 		
	 		for(Integer i=0;i<rowNumber;i++) {
	 			spam.add(i, 0.0);
	 			ham.add(i,0.0);
	 			Double sumspam=0.0;
	 			Double sumham=0.0;
	 			
		 		for(Integer j=0;j<classStore.size();j++) {
		 			if(classStore.get(j)==1){
		 				sumspam+=train.get(j).get(i);
		 			}
		 			else{
		 				sumham+=train.get(j).get(i);
		 			}
		 		}
		
		 			spam.add(i,sumspam+1);

		 			ham.add(i,sumham+1); 
	
	 		}
	 		int u=0;
	 		int trueCount=0;
	 		for(List<Double> l:test) {
	 			
	 			///spam
	 			double sps=0.0;
	 			double hms=0.0;
	 			
	 			for(int i=0;i<rowNumber;i++) {
	 				if(l.get(i)!=0.0) {
	 					sps+=Math.log(spam.get(i));
	 					hms+=Math.log(ham.get(i));
	 				}
	 			}
	 			//System.out.println(sps+"in spam "+hms+"in ham"+" in index "+u+1);
	 			
	 			
	 			if(sps>hms && classtest.get(u)==1 )trueCount++;
	 			if(sps<hms && classtest.get(u)==0 )trueCount++;
	 			u++;
	 			
	 		}
	 		System.out.println(((double)trueCount/(double)testNumber)*100+"%");
		}
 		
	}

}
