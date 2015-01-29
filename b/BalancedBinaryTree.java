package b;

import common.TreeNode;

public class BalancedBinaryTree {
	  public static boolean isBalanced(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        int result = checkHeight(root);
	        return result == -1? false : true;
	    }
	    public static int checkHeight(TreeNode root){
	        if(root == null){
	            return 0;
	        }
	        int leftHeight = checkHeight(root.left);
	        int rightHeight = checkHeight(root.right);
	        if(leftHeight!=-1&&rightHeight!=-1){
	            return Math.abs(leftHeight-rightHeight)>1? -1 : (leftHeight >= rightHeight)? 1+leftHeight : 1+ rightHeight;
	        }
	        else
	            return -1;
	    }
}
