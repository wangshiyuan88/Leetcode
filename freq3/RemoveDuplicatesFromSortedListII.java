package freq3;

import common.ListNode;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		 if(head==null||head.next==null)
		    return head;
		 ListNode fakeHead = new ListNode(-1);
		 fakeHead.next = head;
		 ListNode prev = fakeHead;
		 ListNode cur = head;
		 while(cur!=null&&cur.next!=null){
			 while(cur.next!=null && cur.next.val==cur.val)
				 cur = cur.next;
			 if(cur!=prev.next){
				 prev.next = cur.next;
			     cur =  prev.next;
			 }else{
			    prev = cur;
			    cur = cur.next;
			 }
		 } 
		 return fakeHead.next;
	  }
}
