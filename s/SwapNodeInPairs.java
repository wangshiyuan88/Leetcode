package s;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	    }
}


public class SwapNodeInPairs {
	 public ListNode swapPairs(ListNode head) {
		 if(head==null|| head.next==null){
			 return head;
		 }
		 
		 ListNode n1 = head,n2, temp;
		 head = head.next;
		 
		 while(n1!=null && n1.next!=null){
			 n2 = n1.next;
			 temp = n1.next;
			 n1.next = n2.next;
			 n2.next = n1;
			 n1 = n1.next;
			 temp.next = n1==null? null : n1.next;
		 }
		 
		 return head;    
	    }
}
