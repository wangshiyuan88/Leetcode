package m;

import common.TreeNode;

public class MinimumDepthOfBinaryTree {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	    public int minDepth(TreeNode root) {
			if(root == null){
				return 0;
			}
			return minDepthHelper(root);
	    }
	    
	    private int minDepthHelper(TreeNode root){
	    	if(root==null)
				return Integer.MAX_VALUE;
			if(root.left==null&&root.right==null){
				return 1;
			}
			int leftLength = minDepthHelper(root.left);
			int rightLength = minDepthHelper(root.right);
	    	
	    	return 1+ Math.min(leftLength, rightLength);
	    }

	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		new MinimumDepthOfBinaryTree().minDepth(root);
	}
}
