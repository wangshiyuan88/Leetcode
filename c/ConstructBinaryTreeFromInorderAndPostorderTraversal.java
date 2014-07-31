package c;

import common.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	  public TreeNode buildTree(int[] inorder, int[] postorder) {
	       if(inorder.length==0)
	    	   return null; 
		  return buildTree(0, inorder.length-1, inorder, 0, postorder.length-1,postorder);
	    }

	  private TreeNode buildTree(int is, int ie, int[] inorder, int ps, int pe,
			int[] postorder) {
		if(is>ie)
			return null;
		TreeNode root = new TreeNode(postorder[pe]);
		int pivot = is;
		while(inorder[pivot]!=root.val)
			pivot++;
		int leftLength = pivot-is;
		root.left = buildTree(is, pivot-1, inorder, ps, ps+leftLength-1, postorder);
		root.right = buildTree(pivot+1, pe, inorder, ps+leftLength, pe-1, postorder);
		return root;
	}
	  
	  public static void main(String args[]){
			new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(new int[]{2,1}, new int[]{2,1});
		}
}
