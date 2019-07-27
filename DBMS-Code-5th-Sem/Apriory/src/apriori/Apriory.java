package apriori;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeSet;

public class Apriory {

   public static void main(String args[]) throws IOException {
	   	
	    List<String> input = readInput();
	    InputClass master = parserInput(input);
	    
		   for(HashSet<Integer> h:master.storeList) {
			   for(Integer i:h) {
				   //System.out.print(i+",");
			   }
			   //System.out.println();
		   }
		   
		   
	   	HashSet<HashSet<Integer>> candidatekey = new HashSet<HashSet<Integer>>();
	    HashMap<HashSet<Integer>,Integer> frequencyItemMap = new HashMap<HashSet<Integer>,Integer>(); 
		ArrayList<HashSet<Integer>> transaction = master.storeList;
	    
		HashSet<HashSet<Integer>> frequencyItemSet = new HashSet<HashSet<Integer>>();
		///1st class
		
		ArrayList<HashMap<HashSet<Integer>,Integer>>store = new ArrayList<HashMap<HashSet<Integer>,Integer>>();
		
		
		System.out.println("1st class----->");
		
		candidatekey = generateUniqueItem(transaction);
		
		frequencyItemMap = countFrequency(candidatekey,transaction);
		
		frequencyItemMap = eliminateItem(frequencyItemMap,master.minThresHold);
		
		for(Map.Entry<HashSet<Integer>,Integer> c:frequencyItemMap.entrySet()) {
			frequencyItemSet.add(c.getKey());
			System.out.println(c.getKey()+" "+c.getValue());
		}
	    store.add(frequencyItemMap);
		
		///2nd class
		System.out.println("2nd class----->");
		
		candidatekey = generateUniqueItemByJoining(frequencyItemSet,2);
		
		frequencyItemMap = countFrequency(candidatekey,transaction);
		
		frequencyItemMap = eliminateItem(frequencyItemMap,master.minThresHold);
		
		store.add(frequencyItemMap);
		
		frequencyItemSet.clear();
		
		for(Map.Entry<HashSet<Integer>,Integer> c:frequencyItemMap.entrySet()) {
			frequencyItemSet.add(c.getKey());
			System.out.println(c.getKey()+" "+c.getValue());
		}
		
		
		//subClass
		Integer k=3;
		
		while(frequencyItemSet.size()>0) {
			
			System.out.println(k+"th class----->");
			
			candidatekey = generateUniqueItemByJoining(frequencyItemSet,k);
			
			candidatekey = aproirRule(candidatekey,frequencyItemSet);
			
			HashMap<HashSet<Integer>,Integer> previousItemMap = new HashMap<HashSet<Integer>,Integer>(frequencyItemMap);
			
			for(Map.Entry<HashSet<Integer>,Integer> c:previousItemMap.entrySet()) {
				
				System.out.println(c.getKey()+" "+c.getValue());
			}
			
			frequencyItemMap = countFrequency(candidatekey,transaction);
			
			frequencyItemMap = eliminateItem(frequencyItemMap,master.minThresHold);
			
			store.add(frequencyItemMap);
			
			HashMap<HashSet<Integer>,Integer> newItemMap = new HashMap<HashSet<Integer>,Integer>(frequencyItemMap);
			
			
			for(Map.Entry<HashSet<Integer>,Integer> c:newItemMap.entrySet()) {
				
				HashSet<HashSet<Integer>> temp = find(c.getKey());
				
				for(Map.Entry<HashSet<Integer>,Integer> cc:previousItemMap.entrySet()) {
					int tp=0;
					if(temp.contains(cc.getKey())) {
						tp+=cc.getValue();
					}
					//if(tp!=0)System.out.println(c.getKey()+"confidence value ..."+((double)c.getValue()/(double)tp)*100+"%");
				}
				
				//System.out.println(c.getKey()+" "+c.getValue());
			}
			
			
			frequencyItemSet.clear();
			
		   for(Map.Entry<HashSet<Integer>,Integer> entry : frequencyItemMap.entrySet()){
			   	//System.out.println(entry.getKey());
			   	frequencyItemSet.add(entry.getKey());
		   }

		   
		   k=k+1;
		   
	   }
		
		for(HashMap<HashSet<Integer>,Integer>i:store) {
			for(Map.Entry<HashSet<Integer>,Integer>c: i.entrySet()) {
				System.out.println(c.getKey()+" "+c.getValue());
			}
		}
		
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
      
        // Reading data using readLine 
        String firstCatagory = reader.readLine();
        String [] fc = firstCatagory.split(",");
        
        String secondCatagory = reader.readLine();
        String [] sc = secondCatagory.split(",");
		
        System.out.println(fc.length+" "+sc.length);
        if((fc.length+sc.length)>(store.size()-1)) {
        	System.out.println("confidence 0.0%");
        }else {
        	
        	HashSet<Integer>finalSet = new HashSet<Integer>();
        	
        	
        	//create firstSet
        	HashSet<Integer>firstSet = new HashSet<Integer>();
        	for(String s:fc) {
        		firstSet.add(master.itemMap.get(s));
        		System.out.println(master.itemMap.get(s));
        	}
        	
        	TreeSet<Integer> treeSet;
        	treeSet = new TreeSet<Integer>(firstSet);
        	firstSet.clear();
			for(Integer i:treeSet) {
				firstSet.add(i);
				finalSet.add(i);
			}
        	
			//create secondSet
        	HashSet<Integer>secondSet = new HashSet<Integer>();
        	for(String s:sc) {
        		secondSet.add(master.itemMap.get(s));
        		System.out.println(master.itemMap.get(s));
        	}
        	
        	treeSet = new TreeSet<Integer>(secondSet);
        	secondSet.clear();
			for(Integer i:treeSet) {
				secondSet.add(i);
				finalSet.add(i);
			}
			
        	treeSet = new TreeSet<Integer>(finalSet);
        	finalSet.clear();
			for(Integer i:treeSet) {
				finalSet.add(i);
			}
			System.out.println(firstSet+" "+secondSet+" "+finalSet);
        	HashMap<HashSet<Integer>,Integer> ft = store.get(fc.length-1);
        	HashMap<HashSet<Integer>,Integer> sd = store.get(sc.length-1);
        	HashMap<HashSet<Integer>,Integer> f = store.get(sc.length+fc.length-1);
        	
        	
        	
        	
        	Integer lob=0;
        	Integer hor=0;
        	for(Map.Entry<HashSet<Integer>,Integer>c:ft.entrySet()) {
        		
        		
        		HashSet<Integer>temp = c.getKey();
        		boolean tag=true;
        		for(Integer i:temp) {
        			if(!firstSet.contains(i))tag=false;
        		}
        		if(tag) {
        			System.out.println("yeeep find it");
        			hor=c.getValue();
        			System.out.println(c.getValue());
        		}
        		System.out.println(c.getKey());
        	}
        	
        	
        	for(Map.Entry<HashSet<Integer>,Integer>c:f.entrySet()) {
        		
        		HashSet<Integer>temp=c.getKey();
        		boolean tag=true;
        		for(Integer i:temp) {
        			if(!finalSet.contains(i))tag=false;
        		}
        		if(tag) {
        			System.out.println("yeeep find it");
        			lob=c.getValue();
        			System.out.println(c.getValue());
        		}
        		System.out.println(temp+" "+finalSet);

        	}
        	
        	if(hor!=0) {
        		System.out.println(((double)lob/(double)hor)*100+"% confidence");
        	}
        	
        }
        
		System.out.println(store.size()-1);
	} 
   

   private static HashSet<HashSet<Integer>> aproirRule(HashSet<HashSet<Integer>> candidatekey,
		HashSet<HashSet<Integer>> frequencyItemSet) {
	   
	   HashSet<HashSet<Integer>> finalcandidate = new HashSet<HashSet<Integer>>();
	   
	   for(HashSet<Integer> con:candidatekey) {
		   HashSet<HashSet<Integer>> temp = find(con);
		   
		   boolean tag=true;
		   
		   for(HashSet<Integer> c:temp) {
			   if(!frequencyItemSet.contains(c)) {
				   tag=false;
				   break;
			   }
		   }
		   if(tag==true) {
			   finalcandidate.add(con);
		   }
	   }
	   return finalcandidate;
   }


   private static HashSet<HashSet<Integer>> find(HashSet<Integer> con) {
	   HashSet<HashSet<Integer>> subset = new HashSet<HashSet<Integer>>();
	   HashSet<Integer> h;
	   
	   for(Integer i:con) {
		   h = new HashSet<Integer>(con);
		   h.remove(i);
		   subset.add(h);
	   }
		return subset;
	}


   private static HashSet<HashSet<Integer>> generateUniqueItemByJoining(HashSet<HashSet<Integer>> frequencyItemSet,Integer size) {
	   HashSet<HashSet<Integer>> candidateKey = new HashSet<HashSet<Integer>>();
	   
	   for(HashSet<Integer> fA:frequencyItemSet) {
		   for(HashSet<Integer> fB:frequencyItemSet) {
			   
			   HashSet<Integer> store = new HashSet<Integer>();
			   
			   if(fA!=fB) {
				   store.addAll(fA);
				   store.addAll(fB);
			   }
			   //System.out.println("it is in 3rd position"+ store);
			   
			   if(!candidateKey.contains(store)&&store.size()==size) {
				   //System.out.println(store);
				   candidateKey.add(store);
			   }
		   }
	   }
	   
	   for(HashSet<Integer>h : candidateKey) {
		   //System.out.println(h);
	   }
	   return candidateKey;
   }


   private static HashMap<HashSet<Integer>, Integer> eliminateItem(HashMap<HashSet<Integer>, Integer> frequencyItemMap,
		Integer minThresHold) {
	   	
	   HashMap<HashSet<Integer>, Integer> remap = new HashMap<HashSet<Integer>, Integer>();
	   
	   for(Map.Entry<HashSet<Integer>, Integer> entry : frequencyItemMap.entrySet()) {
		   if(entry.getValue()>=minThresHold) {
			   remap.put(entry.getKey(), entry.getValue());
		   }
	   }
	   
	   return remap;
   }


	private static HashMap<HashSet<Integer>, Integer> countFrequency(HashSet<HashSet<Integer>> candidatekey,
			ArrayList<HashSet<Integer>> transaction) {
		   
		   HashMap<HashSet<Integer>,Integer> freItem = new HashMap<HashSet<Integer>, Integer>();
		   
		   for(HashSet<Integer> c:candidatekey) {
			   
			  freItem.put(c, 0);
		   }
		   
		   //System.out.println("candidate");
		   for(HashSet<Integer> c:candidatekey) {
			   for(Integer i:c) {
				   //System.out.print(i);
				   }
			   //System.out.println();
		   }
		   
		   for(HashSet<Integer> h:transaction) {
			   
			   for(Integer i:h) {
				 //  System.out.print(i+",");
			   }
			  // System.out.println("");
		   }
		   
		   for(HashSet<Integer> h:transaction) {
			   for(HashSet<Integer> c:candidatekey) {
				   
				   boolean tag = true;
				   
				   //System.out.println("enique");
				   
				   for(Integer i:c) {
					   //System.out.println(i);
					   if(!h.contains(i)) {
						   tag=false;
						   break;
					   }
				   }
				   
				   if(tag==true) {
					   
					   freItem.put(c, freItem.get(c)+1);
					 //  System.out.println(c+" "+freItem.get(c));
				   }
				   
			   }
		   }
		   
		return freItem;
	}


	private static HashSet<HashSet<Integer>> generateUniqueItem(ArrayList<HashSet<Integer>> transaction) {
		   
		   HashSet<HashSet<Integer>> candidateKey = new HashSet<HashSet<Integer>>();
		   HashSet<Integer> uniqueItem = new   HashSet<Integer>();
		   
		   for(HashSet<Integer>h:transaction) {
			   //uniqueItem.addAll(h);
			   
			   for(Integer i:h) {
				   uniqueItem.add(i);
			   }
			   
		   }
		   
		   for(Integer i:uniqueItem) {
			   HashSet<Integer>  temp = new HashSet<Integer> ();
			   temp.add(i);
			   //System.out.println(i);
			   candidateKey.add(temp);
		   }
		   
		   return candidateKey;
	}


	private static InputClass parserInput(List<String> input) {
	   
	   ListIterator<String> litr = null;
	   InputClass ic = new InputClass();
 
	   litr = input.listIterator();
	   Integer itemNo=1;
	   String temp = litr.next();
	   
	   System.out.println(temp);
	   
	   ic.minThresHold = Integer.parseInt(temp);
	   String [] item;
	   
	   
	   
	   while(litr.hasNext()){
		   
		   temp = litr.next();
		   //System.out.println(temp);
		   item = temp.split(",");
		   HashSet<Integer> itemCount = new HashSet<Integer>();
		   
		   
		   for(String s:item) {
			   
			   s.trim();
			   if(!ic.itemMap.containsKey(s)) {
				   
				   ic.itemMap.put(s, itemNo);
				   ic.hashItem.put(itemNo, s);
				   // System.out.println(s+" "+itemNo);
				   itemNo++;
			   }
			   
			   itemCount.add(ic.itemMap.get(s));
			   
		   }
		   ic.storeList.add(itemCount);
		   
	   }
	   

	   
	   return ic;
   }


	private static ArrayList<String> readInput() throws IOException {
		   
		   ArrayList<String> list = new ArrayList<String>();
		   
	 		String fileName = "data.txt";
	 		try {
				
	 			FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				
				String line="";
				
				while((line=br.readLine())!=null) {
					list.add(line);
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		return list;
	}
	    
}