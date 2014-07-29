package b;

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
        current.add(root);
        boolean leftToRight = true;
        while(!current.isEmpty()){
        	Stack<TreeNode> next = new Stack<TreeNode>();
        	List<Integer> level = new ArrayList<Integer>();
        	while(!current.isEmpty()){
        		TreeNode currentRoot = current.pop();
        		level.add(currentRoot.val);
        		if(leftToRight){
        			if(currentRoot.left!=null)next.push(currentRoot.left);
        			if(currentRoot.right!=null)next.push(currentRoot.right);
        		}else{
        			if(currentRoot.right!=null)next.push(currentRoot.right);
        			if(currentRoot.left!=null)next.push(currentRoot.left);
        		}
        	}
        	ret.add(level);
        	leftToRight ^= true;
        	current = next;
        }
		return ret;
    }
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(5);
		new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
	}
}
