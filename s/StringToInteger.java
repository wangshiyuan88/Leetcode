package s;

public class StringToInteger {
	public int atoi(String str) {
		int res = 0;
		boolean positive = true;
		str = str.trim();
		if(str.length()==0)
			return res;
		int index = 0;
		if(str.charAt(index)=='-'){
			positive = false;
			index++;
		}else if(str.charAt(index)=='+'){
			index++;
		}else if(str.charAt(index)<'0'||str.charAt(index)>'9'){
			return res;
		}
		
		while(index<str.length()&&str.charAt(index)>='0'&&str.charAt(index)<='9'){
			int current = str.charAt(index)-'0';
			if(positive){
				if((Integer.MAX_VALUE-current)/10<res)
					return Integer.MAX_VALUE;
				res = 10*res + current;
			}else{
				if((Integer.MIN_VALUE+current)/10>res)
					return Integer.MIN_VALUE;
				res = 10*res - current;
			}
			index++;
		}
		return res;
    }
	
	public static void main(String args[]){
		new StringToInteger().atoi("1");
	}
}
