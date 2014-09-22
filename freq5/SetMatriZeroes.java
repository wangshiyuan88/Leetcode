package freq5;

import java.util.HashSet;
import java.util.Set;

public class SetMatriZeroes {
	// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.	
	
	public void setZeroes(int[][] matrix) {
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j]==0){
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(rows.contains(i)||cols.contains(j))
					matrix[i][j]=0;
			}
		}
    }
}
