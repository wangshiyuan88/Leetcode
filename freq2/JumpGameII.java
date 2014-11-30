package freq2;

public class JumpGameII {
	 public int jump(int[] A) {
		  if(A==null||A.length<=1)
			  return 0;
		  int step = 0;
		  int reach = A[0];
		  int start = 0;
		  while(start+reach<A.length-1){
			  int nextStart = start;
			  int nextReach = 0;
			  for(int i = start; i <= start+reach; i++){
				  if((i+A[i])>(nextStart+nextReach)){
					  nextStart = i;
					  nextReach = A[i];
				  }
			  }
			  step++;
			  start = nextStart;
			  reach = nextReach;
		  }
		  
		 return step;
	 }
	 
	 public static void main(String args[]){
		 new JumpGameII().jump(new int[]{1,2,3});
	 }
}
