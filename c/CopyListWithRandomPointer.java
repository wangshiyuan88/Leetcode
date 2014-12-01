package c;

import common.RandomListNode;

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null)
			return head;
		RandomListNode current = head;
		while(current!=null){
			RandomListNode next = current.next;
			current.next = new RandomListNode(current.label);
			current.next.next = next;
			current = next;
		}
		
		current = head;
		while(current!=null){
			RandomListNode next = current.next;
			if(current.random!=null)
			    next.random = current.random.next;
			current = next.next;
		}
		
		RandomListNode newHead = new RandomListNode(-1);
		current = head;
		RandomListNode newCurrent = newHead;
		while(current!=null){
		    newCurrent.next = current.next;
		    current.next = current.next.next;
		    current = current.next;
		    newCurrent = newCurrent.next;
		}
		return newHead.next;
    }
	
	public static void main(String args[]){
		RandomListNode node = new RandomListNode(1);
		node.next = new RandomListNode(2);
		new CopyListWithRandomPointer().copyRandomList(node);
	}
}
