package r;

public class ReverseWordsInString {
	 public String reverseWords(String s) {
		
		 
		 String[] strArray = s.split(" ");
		 
		 int start = 0;
		 int end = strArray.length-1;
		 StringBuilder sb = new StringBuilder();
		 while(start<end){
			 while(strArray[start].equals(""))start++;
			 while(strArray[end].equals(""))end--;
			 if(start < end){
				 String temp = strArray[start];
				 strArray[start] = strArray[end];
				 strArray[end] = temp;
			 }
			 start++;
			 end--;
		 }
		 
		 for(int i = 0; i < strArray.length; i++){
			 if(!strArray[i].equals(""))
			 sb.append(strArray[i]+" ");
		 }
		 
		 return sb.toString().trim();
	  }
	 
	 public static void main(String args[]){
		System.out.print( new ReverseWordsInString().reverseWords("   a   b "));
	 }
}
