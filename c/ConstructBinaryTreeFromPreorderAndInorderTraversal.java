package c;

import common.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
		 if(preorder.length==0)
			 return null;
		 return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	  }

	private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder,
			int is, int ie) {
		if(ps>pe)
			return null;
		TreeNode root = new TreeNode(preorder[ps]);
		int rIndexInOrder = is;
		while(inorder[rIndexInOrder]!=root.val)
			rIndexInOrder++;
		int leftLength = rIndexInOrder - is;
		root.left = buildTree(preorder, ps+1, ps+leftLength, inorder, is, rIndexInOrder-1);
		root.right = buildTree(preorder, ps+leftLength+1, pe, inorder, rIndexInOrder+1, ie);
		return root;
	}
	
	public static void main(String args[]){
		new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(new int[]{1,2}, new int[]{2,1});
	}
}
