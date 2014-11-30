package freq2;

import java.util.ArrayList;
import java.util.List;
//Use {[1,2,3][4,5,6][7,8,9][10,11,12]} as input to figure out the problem
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new ArrayList<Integer>();
		if(matrix==null||matrix.length==0)
			return ret;
		int xmin = 0, ymin = 0;
		int xmax = matrix.length-1;
		int ymax = matrix[0].length - 1;
		
		while(xmin<=xmax&&ymin<=ymax){
			int x = xmin;
			int y = ymin;
			while(y<ymax){
				ret.add(matrix[x][y++]);
			}
			while(x<xmax){
				ret.add(matrix[x++][y]);
			}
			if(xmin==xmax){
				ret.add(matrix[x][y]);
				break;
			}
			while(y>ymin){
				ret.add(matrix[x][y--]);
			}
			if(ymin==ymax){
				ret.add(matrix[x][y]);
				break;
			}
			while(x>xmin){
				ret.add(matrix[x--][y]);
			}
			xmin++;
			ymin++;
			xmax--;
			ymax--;
		}
		return ret;
    }
	
	
}
