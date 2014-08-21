package freq4;

import common.ListNode;

public class AddTwoNumbers {
//	You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//			Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//			Output: 7 -> 0 -> 8
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode currentNode = head;
        while(l1!=null||l2!=null||carry!=0){
        	int currentSum = l1==null? 0 : l1.val;
        	currentSum += l2==null? 0 : l2.val;
        	currentSum += carry;
        	currentNode.next = new ListNode(currentSum%10);
        	carry = currentSum/10;
        	l1 = l1==null? null : l1.next;
        	l2 = l2==null? null : l2.next;
        	currentNode = currentNode.next;
        }
		return head.next;
    }
}
