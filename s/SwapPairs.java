package s;

public class SwapPairs{

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  
  
  	private void test(){
  		ListNode n1 = new ListNode(1);
  		ListNode n2 = new ListNode(2);
  		ListNode n3 = new ListNode(3);
  		ListNode n4 = new ListNode(4);
  		n1.next = n2;
  		n2.next = n3;
  		n3.next = n4;
  		swapPairs(n1);
  		
  	}
  	
    public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode result = head.next;
		ListNode n1 = head;
		ListNode n2 = null;
		while(n1!=null&&n1.next!=null){
			n2 = n1.next;
			n1.next = n2.next;
			n2.next = n1;
			n1 = n1.next;
		}
		return result;
    }
    
    
    public class B extends SwapPairs{
    	public void test(){
    		
    	}
    }
}
