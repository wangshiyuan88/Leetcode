package freq4;

import java.util.List;

import common.ListNode;

public class MergeKSortedLists {
	  public ListNode mergeKLists(List<ListNode> lists) {
		  if(lists==null || lists.size()==0)
		    	 return null;
		  int listToMerge = lists.size();
		  while(listToMerge>1){
			  int start = 0;
			  int end = listToMerge-1;
			  while(start<end){
				  ListNode fakeHead = new ListNode(-1);
				  ListNode current = fakeHead;
				  ListNode n1 = lists.get(start);
				  ListNode n2 = lists.get(end);
				  while(n1!=null&&n2!=null){
					  if(n1.val<n2.val){
						  current.next = n1;
						  n1 = n1.next;
					  }else{
						   current.next = n2;
						   n2 = n2.next;
					  }
					  current = current.next;
				  }
				  current.next = n1==null? n2 : n1;
				  lists.set(start, fakeHead.next);
				  start++;
				  end--;
			  }
			  listToMerge = listToMerge%2==0? listToMerge/2 : listToMerge/2+1;
		  }
		  
		  return lists.get(0);
	  }
}
