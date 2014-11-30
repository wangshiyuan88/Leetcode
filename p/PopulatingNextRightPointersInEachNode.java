package p;

import common.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {
	 public void connect(TreeLinkNode root) {
		 if(root == null||root.left==null)
			 return ;
	 
		 TreeLinkNode start = root;
		 while(start.left!=null){
			 root = start;
			 while(root.next!=null){
				 root.left.next = root.right;
				 root.right.next = root.next.left;
				 root = root.next;
			 }
			 root.left.next = root.right;
			 start = start.left;
		 }
	 }
}
