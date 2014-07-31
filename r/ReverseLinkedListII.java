package r;

import common.ListNode;

public class ReverseLinkedListII {
	   public ListNode reverseBetween(ListNode head, int m, int n) {
		   if(head==null||head.next==null){
			   return head;
		   }
		   
		   ListNode fakeHead = new ListNode(-1);
		   fakeHead.next = head;
		   ListNode prev = fakeHead;
		   while(m>1){
			   prev = prev.next;
			   m--;
			   n--;
		   }
		   ListNode cur = prev.next;
		   while(n>1){
			   ListNode temp = cur.next;
			   cur.next = temp.next;
			   temp.next = cur;
			   prev.next = temp;
			   n--;
		   }
		   return fakeHead.next;
	        
	   }
}
