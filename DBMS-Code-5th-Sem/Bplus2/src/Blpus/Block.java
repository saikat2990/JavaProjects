package Blpus;
 
public class Block {
	
	int tNodes;
	String[] value = new String [500];

	Block[] childBlock = new Block[500];
	
	Block parentBlock;
	
	Block() {
		
		
		
		for(int i=0;i<500;i++) {
			
			value[i] = "৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺";
			childBlock[i] = null;
			parentBlock = null;
		}
		
	}
	
	
}
