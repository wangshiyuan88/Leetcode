package r;

import common.TreeNode;

public class RecoverBinarySearchTree {
	TreeNode prev = null;
	TreeNode n1 = null;
	TreeNode n2 = null;
	public void recoverTree(TreeNode root) {

		findSwapTreeNodes(root);
		if(n1!=null&&n2!=null){
			int temp = n1.val;
			n1.val = n2.val;
			n2.val = temp;
		}
	}

	private void findSwapTreeNodes(TreeNode root) {
		if (root == null) {
			return;
		}

		findSwapTreeNodes(root.left);

		if (prev!=null && prev.val > root.val) {
			if (n1 == null) {
				n1 = prev;
				n2 = root;
			} else {
				n2 = root;
			}
		}
		prev = root;
		findSwapTreeNodes(root.right);

	}
	
	
	public static void main(String args[]){
		TreeNode n1 = new TreeNode(2);
		n1.right = new TreeNode(1);
		new RecoverBinarySearchTree().recoverTree(n1);
	}
}
