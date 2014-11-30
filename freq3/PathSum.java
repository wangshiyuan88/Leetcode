package freq3;

import common.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {      
		return hasPathSum(root, sum, 0);
    }
	
	public boolean hasPathSum(TreeNode root, int sum, int current){
		if(current>sum||root==null)
			return false;
		if(root.left==null&&root.right==null)
			return (current+root.val)==sum;
		current += root.val;
		return hasPathSum(root.left, sum, current)? true : hasPathSum(root.right, sum, current);
	}
}
