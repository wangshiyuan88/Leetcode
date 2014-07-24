package s;

public class SortList {
	public ListNode sortList(ListNode head){
		if(head==null||head.next==null){
			return head;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		
		while(slow!=null||fast!=null){
			if(fast.next!=null){
				fast.next = fast.next.next;
				fast = fast.next;
			}
			
		}
		return null;
	}
	
	public ListNode merge(ListNode n1, ListNode n2){
		return null;
	}
}
