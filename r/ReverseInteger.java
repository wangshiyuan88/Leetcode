package r;

public class ReverseInteger {
	   int reverse(int x) {  
       
	   int newN =0, left =0;  
	   while(x != 0){
	        
		    left = x%10;  
	        newN = newN*10 + left;  
	        x = x/10;  
	   
	   }  
       return newN;  
    }  
}
