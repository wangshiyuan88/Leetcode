package r;

import common.ListNode;

public class ReverseNodesInKGroup {

	
//  This piece of code is shit
//	public ListNode reverseKGroup(ListNode head, int k) {
//		    
//			if(head==null||head.next==null||k==1||k==0)
//				return head;	
//			ListNode fakeHead = new ListNode(-1);
//			fakeHead.next = head;
//			ListNode pre = fakeHead;
//			ListNode end = head;
//			int counter = 1;
//			
//			while(end.next!=null){
//				end = end.next;
//				counter++;
//				if( counter == k){
//					pre = reverseNodes(pre, end);
//					end = pre.next;
//					counter = 1;
//					if(end==null)
//						break;
//				}
//			}
//			
//			return fakeHead.next;
//	    }
//
//		private ListNode reverseNodes(ListNode pre, ListNode end) {
//			ListNode nextSectionHead = end.next;
//			ListNode newEnd = pre.next;
//			
//			ListNode current = pre.next;
//			ListNode next = current.next;
//			
//			while(current!=end){
//				ListNode temp = next.next;
//				next.next = current;
//			    current = next;
//				next = temp;
//			
//			}
//			
//			pre.next = end;
//			newEnd.next = nextSectionHead;
//			
//			return newEnd;
//		}
//		
	public ListNode reverseKGroup(ListNode head, int k ){
		
		if(head == null|| head.next == null || k == 0 || k == 1){
			return head;
		}
		
		ListNode prv = new ListNode(-1);
		prv.next = head;
		head = prv;
		ListNode current = prv.next;
		int counter = 1;
		
		while(current!=null){
			
			while(counter < k){
				current = current.next;
				counter++;
			}
			
			if(current!=null){		// Try to use it to reverse a linkedlist
				current = prv.next;
			
				while(counter > 1){
					ListNode temp = current.next;
					current.next = temp.next;
					temp.next = current;
					prv.next = temp;
					counter --;          
				}
				prv = current;
				current = current.next;
				
			}
		}
		
		
		return head.next;
	}
	
	
		 public static void main(String args[]){
			 ListNode node = new ListNode(1);
			 node.next = new ListNode(2);
			 new ReverseNodesInKGroup().reverseKGroup(node,3);
		 }
}
