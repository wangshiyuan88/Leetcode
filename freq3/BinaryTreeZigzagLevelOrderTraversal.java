package freq3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(root==null)
			return ret;
		Stack<TreeNode> current = new Stack<TreeNode>();
		current.push(root);
		int indicator = 0;
		List<Integer> level = new ArrayList<Integer>();
		Stack<TreeNode> next = new Stack<TreeNode>();
		while(!current.isEmpty()){
			TreeNode currentRoot = current.pop();
			level.add(currentRoot.val);
			if(indicator%2==0){
				if(currentRoot.left!=null)
					next.push(currentRoot.left);	
				if(currentRoot.right!=null)
					next.push(currentRoot.right);
					
			}else{
				if(currentRoot.right!=null)
					next.push(currentRoot.right);
				if(currentRoot.left!=null)
					next.push(currentRoot.left);
			}
			if(current.isEmpty()){
				current = next;
				next = new Stack<TreeNode>();
				ret.add(new ArrayList<Integer>(level));
				level = new ArrayList<Integer>();
				indicator^=1;
			}
		}
		return ret;
    }
	
	public static void main(String args[]){
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(node);
	}
}
