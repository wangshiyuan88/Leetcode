package freq3;

import common.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		return buildTree(0, num.length-1, num);
    }

	private TreeNode buildTree(int start, int end, int[] num) {
		if(start>end)
			return null;
		int mid = (start+end)/2;
		TreeNode current = new TreeNode(num[mid]);
		current.left = buildTree(start, mid-1, num);
		current.right = buildTree(mid+1, end, num);
		return current;
	}
}
