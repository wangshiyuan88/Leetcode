package u;

import java.util.ArrayList;

import common.TreeNode;


public class UniqueBinarySearchTree {
	
	    public int numTrees(int n) {
			if(n==0||n==1)
				return 1;
			int[] counter = new int[n+1];
			counter[0] = 1;
			counter[1] = 1;
			
			for(int i = 2; i < counter.length; i++){
				for(int j = 0; j <i ; j++){
					counter[i] += counter[j]*counter[i-j-1];
				}
			}
			 return counter[n];
		  }
	    
	    
	    public ArrayList<TreeNode> generateTrees(int n) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	
	        return generateTreesList(1, n);
	    }
	    
	    private ArrayList<TreeNode> generateTreesList(int start, int end){
	    	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
	    	if(start > end){
	    		result.add(null);
	    		return result;
	    	}
	    	
	    	
	    	for(int i = start; i <= end; i++){
	    		ArrayList<TreeNode> left = generateTreesList(start, i-1);
	    		ArrayList<TreeNode> right = generateTreesList(i+1, end);
	    		for(TreeNode leftNode : left){
	    			for(TreeNode rightNode : right){
	    				TreeNode root = new TreeNode(i);
	    				root.left = leftNode;
	    				root.right = rightNode;
	    				result.add(root);
	    			}
	    		}
	    	}
	    	
	    	return result;
	    }
}
