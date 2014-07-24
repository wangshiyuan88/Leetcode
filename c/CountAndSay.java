package c;

public class CountAndSay {
	 public String countAndSay(int n) {
		 if(n<=0)
			 return "";
		 String ret = "1";
		 while(n>1){
			 int index = 0;
			 StringBuilder sb = new StringBuilder();
			 while(index < ret.length()){
				 if(index < ret.length()-1&&ret.charAt(index)==ret.charAt(index+1)){
						 sb.append("2"+ret.charAt(index));
						 index += 2;
				 }
				 else
					 sb.append("1"+ret.charAt(index++));
			 }
			 n--;
			 ret = sb.toString();
		 }
		 return ret;
	 }
}
