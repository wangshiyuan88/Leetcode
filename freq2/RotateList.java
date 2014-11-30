package freq2;

import common.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
        if(head==null||head.next==null||n==0)
        	return head;
        ListNode current = head;
        int length = 1;
		while(current.next!=null){
			current = current.next;
			length++;
		}
		n = n%length;
		if(n==0)
			return head;
		current = head;
		while(n>0){
			current = current.next;
			n--;
		}
		ListNode newEnd = head;
		while(current.next!=null){
			newEnd = newEnd.next;
			current = current.next;
		}
		current.next = head;
		head = newEnd.next;
		newEnd.next = null;
		return head;
    }
}
