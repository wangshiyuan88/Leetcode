package b;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if(root==null)
			return ret;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode current = stack.pop();
			ret.add(current.val);
			if(current.right!=null)stack.push(current.right);
			if(current.left!=null)stack.push(current.left);
		}
		return ret;
    }
}
