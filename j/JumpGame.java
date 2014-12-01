package j;

public class JumpGame {
	 public boolean canJump(int[] A) {
	        if(A.length<=1)
	            return true;
			int current = 0;
			int max = current + A[current];
			while(A[current]!=0&&max<A.length-1){
				int nextMax = max;
				int nextCurrent = current;
				for (int i = current; i <= max; i++) {
					if (A[i] + i >= nextMax) {
						nextCurrent = i;
						nextMax = A[i] + i;
					}
				}
				current = nextCurrent;
				max = nextMax;
			}
			return max>=A.length-1;
	    }
	
	public int jump(int[] A) {
		int step = 0;
		int current = 0;
		if (A.length <= 1)
			return 0;
		step = 1;
		while (A[current] + current < A.length - 1) {
			int max = current + A[current];
			int nextMax = max;
			int nextCurrent = current;
			for (int i = current; i <= max; i++) {
				if (A[i] + i >= nextMax) {
					nextCurrent = i;
					nextMax = A[i] + i;
				}
			}
			current = nextCurrent;
			step++;
		}
		return step;
    }
	
	public static void main(String args[]){
		new JumpGame().jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0});
	}
}
