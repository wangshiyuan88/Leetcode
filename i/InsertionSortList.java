package i;

import common.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
		fakeHead.next = head;
		ListNode end = head;
		while(end.next!=null){
			if(end.next.val < end.val){
				ListNode current = end.next;
				end.next = end.next.next;
				ListNode it = fakeHead;
				while(current.val>it.next.val){
					it = it.next;
				}
				current.next = it.next;
				it.next = current;
			}
			else
				end = end.next;
		}
	
		return fakeHead.next; 
    }
	
	public static void main(String args[]){
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		new InsertionSortList().insertionSortList(head);
	}
}
