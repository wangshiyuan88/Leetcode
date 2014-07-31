package a;

import common.ListNode;

public class AddTwoNumbers {
	  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	       return generateNode(l1, l2, 0); 
	    }
	    private static ListNode generateNode(ListNode l1, ListNode l2, int carry){
	        if(l1==null&&l2==null&&carry==0){
	            return null;
	        }
	        int temp = 0;
	        if(l1 == null&&l2 == null){
	            temp = carry;
	        }else if(l1 == null){
	            temp = carry + l2.val;
	        }else if(l2 == null){
	            temp = carry + l1.val;
	        }else{
	            temp = l1.val + l2.val + carry;
	        }
	        int value = temp%10;
	        carry = temp/10;
	 
	        ListNode current = new ListNode(value);

	        current.next = generateNode(l1==null? null : l1.next, l2 == null? null : l2.next, carry);
	        return current;
	    }
}
