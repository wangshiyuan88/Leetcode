package i;

import common.ListNode;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int al = 0;
        int bl = 0;
        ListNode current = headA;
        while(current!=null){
        	current = current.next;
        	al++;
        }
        current = headB;
        while(current!=null){
        	current = current.next;
        	bl++;
        }
		if(al>bl){
			while(al>bl&&headA!=null){
				headA = headA.next;
				al++;
			}
		}else{
			while(bl>al&&headB!=null){
				headB = headB.next;
				bl++;
			}
		}
		if(headA==null||headB==null)
			return null;
		while(headA!=headB&&headA!=null){
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
    }
}
