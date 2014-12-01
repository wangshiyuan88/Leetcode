package c;

import common.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
        if(num==null||num.length==0)
        	return null; 	
        return convertArrayToBST(0, num.length-1, num);
    }

	private TreeNode convertArrayToBST(int start, int end, int[] num) {
		if(start>end)
			return null;
		int mid = (start+end)/2;
		TreeNode current = new TreeNode(num[mid]);
		current.left = convertArrayToBST(start,mid-1, num);
		current.right = convertArrayToBST(mid+1, end, num);
		return current;
	}
}
