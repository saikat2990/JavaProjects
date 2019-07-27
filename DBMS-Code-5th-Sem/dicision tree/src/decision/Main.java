package decision;


import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Controller c = new Controller();
		c.getInputData("data.txt");
		TreeNode t = c.getTreeNode();
		c.printTree(t);
	}	
}