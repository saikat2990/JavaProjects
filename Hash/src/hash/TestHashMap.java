package hash;

import java.util.Map;
import java.util.TreeMap;

public class TestHashMap {
	public static void main(String []args) {
		
		Map<Integer,Book>map = new  TreeMap<Integer,Book>();
	
		Book b1 = new Book(101,"Let us C","Yashkanetker","BPB",8);
		Book b2 = new Book(101,"DCN","Yashkanetker","BPB",8);
		Book b3 = new Book(101,"OS","Yashkanetker","BPB",8);
	
		map.put(2,b2);
		map.put(1, b1);
		map.put(3, b3);
		
		for(Map.Entry<Integer, Book>entry:map.entrySet()) {
			
			int key = entry.getKey();
			Book b = entry.getValue();
			System.out.println(key+"Details");
			System.out.println(b.id+" "+b.author+" "+b.name+" "+b.publisher);
			
		}
		
		
		
	}
	
}
