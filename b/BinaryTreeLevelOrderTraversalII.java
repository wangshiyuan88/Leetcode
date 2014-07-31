package b;

import java.util.ArrayList;
import java.util.Collections;

import common.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
	    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
	        ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
	        helper(root, 0, tree); // use ArrayList as parameter so that recurcive function can use it without defininition
	        Collections.reverse(tree);
	        return tree;
	    }
	    
	    public void helper(TreeNode node, int depth, ArrayList<ArrayList<Integer>> tree){
	        if (node == null) return; //exit
	        
	        ArrayList<Integer> leaf = null; // leaf array list may got from tree array list or newly created
	        if(depth<tree.size()) {
	            leaf = tree.get(depth); // same depth, got from tree array list (current leaf)
	        }else{
	            leaf = new ArrayList<Integer>(); // new depth, create new leaf array list for this depth
	            tree.add(leaf);
	        }
	        leaf.add(node.val); // add current node value to leaf array list
	        
	        // process next depth
	        helper(node.left, depth+1,tree);
	        helper(node.right, depth+1, tree);
	    }
}
