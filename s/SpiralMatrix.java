package s;

import java.util.ArrayList;

public class SpiralMatrix {

	public ArrayList<Integer> spiralOrder(int[][] matrix) {

		if (matrix == null)
			return null;
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (matrix.length == 0)
			return ret;
		int xMax = matrix.length - 1;
		int yMax = matrix[0].length - 1;
		int xMin = 0;
		int yMin = 0;

		while ((xMax >= xMin) && (yMax >= yMin)) {
			if (xMax == xMin && yMax == yMin) {
				ret.add(matrix[xMin][xMax]);
				break;
			}

			for (int i = yMin; i < yMax; i++) {
				ret.add(matrix[xMin][i]);
			}

			for (int j = xMin; j < xMax; j++) {
				ret.add(matrix[j][yMax]);
			}
			if (xMin == xMax) {
				ret.add(matrix[xMax][yMax]);
				break;
			}
			for (int i = yMax; i > yMin; i--) {
				ret.add(matrix[xMax][i]);
			}

			if (yMin == yMax) {
				ret.add(matrix[xMax][yMin]);
				break;
			}
			for (int j = xMax; j > xMin; j--) {
				ret.add(matrix[j][yMin]);
			}
			xMin++;
			xMax--;
			yMin++;
			yMax--;
		}
		return ret;
	}

	public ArrayList<Integer> spiralOrder1(int[][] matrix) {

		if (matrix == null)
			return null;
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (matrix.length == 0)
			return ret;
		int xMax = matrix.length - 1;
		int yMax = matrix[0].length - 1;
		int xMin = 0;
		int yMin = 0;
		int i = 0;
		int j = 0;
		ret.add(matrix[i][j]);
		while (true) {

			while (j < yMax)
				ret.add(matrix[xMin][++j]);
			if (++xMin > xMax)
				break;

			while (i < xMax)
				ret.add(matrix[++i][yMax]);
			if (--yMax < yMin)
				break;

			while (j > yMin)
				ret.add(matrix[xMax][--j]);
			if (--xMax < xMin)
				break;

			while (i > xMax)
				ret.add(matrix[--i][yMin]);
			if (++yMin > yMax)
				break;
		}
		return ret;
	}

	public int[][] generateMatrix(int n) {
		int [][] ret = new int[n][n];
		if(n<=0)
		return ret;

		int numToFill = 1;
		int max = n-1;
		int min = 0;
		while(min<=max){
			int x = min;
			int y = min;
			if(max==min){
				ret[x][y] = numToFill;
				return ret;
			}
			while(y<max)
			ret[x][y++] = numToFill++;
			while(x<max)
			ret[x++][y] = numToFill++;
			while(y>min)
			ret[x][y--] = numToFill++;
			while(x>max)
			ret[x--][y] = numToFill++;
			max--;
			min++;
		}
		return ret;
	}

}
