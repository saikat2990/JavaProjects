package Knn;

import java.awt.Container;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NewKnn {
	
	
	static double[][] points = {
			{0.935,0.931,0.86,0.942,0.71},
			{0.921,0.12,0.976,0.822,0.92},
			{0.41,0.58,0.73,0.21,0.809},
			{0.71,0.34,0.55,0.19,0.80},
			{0.79,0.45,0.79,0.21,0.44},
			{0.61,0.37,0.34,0.81,0.42},
			{0.78,0.812,0.31,0.83,0.87},
			{0.52,0.23,0.73,0.45,0.78},
			{0.53,0.17,0.63,0.29,0.72},
			{0.12,0.143,0.68,0.49,0.71},
			{0.523,0.17,0.63,0.29,0.72},
			{0.2313,0.312,0.83,0.239,0.272},
			{0.453,0.137,0.763,0.59,0.222},
			{0.593,0.117,0.163,0.129,0.232},
			{0.533,0.147,0.963,0.219,0.272},
			
		};
	
	static int Maxpoint;
	static int attributes;
	public static void main(String[] args) {
		
		
		Maxpoint = 99999;
		attributes  = 5;
		List<House> house = new ArrayList<House>();
		
		house.add(new House(points[0],"B"));
		house.add(new House(points[1],"A"));
		house.add(new House(points[2],"B"));
		house.add(new House(points[3],"C"));
		house.add(new House(points[4],"B"));
		house.add(new House(points[5],"C"));
		house.add(new House(points[6],"C"));
		house.add(new House(points[7],"C"));
		house.add(new House(points[8],"B"));
		house.add(new House(points[9],"C"));
		house.add(new House(points[10],"B"));
		house.add(new House(points[11],"B"));
		house.add(new House(points[12],"C"));
		house.add(new House(points[13],"C"));
		house.add(new House(points[14],"B"));
		
		for(int r=1;r<11;r++) {
			Random rnd = new Random(r);
			int numberOfTrains=7;
			int element = 15;
			
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
			
			House [] trainHouse = new House[numberOfTrains];
			House [] testHouse = new House[element-numberOfTrains];
			
			
			System.out.println("==================");
			
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
			int k=5;
			
			int tr=0,fl=0;
			
			for(House hTrain:trainHouse ){
				///trains
				List<Distanse>distance = new ArrayList<Distanse>();
				
				for(House hTest:testHouse){
					///tests
					
					double join=0.0;
					for(int i=0;i<attributes;i++) {                                               
						///housePoints
						join+=Math.pow((hTrain.housePoint[i]-hTest.housePoint[i]), 2);  
						
					}
					join = Math.sqrt(join);
					distance.add(new Distanse(join,hTest.houseName));
					
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
				
				int [] store = new int [27];
				
				for(int i=0;i<k;i++) {
					store[neighbour[i].charAt(0)-'A']++;
					//System.out.println(neighbour[i].charAt(0));
				}
				char [] ch = new char[27];
				
				for(int i=0;i<27;i++) {
					//System.out.println(store[i]);
					ch[i]=(char)('A'+i);
					//System.out.println(ch[i]);
				}
				
				int max =0;
				
				for(int i=0;i<26;i++) {
					if(max<store[i])max = store[i];
				}
				//System.out.println(max);
				int fre=0;
				
				int [] ixS = new int [27];
				int ix=0;
				for(int i=0;i<26;i++) {
					
					if(max==store[i]) {
						fre++;
						ixS[ix]=i;
						ix++;
					}
				}
				int n=0;
				//System.out.println(max+" "+fre);
				if(fre==1) {
					//System.out.println(ch[ixS[0]]);
				}else {
					
					//System.out.println(ixS[0]+" "+ixS[1]+" "+ixS[2]);
					int num = fre-1;
					Random rn = new Random();
					n = rn.nextInt(num);
					//System.out.println(ch[ixS[n]]);
					
				}
				
				if(hTrain.houseName.charAt(0)==ch[ixS[n]]) {
					tr++;
				}else {
					fl++;
				}
				
				
				
				
				///unify
				/*Set<String>uniqueSet = new HashSet(Arrays.asList(neighbour));
				String [] unValue = uniqueSet.toArray(new String[0]);
				
				for(int i=0;i<unValue.length;i++)System.out.println(unValue[i]);
				System.out.println("==================");
				*/
				
				/*Set<String>uniqueSet = new HashSet();
					
				for(Distanse d:distance) {
					uniqueSet.add(d.houseNo);
				}
				String [] unValue = new String[uniqueSet.size()];
				
				in=0;
				for(String d:uniqueSet) {
					System.out.println(d);
					unValue[in]=d;
					in++;
				}
				System.out.println("==================");
				for(int i=0;i<neighbour.length;i++) {
					System.out.println(neighbour[i]);
				}System.out.println("=================nei=");
				for(int j=0;j<unValue.length;j++) {
					System.out.println(unValue[j]);
				}System.out.println("==================unV");
				int [] index = new int[uniqueSet.size()];
				
				for(int j=0;j<unValue.length;j++)index[j]=0;
				
				for(int i=0;i<neighbourunValue.length;i++) {
					for(int j=0;j<neighbour.length;j++) {
						if(unValue[i].equals(neighbour[j])) {
							index[i]++;
						}
					}
				}
				
				for(int i:index) System.out.println(index[i]);
				*/
				
				
				
				
				
			}
			
			System.out.println(tr+" "+fl);
			double accuracy = ((double)tr/((double)tr+fl));
			System.out.println("accuracy "+accuracy*100+"%" );
			
		
		}
	}
	
}
