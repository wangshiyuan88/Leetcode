package l;

import common.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		if(head==null)
			return false;
		while(fast!=null&&fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow)
				return true;
		}
		return false;
    }
	
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		if(head==null)
			return null;
		while(fast!=null&&fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow)
				break;
		}
		if(fast==null||fast.next==null)
			return null;
		fast = head;
		while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
    }
}
