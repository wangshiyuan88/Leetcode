package freq2;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int before = 0;
		int after = height.length-1;
		int max = 0;
		while(before<after){
			max = Math.max(max, (after-before)*Math.min(height[after], height[before]));
			if(height[after]<height[before])
				after--;
			else
				before++;
		}
		return max;
    }
}
