package m;

import java.util.ArrayList;
import java.util.List;

import common.ListNode;

public class MergeKSortedList {

	 public ListNode mergeKLists(List<ListNode> lists) {
		 if(lists==null || lists.size()==0){
	    	 return null;
	     }
		 int size = lists.size();
		 while(size>1){
			 int start = 0;
			 int end = size-1;
			while(start<end){
				 ListNode mergedListHead = mergeTwoLists(lists.get(start),lists.get(end));
				 lists.set(start, mergedListHead);
				 start++;
				 end--;
			 }
			 
			 size = size%2==0? size/2 : size/2+1;
		 }
		 
		 return lists.get(0);
	   }
	 
	 //0 1 2 3
	 //0 1 2

	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode fakeHead = new ListNode(-1);
	        ListNode current = fakeHead;
	        while(l1!=null&&l2!=null){
	        	if(l1.val<l2.val){
	        		current.next = l1;
	        		l1 = l1.next;
	        	}else{
	        		current.next = l2;
	        		l2 = l2.next;
	        	}
	        	current = current.next;
	        }
	        current.next = l1==null? l2 : l1;
			
			return fakeHead.next;
	    }
	
	public static void main(String args[]){
		List<ListNode> lists = new ArrayList<>();
		lists.add(null);
		lists.add(new ListNode(-2));
		ListNode node = new ListNode(-3);
		node.next = new ListNode(-2);
		node.next.next = new ListNode(-1);
		lists.add(node);
		new MergeKSortedList().mergeKLists(lists);
	}
}
