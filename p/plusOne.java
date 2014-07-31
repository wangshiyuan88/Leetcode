package p;

public class plusOne {
	  public int[] plusOne(int[] digits) {
			 int carrier = (digits[digits.length-1]+1)/10;
			 digits[digits.length-1] = (digits[digits.length-1]+1)%10;
			 for(int i = digits.length-2; i >=0 && carrier>0; i-- ){
				 int temp = digits[i];
				 digits[i] = (temp+carrier)%10;
				 carrier = (temp+carrier)/10;
			 }
			 if(digits[0]==0){
			     int[] array = new int[digits.length+1];
			     array[0] = 1;
			     for(int i = 0; i < digits.length; i++ ){
			         array[i+1] = digits[i];
			     }
			     digits = array;
			 }
			 return digits;
		 }
}
