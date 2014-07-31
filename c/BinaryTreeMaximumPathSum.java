package c;

import common.TreeNode;

public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxPathSumHelper(root);
		return max;
    }
	
	public int maxPathSumHelper(TreeNode root){
		if(root==null)
			return 0;
		int leftMax = maxPathSumHelper(root.left);
		int rightMax = maxPathSumHelper(root.right);
		int valueToCompare = root.val;
		if(leftMax>0){
			valueToCompare += leftMax; 
		}
		if(rightMax>0){
			valueToCompare += rightMax;
		}
		max = Math.max(valueToCompare, max);
		return Math.max(leftMax, rightMax)>0? Math.max(leftMax, rightMax)+root.val: root.val;
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(-1);
		System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
	}
}
