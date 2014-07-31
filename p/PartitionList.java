package p;

import common.ListNode;

public class PartitionList {
	 public ListNode partition(ListNode head, int x) {
	        if(head==null) return null;
	        
	        ListNode fakeNodeS = new ListNode(0);
	        ListNode fakeNodeL = new ListNode(0);
	        ListNode fakeSHead = fakeNodeS;
	        ListNode fakeLHead = fakeNodeL;

	        while(head!=null){
	            if(head.val<x) {
	                fakeNodeS.next = head;
	                fakeNodeS = fakeNodeS.next;
	            }
	            else{
	                fakeNodeL.next = head;
	                fakeNodeL = fakeNodeL.next;
	            }
	            head = head.next;
	            fakeNodeL.next = fakeNodeS.next = null;//!!!!!!!!!!!!!!!!!
	        }
	        
	        // combine 2 link list
	        fakeNodeS.next=fakeLHead.next;
	        return fakeSHead.next;
	    }
	 
	 public static void main(String args[]){
		 ListNode node = new ListNode(1);
		 node.next = new ListNode(1);
		 new PartitionList().partition(node, 0);
	 }
}
