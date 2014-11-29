package b;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root==null)
        	return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode prev = root;
		while(!stack.isEmpty()){
			TreeNode current = stack.peek();
			if((current.left==null&&current.right==null)||current.left == prev||current.right == prev){
				ret.add(current.val);
				stack.pop();
				prev = current;
			}else{
				if(current.right!=null)stack.push(current.right);
				if(current.left!=null)stack.push(current.left);
			}
		}
		return ret;
    }

	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		new BinaryTreePostorderTraversal().postorderTraversal(root);
	}
}
