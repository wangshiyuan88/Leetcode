package freq4;

import common.ListNode;

public class SwapNodesInPairs {
//	Given a linked list, swap every two adjacent nodes and return its head.
//	For example,
//	Given 1->2->3->4, you should return the list as 2->1->4->3.
//	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
	
	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode current = fakeHead;
		while(current.next!=null&&current.next.next!=null){
			ListNode temp = current.next;
			current.next = temp.next;
			temp.next = temp.next.next;
			current.next.next = temp;
			current = temp;
		}
		return fakeHead.next;
    }
}
