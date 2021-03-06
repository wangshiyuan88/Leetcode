package s;

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
}

/*public int sumNumbers(TreeNode root) {
return sumNumbers(root, 0);
}
private int sumNumbers(final TreeNode node, final int prefix) {
if (node == null) {
    return 0;
}

int ourSum = prefix * 10 + node.val;

if (node.left == null && node.right == null) {
    return ourSum;
} else {
    return sumNumbers(node.left, ourSum) + sumNumbers(node.right, ourSum);            
}
}
*/