package freq5;

import common.TreeNode;

public class ValidateBinarySearchTree {
//	Given a binary tree, determine if it is a valid binary search tree (BST).
//	Assume a BST is defined as follows:
//	The left subtree of a node contains only nodes with keys less than the node's key.
//	The right subtree of a node contains only nodes with keys greater than the node's key.
//	Both the left and right subtrees must also be binary search trees.
	int current = Integer.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		if(root==null)
			return true;
		boolean left = isValidBST(root.left);
		if(left&&root.val>current){
			current = root.val;
			return isValidBST(root.right);
		}
	    return false;  
	 }
}
