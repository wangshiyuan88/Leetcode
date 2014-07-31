package s;

public class SingleNumber {
	   public int singleNumber(int[] A) {
	     int ret = 0;
	     for(int i : A){
	    	 ret ^= i;
	     }
	     return ret;
	    }
	   
	   public int singleNumberII(int[] A) {
		   int one = 0;
		   int two = 0;
		   int three = 0;
		   for(int i : A){
			   two |= one & i;
			   one ^= i; 
			   three = two & one;
			   one &= ~three;
			   two &= ~three;
		   }
		   return one;
	    }
}
