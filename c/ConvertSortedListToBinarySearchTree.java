package c;

import common.ListNode;
import common.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	 ListNode current; 
	 public TreeNode sortedListToBST(ListNode head) {
		  if(head==null||head.next==null){
			  return head==null? null : new TreeNode(head.val);
		  }
		  int length = 0;
		  current = head;
		  while(current!=null){
			  length++;
			  current = current.next;
		  }
		  current = head;
		  return convertSortedListToBST(0, length-1);
	  }
	private TreeNode convertSortedListToBST(int start, int end) {
	    if(start>end)
	    	return null;
	    int mid = (start+end)/2;
	    TreeNode left = convertSortedListToBST(start, mid-1);
	    TreeNode root = new TreeNode(current.val);
	    current = current.next;
	    TreeNode right = convertSortedListToBST(mid+1, end);
	    root.left = left;
	    root.right = right;
		return root;
	}
}
