package b;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(root==null){
			return ret;
		}
		Queue<TreeNode> current = new LinkedList<TreeNode>();
		current.add(root);
		while(!current.isEmpty()){
			Queue<TreeNode> next = new LinkedList<TreeNode>();
			List<Integer> level = new ArrayList<Integer>();
			while(!current.isEmpty()){
				TreeNode node = current.poll();
				level.add(node.val);
				if(node.left!=null)next.add(node.left);
				if(node.right!=null) next.add(node.right);
			}
			ret.add(level);
			current = next;
		}
		return ret;
    }
}
