package freq3;

import common.ListNode;

public class RemoveNthNodeFromEndOfList {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
		 ListNode after = head;
		 ListNode prev = head;
		 while(n>0){
			 after = after.next;
			 n--;
		 }
		 if(after==null)
			 return head.next;
		 while(after.next!=null){
			 prev = prev.next;
			 after = after.next;
		 }
		 prev.next = prev.next.next;
		 return head;
	  }
}
