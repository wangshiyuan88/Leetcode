package l;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
		int max = 0;
		List<Integer> heights = new ArrayList<Integer>();
		for(int i = 0; i < height.length; i++){
			heights.add(height[i]);
		}
		heights.add(0);
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < heights.size();){
			if(stack.size()==0||heights.get(stack.peek())<= heights.get(i)){
				stack.push(i);
				i++;
			}
			else{
				int current = stack.pop();
				while(!stack.isEmpty()&&heights.get(stack.peek())>=heights.get(current)){
					stack.pop();
				}
				int distance = stack.isEmpty()? i : i - stack.peek()-1;
				max = Math.max(max, distance*heights.get(current));
			}
		}
    	return max;
    }
    
    public static void main(String[] args){
    	new LargestRectangleInHistogram().largestRectangleArea(new int[]{2,1,2});
    }
    
}
