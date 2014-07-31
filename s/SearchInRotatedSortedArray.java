package s;

public class SearchInRotatedSortedArray {
	//better solution in http://fisherlei.blogspot.com/2013/01/leetcode-search-in-rotated-sorted-array.html
	  public int search(int[] A, int target) {
	        return search(A, 0, A.length-1, target);
	   }
	  
	  private int search(int[] A, int start, int end, int target){
		  if(start > end){
			  return -1;
		  }
		  
		  int mid = (start+end)/2;
		  if(A[mid]==target){
			  return mid;
		  }
		  if(A[start]==A[mid]){
			  return search(A, mid+1, end, target);
		  }
		  else if(A[start]<A[mid]){
			  if(target>=A[start]&&target<A[mid])
			  	return search(A, start, mid-1, target);
			  else
				return search(A, mid+1, end, target);
		  }
		  else{
			  if(target>A[mid]&&target<=A[end])
				  return search(A, mid+1, end, target);
			  else 
				  return search(A, start, mid-1, target);
		  }
	  }
	  
	  public int searchII(int[] A, int target){
		  int l = 0;
		  int r = A.length-1;
		  
		  while(l<=r){
			  
			  int mid = (l+r)/2;
			  if(A[mid]==target)
				  return mid;
			  
			  if(A[mid]==A[l]){
				  l++;  // God logic
			  }else if(A[mid] > A[l]){
				  if(target>=A[l]&&target<A[mid]){
					  r = mid-1;
				  }else{
					  l = mid+1;
				  }
			  }else{
				  if(target<A[mid]||target>=A[l]){
					  r = mid-1;
				  }else{
					  l = mid+1;
				  }
			  }
			  
		  }
		  
		  return -1;
	  }
}
