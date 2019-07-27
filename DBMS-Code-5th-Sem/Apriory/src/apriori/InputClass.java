package apriori;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class InputClass {
	
	public Integer minThresHold;
	public ArrayList<HashSet<Integer>> storeList;
	public HashMap<String, Integer>itemMap;
	public HashMap<Integer,String>hashItem;
	
	public InputClass() {
		minThresHold =0;
		storeList = new ArrayList<HashSet<Integer>>();
		itemMap = new HashMap<String, Integer>();
		hashItem = new HashMap<Integer,String>();
	}
	
}
