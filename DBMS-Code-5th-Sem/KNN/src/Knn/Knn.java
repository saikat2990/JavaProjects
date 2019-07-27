package Knn;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Knn {
	
	static int Maxpoint=99999;
	static double[][] points = new double [Maxpoint][3];
	
	static String [] st = new String[Maxpoint];
	
	
	static int attributes;
	public static void main(String[] args) throws IOException {
	
		attributes  = 3;
		BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
			
			
			String line  = reader.readLine();
			int lineNum=0;
			while(line!=null) {
				
				String [] word = line.split(",");
				//System.out.println(word[0]);
				line  = reader.readLine();
				
				for(int i=0;i<attributes;i++) {
					points[lineNum][i] = Double.parseDouble(word[i]);
					
				}
				st[lineNum] = word[3];
				lineNum++;
			}
		
		List<House> house = new ArrayList<House>();
		for(int i=0;i<lineNum;i++) {
			
			house.add(new House(points[i],st[i]));
		}
		
		int numberOfTrains=(lineNum/10);
		int element = lineNum;
		
		/*house.add(new House(points[0],"2"));
		house.add(new House(points[1],"1"));
		house.add(new House(points[2],"2"));
		house.add(new House(points[3],"3"));
		house.add(new House(points[4],"2"));
		house.add(new House(points[5],"3"));
		house.add(new House(points[6],"1"));
		house.add(new House(points[7],"1"));
		house.add(new House(points[8],"2"));
		house.add(new House(points[9],"3"));
		house.add(new House(points[10],"2"));
		house.add(new House(points[11],"2"));
		house.add(new House(points[12],"3"));
		house.add(new House(points[13],"3"));
		house.add(new House(points[14],"1"));*/
		
		double cal=0.0;
		for(int r=1;r<11;r++) {
			Random rnd = new Random(r);

			
			Set<Integer>val = new HashSet<Integer>();
			
			while(true) {
				
				val.add(rnd.nextInt(element));
				if(val.size()==numberOfTrains)break;
			}
			
			Integer [] storeTrains = val.toArray(new Integer[0]);
			int [] storeTrainsIndex = new int [numberOfTrains+1];
			boolean [] tag = new boolean [element+1];
			
			
			for(int i=0;i<element;i++) {
				tag[i]=false;
			}
			
			
			for(int i=0;i<numberOfTrains;i++) {
				storeTrainsIndex[i] = storeTrains[i];
				//System.out.println(storeTrainsIndex[i]);
				tag[storeTrainsIndex[i]] = true;
			}
			int yy=element-numberOfTrains;
					
			House [] trainHouse = new House[numberOfTrains];
			House [] testHouse = new House[yy];
			
			
			//System.out.println(numberOfTrains+" "+yy);
			
			int itag=0,itest=0,itrains=0;
			
			for(House h:house) {
				if(tag[itag]==false) {
					testHouse[itest]=(h);
					//System.out.println(itag+"test"+testHouse[itest].houseName);
					itest++;
				}else {
					
					trainHouse[itrains] = (h);
					//System.out.println(itag);
					itrains++;
				}
				itag++;
			}
			
			///number of neighbours
			int k=3;
			
			int tr=0,fl=0;
			
			for(House hTrain:trainHouse ){
				///trains
				List<Distanse>distance = new ArrayList<Distanse>();
				int uu=0;
				for(House hTest:testHouse){
					///tests
					
					double join=0.0;
					for(int i=0;i<attributes;i++) {                                               
						///housePoints
						//System.out.println(hTrain.housePoint[i]+" "+hTest.housePoint[i]+" "+uu);
						join+=Math.pow((hTrain.housePoint[i]-hTest.housePoint[i]), 2);  
						
					}
					join = Math.sqrt(join);
					distance.add(new Distanse(join,hTest.houseName));
					uu++;
				}
				
				//sort
				Collections.sort(distance,new DistaseCompare());
				
				String [] neighbour = new String[k];
				int in=0;
				for(Distanse d:distance) {
					//System.out.println(d.distance+d.houseNo);
					neighbour[in] = d.houseNo;
					in++;
					if(in==k)break;
				}
				//System.out.println("==================");
				
				Set<String>uniqueSet = new HashSet();
				in =0;
				for(Distanse d:distance) {
					uniqueSet.add(d.houseNo);
					//System.out.println(d.houseNo);
					in++;
					if(in==k)break;
				}//System.out.println("==================");
				
				String [] unValue = new String[uniqueSet.size()];
				
				in=0;
				for(String d:uniqueSet) {
					//System.out.println(d);
					unValue[in]=d;
					in++;
				}
				
				//System.out.println("==================");
				for(int i=0;i<neighbour.length;i++) {
					//System.out.println(neighbour[i]);
				}//System.out.println("=================nei=");
				for(int j=0;j<unValue.length;j++) {
					//System.out.println(unValue[j]);
					
				}
				//System.out.println(unValue.length);
				//System.out.println("==================unV");
				int [] index = new int[uniqueSet.size()];
				
				for(int j=0;j<unValue.length;j++)index[j]=0;
				
				for(int i=0;i<unValue.length;i++) {
					for(int j=0;j<neighbour.length;j++) {
						if(unValue[i].equals(neighbour[j])) {
							index[i]++;
						}
					}
				}
				
				//for(int j=0;j<unValue.length;j++)System.out.println(index[j]);
				
				int max=index[0];
				for(int i=0;i<index.length;i++) {
					if(max<index[0]) {
						max=index[0];
					}
				}
				
				int fre=0;
				int [] ix = new int [index.length];
				for(int i=0;i<index.length;i++) {
					if(max==index[i]) {
						ix[fre] = i;
						fre++;
					}
				}
				
				int n=0;
				if(fre==1) {
					
				}else {
					
					int num = fre-1;
					Random rn = new Random();
					n = rn.nextInt(num);
					
				}
				
				if(hTrain.houseName.equals(unValue[ix[n]])) {
					//System.out.println("yeahh--------------");
					tr++;
				}else {
					fl++;
				}
				
				
				
			}
			
			System.out.println(tr+" "+fl);
			double accuracy = ((double)tr/((double)tr+fl));
			cal+=accuracy;
			System.out.println("accuracy "+accuracy*100+"%" );
			
		
		}
		System.out.println("Final accuracy "+cal*10+"%" );
	}
	
}
