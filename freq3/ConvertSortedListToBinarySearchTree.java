package freq3;

import common.ListNode;
import common.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	  ListNode current = null;
		public TreeNode sortedListToBST(ListNode head) {
			int length = 0;
			current = head;
			while(current!=null){
				current = current.next;
				length++;
			}
			current = head;
			return buildTree(0, length-1);
	    }

		private TreeNode buildTree(int start, int end) {
			if(start>end)
				return null;
			int mid = (start+end)/2;
			TreeNode left = buildTree(start, mid-1);
			TreeNode root = new TreeNode(current.val);
			current = current.next;
			TreeNode right = buildTree(mid+1, end);
			root.left = left;
			root.right = right;
			return root;
		}
	
	public static void main(String args[]){
		ListNode node = new ListNode(1);
		new ConvertSortedListToBinarySearchTree().sortedListToBST(node);
	}
}
