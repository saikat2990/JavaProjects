package AnikaB;

public class Block {
	
	int tNodes;
    //for parent Block and index
    Block parentBlock;
    //values
    String[] stri= new String [20000];
    
    //child Blocks
    Block[] childBlock= new Block [20000];
    
    Block(){ //constructor to initialize a block
		tNodes = 0;
		parentBlock =  null;
		for(int i=0;i<20000;i++)
		{
			stri[i]="৺৺৺৺৺";
			childBlock[i]=null;
		}
    
   
}
}

