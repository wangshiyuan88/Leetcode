package p;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;


public class PathSumII {
	 public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> ret = new ArrayList<List<Integer>>();
	        List<Integer> path = new ArrayList<Integer>();
	        pathSum(root, 0, sum, path, ret);
	        return ret;
	    }

	private void pathSum(TreeNode root, int currentSum, int sum, List<Integer> path, List<List<Integer>> ret) {
		if(root == null){
			return;
		}
		path.add(root.val);
		currentSum = currentSum + root.val;
		
		if(root.left == null && root.right ==null){
			if(currentSum == sum){
				ret.add(new ArrayList<Integer>(path));
			}
		}
		else{
			pathSum(root.left, currentSum, sum, path, ret);
			pathSum(root.right, currentSum, sum, path, ret);
		}
		if(!path.isEmpty()){
			path.remove(path.size()-1);
		}
	}
}
