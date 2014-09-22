package freq4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import common.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null)
        	return ret;
        Queue<TreeNode> current = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        List<Integer> currentLevel = new ArrayList<Integer>();
        current.add(root);
        while(!current.isEmpty()){
        	TreeNode node = current.poll();
        	currentLevel.add(node.val);
        	if(node.left!=null)
        		next.add(node.left);
        	if(node.right!=null)
        		next.add(node.right);
        	if(current.isEmpty()){
        		current = next;
        		next = new LinkedList<TreeNode>();
        		ret.add(currentLevel);
        		currentLevel = new ArrayList<Integer>();
        	}
        }
		return ret;
    }
	
	public static void main(String args[]){
		new BinaryTreeLevelOrderTraversal().levelOrder(new TreeNode(1));
	}
}
