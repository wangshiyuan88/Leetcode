package m;

import java.util.Stack;

//This solution is an O(MN*MN), brute force!
//public class MaximalRectangle {
//	  public int maximalRectangle(char[][] matrix) {
//		  int maxArea = 0;
//		  for(int i = 0; i < matrix.length; i++){
//			  for(int j = 0; j < matrix[0].length; j++){
//				  int rowLimit = matrix.length;
//				  int y = j;
//				  while(y < matrix[0].length&&matrix[i][y]=='1'){
//					  int x = i;
//					  while(x < matrix.length&&matrix[x][y]=='1'&&x<rowLimit){
//						  maxArea = Math.max(maxArea, (y-j+1)*(x-i+1));
//						  x++;
//					  }
//					  rowLimit = Math.min(rowLimit, x);
//					  y++;
//				  }
//			  }
//		  }
//		  return maxArea;
//	   }
	  
public class MaximalRectangle {
	 public int maximalRectangle(char[][] matrix) {
		  int maxArea = 0;  
		  if(matrix==null||matrix.length==0||matrix[0].length==0){
			  return maxArea;
		  }
		  int[][] intMatrix = convertToHistogram(matrix);
		  for(int i = 0; i < matrix.length; i++){
			  maxArea = Math.max(maxArea ,maxAreaHistogram(intMatrix, i));
		  }
		  return maxArea;
	 }

public int[][] convertToHistogram(char[][] matrix){
	int[][] ret = new int[matrix.length][matrix[0].length+1];
	for(int i=0; i < matrix.length; i++){
		for(int j =0; j < matrix[0].length; j++){
			if(i==0){
				ret[i][j] = matrix[i][j] - '0';
			}else{
				ret[i][j] = matrix[i][j]=='0'? 0 : ret[i-1][j] +1;
			}
		}
	}
	return ret;
}
public int maxAreaHistogram(int[][] ret, int index){
	int[] row = ret[index];
	int maxArea = 0;
	Stack<Integer> stack = new Stack<Integer>();
	for(int i = 0; i < row.length; i++){
		if(stack.isEmpty()||row[stack.peek()]<=row[i]){
			stack.push(i);
		}else{
			int j = stack.pop();
			maxArea = Math.max(maxArea, row[j]*(stack.isEmpty()?i : i - stack.peek()-1));
			i--;
		}
	}
	return maxArea;
}
	
public static void main(String args[]){
	char[][] array = new char[1][2];
	array[0][0] = '1';
	array[0][1] = '1';
	new MaximalRectangle().maximalRectangle(array);
}

}
