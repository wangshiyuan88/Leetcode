package p;

public class PalindromeNumber {
	 public boolean isPalindrome(int x) {
	        if(x<0)
	        	return false;
	        int div = 1;
	        while(x/div>=10){
	        	div *=10;
	        }
	        
	        while(x>0){
	        	int high = x/div;
	        	int low = x%10;
	        	if(high!=low)
	        		return false;
	        	x -= high*div+low;
	        	x /= 10;
	        	div /=100;
	        }
	   
		return true;
	 }
	 
	 public static void main(String args[]){
		 new PalindromeNumber().isPalindrome(1);
	 }
}
