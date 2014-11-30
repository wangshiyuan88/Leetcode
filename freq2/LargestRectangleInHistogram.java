package freq2;

import java.util.Stack;

public class LargestRectangleInHistogram {
	  public int largestRectangleArea(int[] height) {
		  if(height==null||height.length==0)
			  return 0;
		  Stack<Integer> stack = new Stack<Integer>();
		  int maxArea = 0;
		  int[] heightWithZero = new int[height.length+1];
		  for(int i = 0; i<height.length; i++){
			  heightWithZero[i] = height[i];
		  }
		  heightWithZero[heightWithZero.length-1] = 0;
		  for(int i = 0; i < heightWithZero.length; i++){
			  if(stack.isEmpty()||heightWithZero[stack.peek()]<=heightWithZero[i])
				  stack.push(i);
			  else{
				  int current = heightWithZero[i];
				  while(!stack.isEmpty()&&heightWithZero[stack.peek()]>=current){
					  int top = heightWithZero[stack.pop()];
					  int leftSide = stack.isEmpty()? -1 : stack.peek();
					  maxArea = Math.max(maxArea, top*(i-leftSide-1));
				  }
				  stack.push(i);
			  }
		  }
		  return maxArea;
	  }
}
