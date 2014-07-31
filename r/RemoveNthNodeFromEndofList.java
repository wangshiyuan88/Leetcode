package r;

import common.ListNode;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
	    if(head == null || head.next==null){
	    	return null;
	    }
		 
		 ListNode after = head;
	     ListNode prev = head;
	     while(n>0){
	    	 after = after.next;
	    	 n--;
	     }
	     //Consider the case (1->2, 2)
	     if(after==null){
	         return prev.next;
	     }
	     while(after.next!=null){
	    	 prev = prev.next;
	    	 after = after.next;
	     }
	     
	     prev.next = prev.next.next;
		 return head;
	 }
}
