package freq4;

import common.TreeNode;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		return root==null? 0 : sumNumbersHelper(0, root);
    }
	
	
	private int sumNumbersHelper(int prefix, TreeNode root) {
		if(root==null)
			return 0;
		int sum = prefix*10 + root.val;
		if(root.left==null&&root.right==null)
			return sum;
		return sumNumbersHelper(sum, root.left)+sumNumbersHelper(sum, root.right);
	}


	public static void main(String args[]){
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(9);
		root.left.right.right = new TreeNode(5);
		root.right = new TreeNode(5);
		System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
	}
}
