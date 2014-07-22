package t;

import java.util.Stack;

public class TrappingRainWater {
	 public int trap(int[] A) {
		Stack<Integer> index = new Stack<Integer>();
		Stack<Integer> height = new Stack<Integer>(); 
		int ret = 0;
		for(int i = 0; i < A.length; i++){
			int current = A[i];
			while(!height.isEmpty()&&height.peek()<=current){
				int bottom = height.pop();
				index.pop();
				if(!height.isEmpty()){
					int higherSideInStack = height.peek();
					int higherSideIndex = index.peek();
					ret += (Math.min(higherSideInStack,current)-bottom)*(i-higherSideIndex-1);
				}
			}
			height.push(current);
			index.push(i);
		}
		 
		 return ret;        
	 }
}
