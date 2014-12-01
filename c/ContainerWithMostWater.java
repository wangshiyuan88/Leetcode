package c;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxArea = 0;
        while(start<end){
            int curHeight = Math.min(height[start], height[end]);
            maxArea = Math.max((end-start)*Math.min(height[start], height[end]), maxArea);
            if(height[start]==curHeight){
                while(height[start]<=curHeight&&start<end)
                    start++;
            }else{
                while(curHeight>=height[end]&&start<end)
                    end--;
            }
        }
        return maxArea;
    }
}
