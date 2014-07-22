package r;

import common.ListNode;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = head;
		ListNode after = head.next;

		while (after != null) {
			if (prev.val == after.val) {
				prev.next = after.next;
				if (prev.next == null)
					break;
			}
            
            else
			    prev = prev.next;
			after = after.next;
		}

		return head;
	}
	
	
	public ListNode deleteDuplicatesII(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode prev = fakeHead;
		ListNode current = fakeHead.next;
		
		while(current!=null){
			if(current.next!=null && current.val == current.next.val){
				current = current.next;
				while(current!=null && current.val == prev.next.val){
					current = current.next;
				}
				prev.next = current;
			}
			else{
				prev = current; 
				current = current.next;
			}
		
		}
		return fakeHead.next;
    }
}
