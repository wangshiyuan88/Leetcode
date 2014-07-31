package m;

public class MinimumWindowSubstring {
	 public String minWindow(String S, String T) {
		 int[] charCounter = new int[260];
		 int totalChar = 0;
		 for(int i = 0; i < T.length(); i++){
			 if(charCounter[T.charAt(i)]==0)
				 totalChar++;
			 charCounter[T.charAt(i)]++;
		 }
		 int totalMatchChar = 0;
		 int head = -1, tail = 0;
		 String retLength = null;
		 while(tail < S.length()){
			 char tailChar = S.charAt(tail);
			 if(T.indexOf(tailChar)!=-1){
				 if(head== -1)
				        head = tail;
				 if(charCounter[tailChar]==1)
					 totalMatchChar++;
				 charCounter[tailChar]--;
				 if(totalMatchChar == totalChar){		 	
					 while(head<=tail){
						 char headChar = S.charAt(head);
						 if(T.indexOf(headChar)!=-1){
							 if(charCounter[headChar] >=0){
								 if(totalMatchChar == totalChar -1)
									 break;
								 else if(totalMatchChar == totalChar && (retLength==null|| retLength.length()>(tail-head+1))){
									 retLength = S.substring(head, tail+1);	
								 }
									 totalMatchChar--;
							 }
							 charCounter[headChar]++;
						 }
						 head++;
					 }
				 }
			 }
			 tail++;
		 }
		 return retLength==null? "": retLength;
	 }

	 public static void main(String args[]){
		 new MinimumWindowSubstring().minWindow("caccaacaaaabbcaccaccc", "acccacbccc");
	 }
}
