package m;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int[] retArray = new int[num1.length()+num2.length()];
	
		for(int i = num1.length()-1; i >= 0; i--){	
			int carry = 0;
			int startIndex = num1.length()-1-i;
			for(int j = num2.length()-1; j >= 0; j--){
				retArray[startIndex+(num2.length()-1-j)]  = (num1.charAt(i)-'0')*(num2.charAt(j)-'0') + carry + retArray[startIndex+(num2.length()-1-j)];
				carry = retArray[startIndex+(num2.length()-1-j)] / 10;
				retArray[startIndex+(num2.length()-1-j)] %= 10;
			}
			retArray[startIndex+num2.length()] += carry; 
		}
		
		StringBuilder sb = new StringBuilder();
		boolean significant = false;
		for(int i = retArray.length-1; i >= 0; i--){
			if(significant||retArray[i]!=0){
				significant = true;
				sb.append(retArray[i]);
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
