package freq5;

public class StringToInteger {
	public int atoi(String str){
		str = str.trim();
		boolean positive = true;
		if(str.length()<=0)
			return 0;
		int index = 0;
		if(str.charAt(index)=='-'||str.charAt(index)=='+'){
			positive = str.charAt(index++)=='+';
		}
		int ret = 0;
		while(index<str.length()&&str.charAt(index)>='0'&&str.charAt(index)<='9'){
			int digit = str.charAt(index)-'0';
			if(positive){
				if((Integer.MAX_VALUE-digit)/10<ret)
					return Integer.MAX_VALUE; 
				else
					ret = ret*10 + digit;
			}else{
				if((Integer.MIN_VALUE+digit)/10>ret)
					return Integer.MIN_VALUE;
				else
					ret = ret*10 - digit;
			}
			index++;
		}
		return ret;
	}
}
