package r;

import common.ListNode;

public class RotateList {

	  public ListNode rotateRight(ListNode head, int n) {
	     
		  if(head==null||head.next==null||n == 0){
	           return head;
	       }
		  
		  ListNode current = head;
		  int length = 0;
		  while(current!=null){
			  current = current.next;
			  length++;
		  }
	     
		  n = length - n%length;
		  
		  current.next = head;
		  current = head;
		  
		  while(n-- > 1){
			  current = current.next;
		  }
		  
		  head = current.next;
		  current.next = null;
		  return head;
	  }
}
