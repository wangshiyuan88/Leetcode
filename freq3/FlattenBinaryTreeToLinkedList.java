package freq3;

import common.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	 public void flatten(TreeNode root) {
	     flattenHelper(root);
	 }

	private void flattenHelper(TreeNode root) {
		if(root==null)
			return;
		flattenHelper(root.left);
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = null;
		root.right = left;
		TreeNode current = root;
		while(current.right!=null)
			current = current.right;
		flattenHelper(right);
		current.right = right;
	}
	
	public static void main(String args[]){
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		new FlattenBinaryTreeToLinkedList().flatten(node);;
	}
}
