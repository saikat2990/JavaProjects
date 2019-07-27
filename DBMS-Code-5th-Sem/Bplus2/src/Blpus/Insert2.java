package Blpus;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;


public class Insert2 {
	
	
	static int numberOfPointers;
	Font banglaFont=new Font("Arial Unicode MS", Font.BOLD,15);
	static  Block newChildBlock = new Block();
	
	static File file2;
	static FileWriter fw;
	
	static Block rootBlock= new Block();
	
	static void splitLeaf( Block curBlock ){
		
	    int x, i, j;

	    int tg = (numberOfPointers%2);
	    if(tg==1) x = (numberOfPointers+1)/2;
	    else  x = numberOfPointers/2;

	    Block rightBlock = new Block();

	    curBlock.tNodes = x;
	    rightBlock.tNodes = numberOfPointers-x;
	    rightBlock.parentBlock = curBlock.parentBlock;

	    for(i=x, j=0; i<numberOfPointers; i++, j++){
	        rightBlock.value[j] = curBlock.value[i];

	        curBlock.value[i] = "৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺";
	    }

	    String val = rightBlock.value[0];

	    if(curBlock.parentBlock==null){
	        Block parentBlock = new Block();
	        parentBlock.parentBlock = null;
	        parentBlock.tNodes=1;
	        parentBlock.value[0] = val;
	        parentBlock.childBlock[0] = curBlock;
	        parentBlock.childBlock[1] = rightBlock;
	        curBlock.parentBlock = rightBlock.parentBlock = parentBlock;
	        rootBlock = parentBlock;
	        return;
	    }
	    else{   


	        curBlock = curBlock.parentBlock;


	        Block newChildBlock = new Block();
	        newChildBlock = rightBlock;

	        for(i=0; i<=curBlock.tNodes; i++){
	        	String temp;
	        	temp = curBlock.value[i];
	            if(temp.compareTo(val)>0){
	            	curBlock.value[i] = val;
	            	val = temp;
	            }
	        }


	        curBlock.tNodes++;


	        for(i=0; i<curBlock.tNodes; i++){
	        	String temp = curBlock.childBlock[i].value[0];
	            if(temp.compareTo(newChildBlock.value[0])>0){
	                //swap(curBlock->childBlock[i], newChildBlock);
	            	curBlock.childBlock[i].value[0] = newChildBlock.value[0];
	            	newChildBlock.value[0] = temp;
	            }
	        }
	        curBlock.childBlock[i] = newChildBlock;

	        for(i=0;curBlock.childBlock[i]!=null;i++){
	            curBlock.childBlock[i].parentBlock = curBlock;
	        }
	    }

	}



	public static void splitNonLeaf(Block curBlock){
	    int x, i, j;


	    x = numberOfPointers/2;

	    Block rightBlock = new Block();

	    curBlock.tNodes = x;
	    rightBlock.tNodes = numberOfPointers-x-1;
	    rightBlock.parentBlock = curBlock.parentBlock;


	    for(i=x, j=0; i<=numberOfPointers; i++, j++){
	    	
	        rightBlock.value[j] = curBlock.value[i];
	        rightBlock.childBlock[j] = curBlock.childBlock[i];

	        curBlock.value[i] = "৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺";
	        if(i!=x)curBlock.childBlock[i] = null;
	    }

	    String val = rightBlock.value[0];

	    int ii;
	    for(ii=0;ii<(rightBlock.tNodes+1);ii++)
	    	rightBlock.value[ii] = rightBlock.value[ii+1];
		for(ii=0;ii<(rightBlock.tNodes+1);ii++)
		    rightBlock.childBlock[ii] = rightBlock.childBlock[ii+1];	
		
	    for(ii=0;curBlock.childBlock[ii]!=null;ii++){
	        curBlock.childBlock[ii].parentBlock = curBlock;
	    }
	    for(i=0;rightBlock.childBlock[i]!=null;i++){
	        rightBlock.childBlock[i].parentBlock = rightBlock;
	    }

	    if(curBlock.parentBlock==null){
	        Block parentBlock = new Block();
	        parentBlock.parentBlock = null;
	        parentBlock.tNodes=1;
	        parentBlock.value[0] = val;
	        parentBlock.childBlock[0] = curBlock;
	        parentBlock.childBlock[1] = rightBlock;
	        curBlock.parentBlock = rightBlock.parentBlock = parentBlock;
	        rootBlock = parentBlock;
	        return;
	    }
	    else{   
	    	
	        curBlock = curBlock.parentBlock;	       
	        Block newChildBlock = new Block();
	        newChildBlock = rightBlock;
	        
	        for(i=0; i<=curBlock.tNodes; i++){
	     	
	        	String temp;
	        	temp = curBlock.value[i];
	            if(temp.compareTo(val)>0){
	            	curBlock.value[i] = val;
	            	val = temp;
	            }
	        }

	        curBlock.tNodes++;


	        for(i=0; i<curBlock.tNodes; i++){

	        	
	        	String temp = curBlock.childBlock[i].value[0];
	            if(temp.compareTo(newChildBlock.value[0])>0){
	                
	            	curBlock.childBlock[i].value[0] = newChildBlock.value[0];
	            	newChildBlock.value[0] = temp;
	            }
	            
	        }
	        curBlock.childBlock[i] = newChildBlock;
	        
	         for(i=0;curBlock.childBlock[i]!=null;i++){
	            curBlock.childBlock[i].parentBlock = curBlock;
	        }
	    }

	}

	static void insertNode(Block curBlock, String val){

	    for(int i=0; i<=curBlock.tNodes; i++){
	        if((curBlock.value[i].compareTo(val)>0) && curBlock.childBlock[i]!=null){
	            insertNode(curBlock.childBlock[i], val);
	            if(curBlock.tNodes==numberOfPointers)
	                splitNonLeaf(curBlock);
	            return;
	        }
	        else if((curBlock.value[i].compareTo(val)>0) && curBlock.childBlock[i]==null){
	            //swap(curBlock.value[i], val);
	        	String temp = val;
	        	val = curBlock.value[i];
	        	curBlock.value[i] = temp;
	        	
	            //swap(curBlock->childBlock[i], newChildBlock);
	            if(i==curBlock.tNodes){
	                    curBlock.tNodes++;
	                    break;
	            }
	        }
	    }

	    if(curBlock.tNodes==numberOfPointers){

	            splitLeaf(curBlock);
	    }
	}
	
	static void print(Vector < Block > Blocks) throws Exception{
		Font banglaFont=new Font("Arial Unicode MS", Font.BOLD,15);
		//Vector < Block > Blocks= new Vector<Block>(65000);
	    Vector < Block > newBlocks =  new Vector<Block>(65000);
	    //Iterator itr = Blocks.iterator();
	    //while()
	    for(Block curBlock : Blocks){ //for every block
	    	//Block curBlock = Blocks[i];
	        //System.out.print("[|");
	        fw.write("[|");
	        
	        int j;
	        for(j=0; j<curBlock.tNodes; j++){//traverse the childBlocks, print values and save all the childBlock
	        	//System.out.print( curBlock.value[j] +"|");
	        	fw.write(curBlock.value[j]+"|");
	            
	            if(curBlock.childBlock[j]!=null)
	            newBlocks.addElement(curBlock.childBlock[j]);
	        }
	        if((curBlock.value[j].compareTo("৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺৺")==0) && curBlock.childBlock[j]!=null)
	            newBlocks.addElement(curBlock.childBlock[j]);
	        //System.out.print("] ");
	        fw.write("]");
	        
	    }
	    //System.out.println();
	    fw.write("\n");

	    if(newBlocks.size()==0){ //if there is no childBlock block left to send out then just the end of the recursion
	    	//System.out.println("");
	    	//System.out.println("");
	    	fw.write("\n");
	    	fw.write("\n");
	        Blocks.clear();
	        //exit(0);
	    }
	    else {                    //else send the childBlocks to the recursion to continue to the more depth
	    	//System.out.println("");
	    	//System.out.println("");
	    	fw.write("\n");
	    	fw.write("\n");
	        Blocks.clear();
	        print(newBlocks);
	    }
	}
	
	static boolean search(Block curBlock,String str) {
		
		boolean tag = false;
		int i;
		
		for( i=0;i<curBlock.tNodes;i++) {
			
			if(curBlock.value[i].equals(str)) {
				
				if(curBlock.childBlock[i+1]==null) {
					tag = true;
					return tag;
				}else tag = search(curBlock.childBlock[i+1],str);
			
			}else {
				
				if((curBlock.value[i].compareTo(str)>0) && (curBlock.childBlock[i]!=null)) {
					tag=search(curBlock.childBlock[i],str);
				}
			}
			if(tag)break;
		}
		if(!tag && curBlock.childBlock[i]!=null) {
			
			tag = search(curBlock.childBlock[i],str);
		}
		
		return tag;
	}
	
	
	public void made(int num) throws Exception {
		
		numberOfPointers = num;
		System.out.println(numberOfPointers);
		Scanner in = new Scanner(System.in);
		//numberOfPointers=num;
		String str;
		//= in.nextLine();
		
		
		//System.out.println(str);
	    //numberOfPointers=400;
		String str1;
		
		//numberOfPointers =  in.nextInt();
		//str1 = in.nextLine();
		System.out.println(" Enter the number of pointers ");
		
	    Vector < Block > Blocks = new Vector<Block>(6500);
		
		
		File file = new File("in1.txt");
		
		FileReader fin = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fin);
		
		String line ="";
		//String str = "saikat";
		
		file2 = new File("output2.txt");
		fw = new FileWriter(file2);
		
		
		while(true) {
			
			line =br.readLine();
			if(line==null)break;
			String [] word = line.split(" ");
			
			for(String s:word) {
				//s.setFont(banglaFont);
				//Font.createFont()
				System.out.println(s);
				insertNode(rootBlock,s);
			}
				
			
			//System.out.println(line);
		}
		
		Blocks.clear();
		Blocks.add(rootBlock);
		print(Blocks);
		
		
		br.close();
		
		System.out.println("DONE");
	}
	
	
	public boolean srch(String input) {
		
		System.out.println("here i am in sech() ");
		Scanner in = new Scanner(System.in);
		String str1;
		str1 = in.nextLine();
		
		if(search(rootBlock,str1)) {
			System.out.println("found");
			return true;
		}else {
			System.out.println("not found");
			return false;
		}
		
		
	}
		/*while(true) {
			
			//Scanner in = new Scanner(System.in);
			
		    str = in.nextLine();
		    System.out.println(str);
			
			if(str.equals("end")) break;
			
			if(search(rootBlock,str)) {
				System.out.println("found");
			}else {
				
				System.out.println("cannot found");
			}
			
		}
			
	}*/
	
	


}
