package m;

import common.ListNode;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current = null;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = current;
		while(l1!=null&&l2!=null){
			if(l1.val>l2.val){
				current = l1;
				l1 = l1.next;
			}else{
				current = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		current = l1==null? l2 : l1;
		return fakeHead.next;
    }
	public static void main(String args[]){
		ListNode l1 = null;
		ListNode l2 = new ListNode(1);
		
		new MergeTwoSortedLists().mergeTwoLists(l1, l2);
	}
}
