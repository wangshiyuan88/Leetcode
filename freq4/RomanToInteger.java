package freq4;

public class RomanToInteger {
//	Given a roman numeral, convert it to an integer.
//	Input is guaranteed to be within the range from 1 to 3999.
	
	public int romanToInt(String s) {
        int ret = decode(s.charAt(0));
		for(int i = 1; i < s.length(); i++){
			int prev = decode(s.charAt(i-1));
			int curr = decode(s.charAt(i));
			ret += curr;
			if(prev < curr){
				ret -= prev*2; 
			}
		}
		
		return ret;
    }
	
	public int decode(char c){
		
		switch(c){
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			
		}
		return 0;
	}
}
