package freq3;

import common.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, preorder.length-1, preorder, 0, inorder.length-1, inorder);
    }

	private TreeNode buildTree(int ps, int pe, int[] preorder, int is,
			 int ie, int[] inorder) {
		if(ps>pe)
			return null;
		TreeNode current = new TreeNode(preorder[ps]);
		int index = is;
		while(inorder[index]!=current.val)
			index++;
		
		current.left = buildTree(ps+1,ps+index-is, preorder, is, index-1, inorder );
		current.right = buildTree(ps+index-is+1, pe, preorder, index+1, ie, inorder);
		return current;
	}
}
