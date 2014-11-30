package freq2;

import common.ListNode;

public class ReverseNodesInKGroup {
	 public ListNode reverseKGroup(ListNode head, int k) {
		 if(head == null|| head.next == null || k == 0 || k == 1){
				return head;
			}
		 ListNode fakeHead = new ListNode(-1);
		 fakeHead.next = head;
		 ListNode current = fakeHead;
		 ListNode prev = fakeHead;
		 int counter = k;
		 while(current!=null){
			 if(counter!=0){
				 current = current.next;
				 counter--;
			 }
			 else{
				 ListNode nextGroupHead = current.next;
				 ListNode groupHead = prev.next;
				 ListNode groupHeadNext = groupHead.next;
				 while(groupHead!=current){
					 ListNode temp = groupHeadNext.next;
					 groupHeadNext.next = groupHead;
					 groupHead = groupHeadNext;
					 groupHeadNext = temp;
				 }
				 ListNode temp = prev.next;
				 prev.next = groupHead;
				 prev = temp;
				 prev.next = nextGroupHead;
				 current = prev;
				 counter = k;
			 }
		 }
		 return fakeHead.next;
	  }
	 
	 public static void main(String args[]){
		 ListNode head = new ListNode(1);
		 head.next = new ListNode(2);
		 new ReverseNodesInKGroup().reverseKGroup(head, 2);
	 }
}
