package freq2;

public class SpiralMatrixII {
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
