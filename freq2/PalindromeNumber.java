package freq2;

public class PalindromeNumber {
	 public boolean isPalindrome(int x) {
		 if(x<0)
			 return false;
		 int div = 1;
		 while(x/div>=10){
			 div*=10;
		 }
		 while(x>0){
			 int low = x%10;
			 int high = x/div;
			 if(low!=high)
				 return false;
			 x %= div;
			 x /= 10;
			 div /= 100;
		 }
		 return true;
	  }
	 
	 public static void main(String args[]){
		 new PalindromeNumber().isPalindrome(1);
	 }
}
