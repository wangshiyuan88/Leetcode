package freq3;

import common.ListNode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		   if(head==null||head.next==null)
			   return head;
		   ListNode current = head;
		   while(current!=null&&current.next!=null){
			   while(current.next!=null&&current.next.val==current.val)
				   current.next = current.next.next;
			   current = current.next;
		   }
		   return head;
	    }
}
