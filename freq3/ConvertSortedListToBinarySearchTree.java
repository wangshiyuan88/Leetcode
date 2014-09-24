package freq3;

import common.ListNode;
import common.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	ListNode current = null;
	public TreeNode sortedListToBST(ListNode head) {
		current = head;
		return buildTree();
    }

	private TreeNode buildTree(ListNode head) {
		if(head==null)
			return null;
		TreeNode left = buildTree(head);
		TreeNode 
		return null;
	}
}
