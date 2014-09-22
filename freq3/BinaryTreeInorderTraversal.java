package freq3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class BinaryTreeInorderTraversal {
//	public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//		  stack.push(root);
//        while(!stack.isEmpty()){
//        	TreeNode current = stack.pop();
//        	if(current.left==null&&current.right==null)
//        		list.add(current.val);
//        	else{
//	        	if(current.left!=null)
//	        		stack.add(current.left);
//	        	stack.add(current);
//	        	if(current.right!=null)
//	        		stack.add(current.right);
//        	}	
//        }
//		return list;
//    }
	
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root!=null||!stack.isEmpty()){
			if(root==null){
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}else{
				stack.push(root);
				root = root.left;
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		new BinaryTreeInorderTraversal().inorderTraversal(root);
	}
}
