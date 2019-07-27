package decision;


import java.io.IOException;
import java.util.ArrayList;


public class Controller {

	private String [][] testData;
	private String [][] traningData;
	ArrayList< ArrayList< String > > modifiedTestData = new ArrayList< ArrayList< String >  >();
	TreeNode t;
	public void getInputData(String path) throws IOException {
		SeparateTraningAndTestData s = new SeparateTraningAndTestData(path);
		
		
		for(int j=0;j<10;j++) {
			
			testData = s.getTestData();
			traningData = s.getTraningData();
			
			BuildDecisionTree bt = new BuildDecisionTree(traningData);
			TreeNode root = bt.getRoot();
			modifyTestData();
			
			
			
			ArrayList<String> orginalAnswer = new ArrayList<String>();
			ArrayList<String> testAnswer = new ArrayList<String>();
			for(int i=0;i<modifiedTestData.size();i++) {
				orginalAnswer.add(testData[i+1][testData[i+1].length-1]);
				testAnswer.add(  traversTree(root, modifiedTestData.get(i) )  );
			}
			new ResultEvaluation(testAnswer, orginalAnswer);
			t=root;
		}
		
	}
	
	
	public void modifyTestData() {
		modifiedTestData.clear();
		for(int i=1;i<testData.length;i++) {
			ArrayList<String> temp = new ArrayList<String>();
			for(int j=1;j<testData[i].length-1;j++)
				temp.add(testData[i][j]);	
			modifiedTestData.add(temp);
		}
	}


	public String traversTree(TreeNode current , ArrayList<String> test) {
		int index = current.index;	
		String str = test.get(index);
		test.remove(str);
		if(current.child.size()==0) return current.answer;
		if(current.child.get(str)==null) {return "no";}
		return traversTree(current.child.get(str), test);
		
	}
	


 	 TreeNode getTreeNode() {
 		
 		return t;
 	}
 	
	public void printTree(TreeNode current) {
		
		if(current.child.size()>0) {
			
			for(String key : current.child.keySet())
				System.out.print(key+"    ");
			System.out.println();
			for(String key : current.child.keySet()) {
				System.out.println(key+"***************"+current.index+"-------->>>>>>>>>"+current.answer);printTree(current.child.get(key));
			}			
		}
		
		if(current.child.size()==0)
			System.out.println("ans========="+current.answer+"------"+current.index);
		
	}
	
}
