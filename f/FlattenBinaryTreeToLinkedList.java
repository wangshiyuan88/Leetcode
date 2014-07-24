package f;


public class FlattenBinaryTreeToLinkedList {
	// http://blog.csdn.net/perfect8886/article/details/20000083
	public class TreeNode {
		 public int val;
		 public TreeNode left;
		 public TreeNode right;
		 public TreeNode(int x) { val = x; }
	}
	
	public void flatten(TreeNode root) {
		while(root!=null){
			if(root.left!=null){
				TreeNode right = root.right;
				root.right = root.left;
				root.left = null;
				TreeNode toTail = root.right;
				while(toTail.right!=null)
					toTail = toTail.right;
				toTail.right = right;
			}
			root = root.right;
		}
    }

//	 First solution 	
//    public void flatten(TreeNode root) {
//		flattenBranch(root);
//    }
//	
//	public TreeNode flattenBranch(TreeNode root){
//		if(root == null)
//			return null;
//		if(root.left==null&&root.right==null)
//			return root;
//		TreeNode ret = null;
//		TreeNode left = root.left;
//		TreeNode right = root.right;
//		TreeNode leftTail = null;
//		TreeNode rightTail = null;
//		root.left = null;
//		if(left!=null){
//			root.right = left;
//			leftTail = flattenBranch(left);
//			ret = leftTail;
//		}
//		if(right!= null){
//			rightTail = flattenBranch(right);
//			if(left!=null){
//				leftTail.right = right;
//			}
//			ret = rightTail;
//		}
//		return ret;
//	}
}
