package r;

import common.ListNode;

public class ReorderList {
	public void reorderList(ListNode head) {
        if(head == null||head.next == null)
        	return;
		ListNode fore = head;
		ListNode after = head;
		while(after.next!=null){
			after = after.next;
			if(after.next==null)
				break;
			after = after.next;
			fore = fore.next;  
		}
		
		
		// What I used before, is not as good as the one used in code now
		
//		while(after.next!=null){
//			fore = fore.next;
//			after = after.next.next; 
//		}
		after = fore.next;
		fore.next = null;
		fore = head;
		
		
		ListNode prev = new ListNode(-1);
		prev.next = after;
		while(after.next!=null){
			ListNode temp = after.next;
			after.next = temp.next;
			temp.next = prev.next;
			prev.next = temp;
		}
		after = prev.next;
		while(after!=null){
			ListNode temp = after.next;
			after.next = fore.next;
			fore.next = after;
			fore = after.next;
			after = temp;
		}
    }
	
	public static void main(String args[]){
		ListNode n1= new ListNode(1);
		n1.next = new ListNode(2);
		n1.next.next = new ListNode(3);
		n1.next.next.next = new ListNode(4);
		new ReorderList().reorderList(n1);
	}
}
