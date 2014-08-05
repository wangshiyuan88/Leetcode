package freq5;

import common.ListNode;



public class MergeTwoSortedLists {

	//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ListNode fakeHead = new ListNode(-1);
		 ListNode current = fakeHead;
		 while(l1!=null&&l2!=null){
			 if(l1.val<=l2.val){
				 current.next = l1;
				 l1 = l1.next;
			 }else{
				 current.next = l2;
				 l2 = l2.next;
			 }
			 current = current.next;
		 }
		 current.next = (l1==null)? l2 : l1;
		 return fakeHead.next;
	 }
}
