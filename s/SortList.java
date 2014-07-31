package s;


public class SortList {

	public static void main(String args[]){
		new SortList().sortList(null);
	}
	
	public ListNode sortList(ListNode head) {
		head = new ListNode(2);
		head.next = new ListNode(1);
		head = mergeSortList(head);
		return head;
	}

	private ListNode mergeSortList(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode before = head;
		ListNode after = head.next;
		ListNode ptr1 = before;
		ListNode ptr2 = after;
		
		while(true){
			if(after==null){
				before.next = null;
				break;
			}
			if(after.next==null){
				before.next = null;
				after.next = null;
				break;
			}
			
			before.next = before.next.next;
			before = before.next;
			
			after.next = after.next.next;
			after = after.next;
		}
		
		before = mergeSortList(ptr1);
		after = mergeSortList(ptr2);
		
		ListNode ret = merge(before, after);
		
		return ret;
	}
	
	private ListNode merge(ListNode n1, ListNode n2){
		
		ListNode fakeHead = new ListNode(100);
		ListNode current = fakeHead;
		
		while(n1!=null&&n2!=null){
			if(n1.val <= n2.val){
				current.next = n1;
				n1 = n1.next;
			}else{
				current.next = n2;
				n2 = n2.next;
			}
			
			current = current.next;
		}
		
		if(n1==null){
			current.next = n2;
		}else{
			current.next = n1;
		}
		
		return fakeHead.next;
	}
}
