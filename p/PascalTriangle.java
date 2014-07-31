package p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<Integer[]> triangle = new ArrayList<Integer[]>();
	
		
		for(Integer row = 0; row < numRows; row++){
			Integer[] array = new Integer[row+1];
			array[0] = 1;
			array[array.length-1] = 1;
			triangle.add(array);
		}
		for(Integer row = 0; row < numRows; row++){
			Integer[] current = triangle.get(row);
			for(Integer i = 0; i < current.length; i++){
				if(current[i]==null){
					current[i] = triangle.get(row-1)[i]+triangle.get(row-1)[i-1];
				}
			}
		}
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for(Integer[] array : triangle){
			ret.add(Arrays.asList(array));
		}
		return ret;
    }
	
	public static void main(String args[]){
		new PascalTriangle().generate(5);
	}
}
