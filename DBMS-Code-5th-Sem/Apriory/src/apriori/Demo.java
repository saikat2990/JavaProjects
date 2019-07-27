package apriori;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.swing.SingleSelectionModel;

public class Demo {

	public static void main(String[] args) throws IOException {

		List<String> input = readInput();
		InputClass  masterList = parseInput(input);
		
		   for(HashSet<Integer> h:masterList.storeList) {
			   for(Integer i:h) {
				   System.out.print(i+",");
			   }
			   System.out.println();
		   }
		   
		   

		LinkedHashSet<HashSet<Integer>> frequentItemSet = aprioriAlgorithm(masterList.storeList,masterList.minThresHold,masterList);

		//Display Frequent Item List
		Boolean firstItem;
		for(HashSet<Integer> frequentItem : frequentItemSet) {
			firstItem = true;
			for(Integer itemIndex : frequentItem) {
						if(!firstItem) {
							System.out.print(",");
						} else firstItem = false;
						System.out.print(masterList.hashItem.get(itemIndex));
			}
			System.out.println();
		}

	}

	public static LinkedHashSet<HashSet<Integer>> aprioriAlgorithm(ArrayList<HashSet<Integer>> transaction, Integer minimumSupportCount, InputClass masterList) {

		HashSet<HashSet<Integer>> candidateKey = new HashSet<HashSet<Integer>>();
		HashMap<HashSet<Integer>,Integer> frequentItemMap = new HashMap<HashSet<Integer>, Integer>();
		LinkedHashSet<HashSet<Integer>> retFrequentItemSet = new LinkedHashSet<HashSet<Integer>>();

	//First-Pass
		//Generate Candidate Key of Set Size 1: C1
		candidateKey = generateUniqueItem(transaction);
		
		//Count frequency for candidate Key: L1
		frequentItemMap = countFrequency(candidateKey,transaction);
		
		//Prune L1 based on MST
		frequentItemMap = pruneFrequentItemMap(frequentItemMap, minimumSupportCount);


		//Add to return frequent set
		Boolean firstItem;
		HashSet<HashSet<Integer>> frequentItemSet = new HashSet<HashSet<Integer>>();
		for(Map.Entry<HashSet<Integer>,Integer> entry : frequentItemMap.entrySet()) {
			retFrequentItemSet.add(entry.getKey());
			//Add Item-Set to frequentItemSet for generating candidate key for Pass 2
			frequentItemSet.add(entry.getKey());
		}

	//Second-Pass
		//Generate Candidate Key of Set Size 2: C2 using L1
		candidateKey = generateCandidateKeyByJoining(frequentItemSet,2);
		
		//Count frequency for candidate Key
		frequentItemMap = countFrequency(candidateKey,transaction);			

		//Prune L2 based on MST
		frequentItemMap = pruneFrequentItemMap(frequentItemMap, minimumSupportCount);

		//Add Item-Set to frequentItemSet for generating candidate key for Next Pass
		frequentItemSet.clear();
		for(Map.Entry<HashSet<Integer>,Integer> entry : frequentItemMap.entrySet()) {
			retFrequentItemSet.add(entry.getKey());
			frequentItemSet.add(entry.getKey());
			System.out.println(entry.getKey());
		}
		
	//Subsequent-Pass
		
	    Integer k = 3;
		 
		while(frequentItemSet.size() > 0) {
			//Generate Candidate Key of set size k: C[K] using L[K-1] JOIN L[K-1]
			candidateKey = generateCandidateKeyByJoining(frequentItemSet,k);

			//Prune Candidate Key using Apriori Property
			candidateKey = pruneUsingApriori(candidateKey,frequentItemSet);
			
			//Count frequency for candidate Key
			frequentItemMap = countFrequency(candidateKey,transaction);

			//Filter candidate key based on minimum support threshold
			frequentItemMap = pruneFrequentItemMap(frequentItemMap, minimumSupportCount);

			//Add Item-Set to frequentItemSet for generating candidate key for Next Pass
			frequentItemSet.clear();
			for(Map.Entry<HashSet<Integer>,Integer> entry : frequentItemMap.entrySet()) {
				frequentItemSet.add(entry.getKey());
				retFrequentItemSet.add(entry.getKey());
			}
			
			for(HashSet<Integer>h :frequentItemSet) {
				System.out.println(h);
			}
			k = k + 1;
		}
		
		
		//Generate Frequent Itemset
		return retFrequentItemSet;
	}

	public static HashSet<HashSet<Integer>> generateUniqueItem(ArrayList<HashSet<Integer>> transactions) {

		//Candidate List
		HashSet<HashSet<Integer>> candidateKey = new HashSet<HashSet<Integer>>();
		HashSet<Integer> uniqueItemSet = new HashSet<Integer>();
		//For each transaction find uniqueItem
		for(HashSet<Integer> t : transactions) {
			uniqueItemSet.addAll(t);
		}

		for(Integer uniqueItem : uniqueItemSet) {
			HashSet<Integer> temp = new HashSet<Integer>();
			temp.add(uniqueItem);
			candidateKey.add(temp);
		}
		return candidateKey;
	}

	public static HashSet<HashSet<Integer>> generateCandidateKeyByJoining(HashSet<HashSet<Integer>> seedCandidateKey, Integer setSize) {
		//Generate Candidate key by joining previous frequent item set
		HashSet<HashSet<Integer>> candidateKey = new HashSet<HashSet<Integer>>();
		
		for(HashSet<Integer> candidateKeyItemA : seedCandidateKey) {
			for(HashSet<Integer> candidateKeyItemB : seedCandidateKey) {
				HashSet<Integer> temp = new HashSet<Integer>();
				if(candidateKeyItemA != candidateKeyItemB) {
					temp.addAll(candidateKeyItemA);
					temp.addAll(candidateKeyItemB);
				}
				if(!candidateKey.contains(temp) && temp.size() == setSize) {
					candidateKey.add(temp);
				}
			}
		}

		return candidateKey;
	}

	public static HashMap<HashSet<Integer>, Integer> countFrequency(HashSet<HashSet<Integer>> candidateKeySet, ArrayList<HashSet<Integer>> transactions) {
		//Count frequency of candidate Key in list of transactions
		HashMap<HashSet<Integer>, Integer> frequentItemMap = new HashMap<HashSet<Integer>, Integer>();
		
		for(HashSet<Integer> candidateKey : candidateKeySet) {
			frequentItemMap.put(candidateKey,0);
		}
		
		for(HashSet<Integer> transaction : transactions) {
			for(HashSet<Integer> candidateKey : candidateKeySet) {
				Boolean candidateKeyExist = true;
				for(Integer candidateItem : candidateKey) {
					if(!transaction.contains(candidateItem)) {
						candidateKeyExist = false;
						break;
					}
				}
				if(candidateKeyExist) {
					frequentItemMap.put(candidateKey, frequentItemMap.get(candidateKey)+1);
				}
			}
		}
		return frequentItemMap;
	}

	public static HashMap<HashSet<Integer>, Integer> pruneFrequentItemMap(HashMap<HashSet<Integer>, Integer> frequentItemMap, Integer minimumSupportCount) {
		//Remove any candidate key having support count less than minimum support count
		HashMap<HashSet<Integer>, Integer> retMap = new HashMap<HashSet<Integer>,Integer>();
		for(Map.Entry<HashSet<Integer>,Integer> entry : frequentItemMap.entrySet()) {
			if(entry.getValue() >= minimumSupportCount) {
				retMap.put(entry.getKey(),entry.getValue());
			}
		}
		return retMap;
	}

	public static HashSet<HashSet<Integer>> pruneUsingApriori(HashSet<HashSet<Integer>> candidateKeySet, HashSet<HashSet<Integer>> previousFrequencyItemSet) {
		//For Every Candidate CK to be frequent, its subset has to be frequent also

		HashSet<HashSet<Integer>> frequentItemSet = new HashSet<HashSet<Integer>>();
		HashSet<HashSet<Integer>> candidateKeySubSet;
		for(HashSet<Integer> candidateKey : candidateKeySet) {
			//Find all subset of candidateKey with size K-1
			candidateKeySubSet = findSubset(candidateKey);
			Boolean isAllSubsetFrequent = true;
			for(HashSet<Integer> subSet : candidateKeySubSet) {
				if(!previousFrequencyItemSet.contains(subSet)) {
					isAllSubsetFrequent = false;
					break;
				}
			}
			if(isAllSubsetFrequent) {
				frequentItemSet.add(candidateKey);
			}
		}

		return frequentItemSet;
	}

	public static HashSet<HashSet<Integer>> findSubset(HashSet<Integer> set) {
		//Find all subset of size K-1 for k-size set  
		HashSet<HashSet<Integer>> subset = new HashSet<HashSet<Integer>>();
		HashSet<Integer> tempSet;

		for(Integer i : set) {
			tempSet = new HashSet<Integer>(set);
			tempSet.remove(i);
			subset.add(tempSet);
		}

		return subset;
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

	public static InputClass parseInput(List<String> input) {
		ListIterator<String> litr = null;
		InputClass masterList = null;
		Integer poundPosition;
		String temp;
		if(input.isEmpty()) {
			System.err.println("Error: Please enter Minimum Support Threshold and list of itemset in CSV format");
			System.exit(1);
		}

		//Start Parsing
		masterList = new InputClass();
		litr = input.listIterator();

		//Get First Line of file ignoring comment
		Boolean isFirstLineParsed = false;
		temp = "";
		while(!isFirstLineParsed) {
			temp = litr.next();

			//Ignore comment
			poundPosition = temp.indexOf("#");
			if(poundPosition >= 0) {
				temp = temp.substring(0, poundPosition);	
			}

			if(temp.length() != 0) {
				isFirstLineParsed = true;
			}
		}

		//First Line must be Integer having minimumSupportThreshold
		try {
			masterList.minThresHold = Integer.valueOf(temp);
		} catch(NumberFormatException e) {
			System.err.println("Error: Minimum Support Threshold '" +temp+ "' is not valid Integer.");
			System.exit(1);
		} catch(Exception e) {
			System.err.println("Unexpected Error: " + e.getMessage());
			System.exit(1);
		}

		//Subsequent line must be itemSet in CSV format
		Integer itemNo = 1;
		String[] tempItemList;
		HashSet<Integer> itemSetList;
		while(litr.hasNext()) {
			temp = litr.next();

			//Ignore comment
			poundPosition = temp.indexOf("#");
			if(poundPosition >= 0) {
				temp = temp.substring(0, poundPosition);	
			}

			if(temp.length() == 0) continue; //If line has valid items
			//Split CSV value
			tempItemList = temp.split(",");	//Assuming that no item has comma(,) in its name
			itemSetList = new HashSet<Integer>();

			for(String item : tempItemList) {
				item = item.trim();

				if(item.length() != 0) {
					if(!masterList.itemMap.containsKey(item)) {
						masterList.itemMap.put(item,itemNo);
						masterList.hashItem.put(itemNo,item);
						itemNo++;
					}
					itemSetList.add(masterList.itemMap.get(item));
				}
			}
			masterList.storeList.add(itemSetList);
		}

		return masterList;
	}
}