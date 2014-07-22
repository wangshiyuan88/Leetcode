package t;

import java.util.ArrayList;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		
		
		for(int i = 0 ; i < triangle.size()-1; i++){
			ArrayList<Integer> current = triangle.get(i);
			ArrayList<Integer> next = triangle.get(i+1);
			next.set(0, next.get(0)+current.get(0));
			next.set(next.size()-1, next.get(next.size()-1)+current.get(current.size()-1));
			
		}
		
		for(int i = 0; i< triangle.size()-1; i++){
			ArrayList<Integer> current = triangle.get(i);
			ArrayList<Integer> next = triangle.get(i+1);
			for(int j = 0; j < current.size()-1;j++){
				next.set(j+1, Math.min(current.get(j),current.get(j+1))+next.get(j+1));
			}
			
		}
		int min = Integer.MAX_VALUE;
		ArrayList<Integer> lastArray = triangle.get(triangle.size()-1);
		for(int i = 0; i < lastArray.size(); i++){
			min = Math.min(lastArray.get(i), min);
		}
		return min;   
    }
}
