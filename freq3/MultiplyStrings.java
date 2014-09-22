package freq3;

public class MultiplyStrings {
	
//	Given two numbers represented as strings, return multiplication of the numbers as a string.
//	Note: The numbers can be arbitrarily large and are non-negative.
	
	 public String multiply(String num1, String num2) {
		
		 if(num1.equals("0")||num2.equals("0"))
			return "0";
		 int[] ret = new int[num1.length()+num2.length()];
		 
		 for(int i=num1.length()-1; i>=0; i--){
			 int carry = 0;
			 for(int j = num2.length()-1; j >=0; j--){
				 int current = (num2.charAt(j) - '0')*(num1.charAt(i) - '0')+carry+ret[j+i+1];
				 ret[j+i+1] = current%10;
				 carry = current/10;
			 }
			 ret[i]+= carry;
		 }
		 boolean start = false;
		 StringBuilder sb = new StringBuilder();
		 for(int i = 0; i <ret.length; i++){
			 if(ret[i]!=0||start){
				 start = true;
				 sb.append(ret[i]);
			 }
		 }
		 return sb.toString();
	  }
}
