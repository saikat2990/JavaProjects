package decision;


import java.util.HashMap;

public class TreeNode {
	int index;
	HashMap<String,TreeNode> child = new HashMap <String,TreeNode>();
	boolean isLeaf;
	String answer;
}