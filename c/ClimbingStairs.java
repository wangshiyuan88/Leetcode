package c;

public class ClimbingStairs {
	public int climbStairs(int n) {
        if(n<=1)
        	return 1;
        int[] temp = new int[]{1,1};
        for(int i = 2; i <= n; i++){
        	int current = temp[0]+temp[1];
        	temp[0] = temp[1];
        	temp[1] = current;
        }
		return temp[2];
    }
}
