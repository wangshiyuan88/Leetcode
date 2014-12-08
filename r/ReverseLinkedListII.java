package r;

import common.ListNode;

public class ReverseLinkedListII {
//	   public ListNode reverseBetween(ListNode head, int m, int n) {
//		   if(head==null||head.next==null){
//			   return head;
//		   }
//		   
//		   ListNode fakeHead = new ListNode(-1);
//		   fakeHead.next = head;
//		   ListNode prev = fakeHead;
//		   while(m>1){
//			   prev = prev.next;
//			   m--;
//			   n--;
//		   }
//		   ListNode cur = prev.next;
//		   while(n>1){
//			   ListNode temp = cur.next;
//			   cur.next = temp.next;
//			   temp.next = cur;
//			   prev.next = temp;
//			   n--;
//		   }
//		   return fakeHead.next;
//	        
//	   }
	    public ListNode reverseBetween(ListNode head, int m, int n) {
	        if(head==null||head.next==null||m==n)
	        return head;
	        
	        int count = 1;
	        ListNode fakeHead = new ListNode(-1);
	        fakeHead.next = head;
	        ListNode prev = fakeHead;
	        while(count<m){
	            prev = prev.next;
	            count++;
	        }
	        ListNode current = prev.next;
	        ListNode after = current.next;
	        ListNode newEnd = prev.next;
	        while(m<n){
	            ListNode temp = after.next;
	            after.next = current;
	            current = after;
	            after = temp;
	            m++;
	        }
	        prev.next = current;
	        newEnd.next = after;
	        return fakeHead.next;
	    }
	 public static void main(String []args){
		 ListNode head = new ListNode(1);
		 head.next = new ListNode(2);
		 head.next.next = new ListNode(3);
		 new ReverseLinkedListII().reverseBetween(head, 1, 3);
	 }
}
