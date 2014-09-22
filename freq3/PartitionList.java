package freq3;

import common.ListNode;

public class PartitionList {
//  This solution can destory the original order
//	public ListNode partition(ListNode head, int x) {
//        ListNode before= null, after = null, current = head;
//        while(current!=null){
//        	ListNode next = current.next;
//        	if(current.val>=x){
//        		current.next = after;
//        		after = current;
//        	}else{
//        		current.next = before;
//        		before = current;
//        	}
//        	current = next;
//        }
//        if(before==null)
//        	return after;
//        current = before;
//        while(current.next!=null)
//        	current = current.next;
//        current.next = after;
//		return before;
//    }
	
	public ListNode partition(ListNode head, int x) {
		ListNode beforehead = new ListNode(-1);
		ListNode afterhead = new ListNode(-1);
		ListNode beforeend = beforehead;
		ListNode afterend = afterhead;
        while(head!=null){
        	if(head.val>=x){
        		afterend.next = head;
        		afterend = head;
        	}else{
        		beforeend.next = head;
        		beforeend = head;
        	}
        	head = head.next;
        	beforeend.next = afterend.next = null; //Not ver clear why need to add this line
        }
        beforeend.next = afterhead.next;
		return beforehead.next;
    }
	
	public static void main(String args[]){
		ListNode node = new ListNode(2);
		node.next = new ListNode(1);
		new PartitionList().partition(node, 2);
	}
}
