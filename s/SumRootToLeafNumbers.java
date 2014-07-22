package s;

import common.TreeNode;






public class SumRootToLeafNumbers {
	  public int sumNumbers(TreeNode root) {
		  if(root==null)
			return 0;
		int ret = Integer.parseInt(getSumNumber(root));
		return ret;    
	  }

	private String getSumNumber(TreeNode root) {
		if(root==null)
			return null;
		String rootValue = String.valueOf(root.val);
		
		String left = getSumNumber(root.left);
		String right = getSumNumber(root.right);
		int leftValue = left ==null? 0 : Integer.parseInt(rootValue+getSumNumber(root.left));
		int rightValue = right ==null? 0 : Integer.parseInt(rootValue+getSumNumber(root.right));
		
		return String.valueOf(leftValue+rightValue);
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