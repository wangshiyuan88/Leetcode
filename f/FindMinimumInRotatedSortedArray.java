package f;

public class FindMinimumInRotatedSortedArray {
	 public int findMin(int[] num) {
		 if(num.length==1)
			 return num[0];
	    return findMin(0, num.length-1, num);     
	  }

	private int findMin(int start, int end, int[]num) {
		if(start+1==end)
			return Math.min(num[start], num[end]);
		int mid = (start+end)/2;
		
		if(num[mid]<num[start]||num[mid]<num[end])
			return findMin(start, mid, num);
		else
			return findMin(mid, end, num);
	}
	
	 public int findMinII(int[] num) {
	        if (num == null || num.length == 0) {
	            return 0;
	        }
	        
	        int len = num.length;
	        if (len == 1) {
	            return num[0];
	        } else if (len == 2) {
	            return Math.min(num[0], num[1]);
	        }
	        
	        int left = 0;
	        int right = len - 1;
	        
	        while (left < right - 1) {
	            int mid = left + (right - left) / 2;
	            //In this case, the array return to be sorted again
	            if (num[left] < num[right]) {
	                return num[left];
	            }
	            
	            // left side is sorted. CUT the left side.
	            if (num[mid] > num[left]) {
	                left = mid;
	            // left side is unsorted, right side is sorted. CUT the right side.
	            } else if (num[mid] < num[left]) {
	                right = mid;
	            } else {
	                left++;
	            }
	        }
	        
	        return Math.min(num[left], num[right]);        
	    }
}
