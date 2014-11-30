package freq2;

public class JumpGame {
	public boolean canJump(int[] A) {
		if(A==null||A.length<=1)
			return true;
		int index = 0;
		int reach = index + A[0];
		
		while(reach<A.length-1){
			int newReach = reach;
			int newIndex = index;
			for(int i = index; i <= reach; i++){
				if(newReach<i+A[i]){
					newReach = i+A[i];
					newIndex = i;
				}
			}
			if(newReach==reach)
				return false;
			else{
				reach = newReach;
				index = newIndex;
			}
		}
		return true;
    }
	
	public static void main(String[] args){
		new JumpGame().canJump(new int[]{1,2,3});
	}
}
