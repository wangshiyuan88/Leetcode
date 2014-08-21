package freq4;

public class IntegerToRoman {
//	Given an integer, convert it to a roman numeral.
//	Input is guaranteed to be within the range from 1 to 3999.
//	I - 1, V - 5, X - 10, L - 50, C - 100, D - 500, M - 1000.
//	The rule of how roman numeral forms is,
//	1~3 I, II, III,
//	4 IV,
//	5 V
//	6~8 VI, VII, VIII
//	9 IX
//	10 X
	
	public String intToRoman(int num) {
	     String[] symbols = new String[]{"I","V","X","L","C","D","M"}; 
	     StringBuilder ret = new StringBuilder();
	     for(int scale = 6; scale >=0; scale-=2){
	    	 int digit = (int) (num/(Math.pow(10, scale/2)));
	    	 if(digit>0){
	    		 if(digit==9){
	    			 ret.append(symbols[scale+1]);
	    			 ret.append(symbols[scale+2]);
	    			 digit -= 9;
	    		 }
	    		 if(digit>=5){
	    			 ret.append(symbols[scale+1]);
	    			 digit -= 5;
	    		 }
	    		 if(digit==4){
	    			 ret.append(symbols[scale]);
	    			 ret.append(symbols[scale+1]);
	    			 digit-=4;
	    		 }else if(digit > 0){
	    			 for(;digit>0;digit--){
	    				 ret.append(symbols[scale]);
	    			 }
	    		 }
	    		 
	    	 }
	    	 num %= Math.pow(10, scale/2);
	     }
	     return ret.toString();   
	 }
}
