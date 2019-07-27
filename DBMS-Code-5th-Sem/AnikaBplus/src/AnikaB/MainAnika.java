package AnikaB;


import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class MainAnika {

	static Scanner in= new Scanner(System.in);
	static int numberOfPointers=3;
	Font banglaFont=new Font("Arial Unicode MS", Font.BOLD,15);
	static  Block newChildBlock = new Block();
	//static //String s=null;
	static Block rootblock= new Block();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("à¦…à¦‚à¦¸à¦«à¦²à¦•");
		try {
			//Scanner inFile = new Scanner(new FileInputStream("data.txt"));
			FileInputStream textFile = new FileInputStream ("input.txt");
			Scanner inFile = new Scanner (textFile);
			String Line="";
			int i=0;
			int totalValue=0;
			Vector < Block > Blocks= new Vector<Block>(20000);
			while(inFile.hasNextLine()) {
				Line=inFile.nextLine();
				//System.out.println(Line);
				insertNode(rootblock, Line);
				i++;
				if(i%10000==0)
				{
					System.out.println(Line);
					/*Blocks.clear();
		            Blocks.addElement(rootblock);
		            print(Blocks);*/
				}
			}
			Blocks.clear();
            Blocks.addElement(rootblock);
            print(Blocks);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("Type the word to search in the dictionary" );
		
		//String st = in.next();
		//Dict a= new Dict();
		Dict a= new Dict(rootblock);
		a.main(null);
		//a.Traverse(rootblock, st, 0);
	}
	static void print(Vector < Block > Blocks){
		//Vector < Block > Blocks= new Vector<Block>(150000);
	    Vector < Block > newBlocks =  new Vector<Block>(20000);
	    //Iterator itr = Blocks.iterator();
	    //while()
	    for(Block curBlock : Blocks){ //for every block
	    	//Block curBlock = Blocks[i];
	        System.out.print("[|");
	        
	        int j;
	        for(j=0; j<curBlock.tNodes; j++){//traverse the childBlocks, print values and save all the childBlock
	        	System.out.print( curBlock.stri[j] +"|");
	            
	            if(curBlock.childBlock[j]!=null)
	            newBlocks.addElement(curBlock.childBlock[j]);
	        }
	        if((curBlock.stri[j].compareTo("৺৺৺৺৺")==0) && curBlock.childBlock[j]!=null)
	            newBlocks.addElement(curBlock.childBlock[j]);
	        System.out.print("] ");
	        
	    }
	    System.out.println();

	    if(newBlocks.size()==0){ //if there is no childBlock block left to send out then just the end of the recursion
	    	System.out.println("");
	    	System.out.println("");
	        Blocks.clear();
	        //exit(0);
	    }
	    else {                    //else send the childBlocks to the recursion to continue to the more depth
	    	System.out.println("");
	    	System.out.println("");
	        Blocks.clear();
	        print(newBlocks);
	    }
	}

	static void splitLeaf(Block curBlock){
	    int x, i, j;

	    //split the greater half to the left when numberOfPointer is odd
	    //else split equal equal when numberOfPointer is even
	    if(numberOfPointers%2==1)
	        x = (numberOfPointers+1)/2;

	    else x = numberOfPointers/2;

	    //we don't declare another block for leftBlock, rather re-use curBlock as leftBlock and
	    //take away the right half values to the rightBlock
	    Block rightBlock = new Block();

	    //so leftBlock has x number of nodes
	    curBlock.tNodes = x;
	    //and rightBlock has numberOfPointers-x
	    rightBlock.tNodes = numberOfPointers-x;
	    //so both of them have their common parent [even parent may be null, so both of them will have null parent]
	    rightBlock.parentBlock = curBlock.parentBlock;

	    for(i=x, j=0; i<numberOfPointers; i++, j++){
	        //take the right-half values from curBlocks and put in the rightBlock
	        rightBlock.stri[j] = curBlock.stri[i];
	        //and erase right-half values from curBlock to make it real leftBlock
	        //so that it does not contain all values only contains left-half values
	        curBlock.stri[i] = "৺৺৺৺৺";
	    }
	    //for splitting the leaf blocks we copy the first item from the rightBlock to their parentBlock
	    //and val contains that value
	    String val = rightBlock.stri[0];

	    //if the leaf itself is a parent then
	    if(curBlock.parentBlock==null){
	        //it has null parent, so create a new parent
	        Block parentBlock = new Block();
	        //and new parent should have a null parent
	        parentBlock.parentBlock = null;
	        //new parent will have only one member
	        parentBlock.tNodes=1;
	        //and that member is val
	        parentBlock.stri[0] = val;
	        //so the parent has two child, so assign them (don't forget curBlock is actually the leftBlock)
	        parentBlock.childBlock[0] = curBlock;
	        parentBlock.childBlock[1] = rightBlock;
	        //their parent of the left and right blocks is no longer null, so assign their parent
	        curBlock.parentBlock = rightBlock.parentBlock = parentBlock;
	        //from now on this parentBlock is the rootBlock
	        rootblock = parentBlock;
	        return;
	    }
	    else{   //if the splitted leaf block is not rootBlock then

	        // we have to put the val and assign the rightBlock to the right place in the parentBlock
	        // so we go to the parentBlock and from now we consider the curBlock as the parentBlock of the splitted Block

	        curBlock = curBlock.parentBlock;

	        //for the sake of insertNodeion sort to put the rightBlock and val in the exact position
	        //of th parentBlock [here curBlock] take a new child block and assign rightBlock to it
	      
	        newChildBlock = rightBlock;

	        //simple insertion sort to put val at the exact position of values[] in the parentBlock [here curBlock]

	        for(i=0; i<=curBlock.tNodes; i++){
	            if(val.compareTo(curBlock.stri[i])<0 ) {
	                String temp=curBlock.stri[i];
	                curBlock.stri[i]=val;
	                val=temp;
	            }
	        }

	        //after putting val number of nodes gets increase by one
	        curBlock.tNodes++;

	         //simple insertNodeion sort to put rightBlock at the exact position
	         //of childBlock[] in the parentBlock [here curBlock]

	        for(i=0; i<curBlock.tNodes; i++){
	            if(newChildBlock.stri[0].compareTo(curBlock.childBlock[i].stri[0])<0){
	               
	                Block temp=new Block();
	                temp= curBlock.childBlock[i];
	                curBlock.childBlock[i]=newChildBlock;
	                newChildBlock=temp;
	            }
	        }
	        curBlock.childBlock[i] = newChildBlock;

	        //we reordered some blocks and pointers, so for the sake of safety
	        //all childBlocks' should have their parent updated
	        for(i=0;curBlock.childBlock[i]!=null;i++){
	            curBlock.childBlock[i].parentBlock = curBlock;
	        }
	    }


	}

public static void splitNonLeaf(Block curBlock){
	    int x, i, j;

	    //split the less half to the left when numberOfPointer is odd
	    //else split equal equal when numberOfPointer is even.  n/2 does it nicely for us

	    x = numberOfPointers/2;

	    //declare rightBlock and we will use curBlock as the leftBlock
	    Block rightBlock = new Block();

	    //so leftBlock has x number of nodes
	    curBlock.tNodes = x;
	    //rightBlock has numberOfPointers-x-1 children, because we won't copy and paste
	    //rather delete and paste the first item of the rightBlock
	    rightBlock.tNodes = numberOfPointers-x-1;
	    //both children have their common parent
	    rightBlock.parentBlock = curBlock.parentBlock;


	    for(i=x, j=0; i<=numberOfPointers; i++, j++){
	        //copy the right-half members to the rightBlock
	        rightBlock.stri[j] = curBlock.stri[i];
	        //and also copy their children
	        rightBlock.childBlock[j] = curBlock.childBlock[i];
	        //erase the right-half stris from curBlock to make it perfect leftBlock
	        //which won't contain only left-half stris and their children
	        curBlock.stri[i] = "৺৺৺৺৺";
	        //erase all the right-half childBlocks from curBlock except the x one
	        //because if left child has 3 nodes then it should have 4 childBlocks, so don't delete that child
	        if(i!=x)curBlock.childBlock[i] = null;
	    }

	    //we will take a copy of the first item of the rightBlock
	    //as we will delete that item later from the list
	    String val = rightBlock.stri[0];
	    //just right-shift stri[] and childBlock[] by one from rightBlock
	    //to have no repeat of the first item for non-leaf Block
	    Block newChildBlock2= new Block();
	    for(int p=0;p<curBlock.tNodes;p++)
	    {
	    	if(newChildBlock2.stri[0].compareTo(curBlock.childBlock[p].stri[0])<0)
	    	{
	    		 Block temp=new Block();
	                temp= curBlock.childBlock[i];
	                curBlock.childBlock[i]=newChildBlock2;
	                newChildBlock2=temp;
	    	}
	    }
	   // memcpy(&rightBlock.stri, &rightBlock.stri[1], sizeof(int)*(rightBlock.tNodes+1));
	   // memcpy(&rightBlock.childBlock, &rightBlock.childBlock[1], sizeof(rootblock)*(rightBlock.tNodes+1));
//==>
	    for(int p=0; p<curBlock.tNodes+1; p++) {
	    	
	    	rightBlock.stri[p]=rightBlock.stri[p+1];
	    	rightBlock.childBlock[p]=rightBlock.childBlock[p+1];
	    	
	    }

	    //we reordered some strings and positions so don't forget
	    //to assign the children's exact parent

	    for(i=0;curBlock.childBlock[i]!=null;i++){
	        curBlock.childBlock[i].parentBlock = curBlock;
	    }
	    for(i=0;rightBlock.childBlock[i]!=null;i++){
	        rightBlock.childBlock[i].parentBlock = rightBlock;
	    }

	    //if the splitted block itself a parent
	    if(curBlock.parentBlock==null){
	        //create a new parent
	        Block parentBlock = new Block();
	        //parent should have a null parent
	        parentBlock.parentBlock = null;
	        //parent will have only one node
	        parentBlock.tNodes=1;
	        //the only stri is the val
	        parentBlock.stri[0] = val;
	        //it has two children, leftBlock and rightBlock
	        parentBlock.childBlock[0] = curBlock;
	        parentBlock.childBlock[1] = rightBlock;

	        //and both rightBlock and leftBlock has no longer null parent, they have their new parent
	        curBlock.parentBlock = rightBlock.parentBlock = parentBlock;

	        //from now on this new parent is the root parent
	        rootblock = parentBlock;
	        return;
	    }
	    else{   //if the splitted leaf block is not rootBlock then

	        // we have to put the val and assign the rightBlock to the right place in the parentBlock
	        // so we go to the parentBlock and from now we consider the curBlock as the parentBlock of the splitted Block
	        curBlock = curBlock.parentBlock;

	        //for the sake of insertNodeion sort to put the rightBlock and val in the exact position
	        //of th parentBlock [here curBlock] take a new child block and assign rightBlock to it

	        Block newChildBlock = new Block();
	        newChildBlock = rightBlock;

	        //simple insertion sort to put val at the exact position of stris[] in the parentBlock [here curBlock]


	        for(i=0; i<=curBlock.tNodes; i++){
	            if(val.compareTo(curBlock.stri[i])<0){
	                
	                String temp=curBlock.stri[i];
	                curBlock.stri[i]=val;
	                val=temp;
	            }
	        }

	        //after putting val number of nodes gets increase by one
	        curBlock.tNodes++;

	        //simple insertNodeion sort to put rightBlock at the exact position
	         //of childBlock[] in the parentBlock [here curBlock]

	        for(i=0; i<curBlock.tNodes; i++){
	            if(newChildBlock.stri[0].compareTo(curBlock.childBlock[i].stri[0])<0 ){
	                
	                Block temp=new Block();
	                temp= curBlock.childBlock[i];
	                curBlock.childBlock[i]=newChildBlock;
	                newChildBlock=temp;
	            }
	        }
	        curBlock.childBlock[i] = newChildBlock;

	        //we reordered some blocks and pointers, so for the sake of safety
	        //all childBlocks' should have their parent updated
	         for(i=0;curBlock.childBlock[i]!=null;i++){
	            curBlock.childBlock[i].parentBlock = curBlock;
	        }
	    }

	}

 public static void insertNode(Block curBlock, String vall){
    //cout<<val<<endl;
   // printf("%s\n",vall);
   // printf("%s\n",(curBlock.value[0]));
 
   //cout<<curBlock.value[i]<<endl;
           // printf("%s\n", curBlock.value[i].c_str());

    for(int i=0; i<=curBlock.tNodes; i++){
           // cout<<"lol"<<endl;
            //printf("%s\n", curBlock.value[i].c_str());
        if((vall.compareTo(curBlock.stri[i])<0) && curBlock.childBlock[i]!=null){
                    //cout<<"lol 0000"<<endl;
            insertNode(curBlock.childBlock[i], vall);
            if(curBlock.tNodes==numberOfPointers)
                splitNonLeaf(curBlock);
            return;
        }

        else if((vall.compareTo(curBlock.stri[i])<0)&& curBlock.childBlock[i]==null){
            //swap(curBlock.stri[i], vall);
            //swap(curBlock.childBlock[i], newChildBlock);
            String temp;
            temp= curBlock.stri[i];
            // printf("%s\n",temp.c_str());
            curBlock.stri[i]=vall;
         //   printf("%s\n",curBlock.stri[i].c_str());
            vall=temp;
           // printf("%s\n",vall.c_str());

            //cout<<"lol112"<<endl;

            if(i==curBlock.tNodes){
                   // cout<<"lol112"<<endl;
              // cout<<curBlock.stri[i]<<endl;
                    curBlock.tNodes++;
                    break;
            }
        }
    }

    if(curBlock.tNodes==numberOfPointers){

            splitLeaf(curBlock);
    }
}

}

