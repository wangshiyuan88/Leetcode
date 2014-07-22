package s;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root==null){
			return false;
		}
		return checkSymmetric(root.left, root.right);
    }
	
	public boolean checkSymmetric(TreeNode left, TreeNode right){
		if(left==null&&right==null){
			return true;
		}else if(left==null||right==null){
			return false;
		}
		
		if(left.val!=right.val){
			return false;
		}
		
		return checkSymmetric(left.left, right.right)&&checkSymmetric(right.left, left.right);
		
	}
}
