package freq2;

public class TrappingRainWater {
	public int trap(int[] A) {
		if(A==null||A.length==0)
			return 0;
		int start = 0;
		int end = A.length-1;
		int left = 0;
		int right = 0;
		int water = 0;
		while(start<=end){
			left = Math.max(left, A[start]);
			right = Math.max(right, A[end]);
			if(A[start]<=A[end]){
				water += Math.min(left, right) - A[start];
				start++;
			}else{
				water += Math.min(left, right) - A[end];
				end--;
			}
		}
		return water;
    }
	
	public static void main(String args[]){
		new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
	}
}
