package c;

import java.util.HashSet;
import java.util.Set;

public class CountAndSay {
	 public String countAndSay(int n) {
		 if(n<=0)
			 return "";
		 String ret = "1";
		 while(n>1){
			 int index = 0;
			 StringBuilder sb = new StringBuilder();
			 while(index < ret.length()){
				 char current = ret.charAt(index);
				 int counter = 0;
				 while(index<ret.length()&&ret.charAt(index)==current){
					 counter++;
					 index++;
				 }
				 sb.append(counter+""+current);
			 }
			 n--;
			 ret = sb.toString();
		 }
		 return ret;
	 }
	 
	 public static void main(String args[]){
		 new CountAndSay().countAndSay(2);
	 }
}
