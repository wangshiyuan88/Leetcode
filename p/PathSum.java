package p;

import common.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {

		return hasPathSum(root, sum, 0);
	}

	private boolean hasPathSum(TreeNode root, int sum, int current) {
	
		if(root == null)
			return false;
		
		current = current + root.val;
		if(current > sum)
			return false;
		
		if(root.left==null&&root.right==null){
			if(current == sum)
				return true;
			else 
				return false;
		}
		
		else{
			return hasPathSum(root.left, sum, current)||hasPathSum(root.right, sum, current);
		}
		
	}

}
