package freq3;

import common.TreeNode;

public class ConstructBinaryTreeFromInorderPostorderTree {
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
		 return buildTree(0, inorder.length-1, inorder, 0, postorder.length-1, postorder);
	 }

	private TreeNode buildTree(int is, int ie, int[] inorder, int ps, int pe,
			int[] postorder) {
		if(is>ie)
			return null;
		TreeNode current = new TreeNode(postorder[pe]);
		
		int index = is;
		while(inorder[index]!=current.val)
			index++;
		
		current.left = buildTree(is, index-1, inorder, ps, ps+(index-is)-1, postorder);
		current.right = buildTree(index+1, ie, inorder, ps+(index-is), pe-1, postorder);
		return current;
	}
}
