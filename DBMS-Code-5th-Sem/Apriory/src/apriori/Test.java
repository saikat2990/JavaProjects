package apriori;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

public class Test {
	
	  public static void main(String args[]){

		    HashSet<Integer> mp = new HashSet<Integer>();
			mp.add(12);
			mp.add(1);
			mp.add(4);
			
			TreeSet<Integer> treeSet = new TreeSet<Integer>(mp);
			mp.clear();
			
			for(Integer i:treeSet) {
				
				System.out.println(i);
				mp.add(i);
			}
			
		    HashSet<Integer> mp1 = new HashSet<Integer>();
			mp1.add(122);
			mp1.add(11);
			mp1.add(44);
			
			treeSet = new TreeSet<Integer>(mp1);
			mp1.clear();
			
			for(Integer i:treeSet) {
				
				System.out.println(i);
				mp1.add(i);
			}
			
		    HashSet<Integer> mp2 = new HashSet<Integer>();
			mp2.add(1222);
			mp2.add(111);
			mp2.add(444);
			
			treeSet = new TreeSet<Integer>(mp2);
			mp2.clear();
			
			for(Integer i:treeSet) {
				
				System.out.println(i);
				mp2.add(i);
			}
			
			
			HashMap<HashSet<Integer>,Integer>hmp = new HashMap<HashSet<Integer>,Integer>();
			hmp.put(mp, 100);
			hmp.put(mp1, 200);
			hmp.put(mp2,300);
			
			
			ArrayList<HashMap<HashSet<Integer>,Integer>>arl = new ArrayList<HashMap<HashSet<Integer>,Integer>>();
			
			arl.add(hmp);
			
			for(HashMap<HashSet<Integer>,Integer>i:arl) {
				
				 i=arl.get(0);
				for(Map.Entry<HashSet<Integer>,Integer>c: i.entrySet()) {
					/*
					if(c.getKey()==mp2) {
						System.out.println("heea got it");
					}else {
						
						System.out.println("Fuck u");
					}
				*/
					System.out.println(c.getKey()+" "+c.getValue());
				}
			}
			
			
			
	   }
	
}
