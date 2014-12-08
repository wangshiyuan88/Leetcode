package m;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int ret[] = new int[num1.length()+num2.length()];
		for(int i = num1.length()-1; i >= 0; i--){
			int digit = num1.charAt(i) - '0';
			if(digit==0)
			continue;
			int carry = 0;
			for(int j = num2.length()-1; j >= 0; j--){
				int product = (num2.charAt(j)-'0')*digit + carry;
				ret[i+j+1] += product;
				carry = ret[i+j+1]/10;
				ret[i+j+1] %= 10;
			}
			ret[i] += carry;
		}
		StringBuilder sb = new StringBuilder();
		Boolean start = false;
		for(int i = 0; i < ret.length; i++){
			if(start||ret[i]!=0){
				start = true;
				sb.append(ret[i]);
			}
		}
		if(sb.length()==0)
		return "0";
		return sb.toString();
	}


	 public String multiplyFromOthers(String num1, String num2) {
	        // Start typing your Java solution below
	        // DO NOT write main() function

	        int[] num = new int[num1.length()+num2.length()];
	        for(int i=0;i<num1.length();i++){
	            int carry = 0;
	            int a = num1.charAt(num1.length()-1-i)-'0';
	            for(int j=0;j<num2.length();j++){
	                int  b = num2.charAt(num2.length()-1-j)-'0';
	                num[i+j]+=carry+a*b;
	                carry=num[i+j]/10;
	                num[i+j]%=10;
	            }
	            num[i+num2.length()]+=carry;
	        }
	        int i=num.length-1;
	        while(i>0 && num[i]==0) i--;

	        StringBuilder temp = new StringBuilder("");
	        while(i>=0)
	            temp.append((char)('0'+num[i--]));

	        return temp.toString();
	    }

	public static void main(String args[]){
		new MultiplyStrings().multiply("123", "456");
	}
}
