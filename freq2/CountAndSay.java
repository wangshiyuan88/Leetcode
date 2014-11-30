package freq2;

public class CountAndSay {
	public String countAndSay(int n) {
		if(n==0)
			return "";
		String ret = "1";
		while(n>1){
			int counter = 0;
			StringBuilder next = new StringBuilder();
			for(int i = 0; i < ret.length(); i++){
				if(i==0||ret.charAt(i)==ret.charAt(i-1)){
					counter++;
				}else{
					next.append(counter+""+ret.charAt(i-1));
					counter = 1;
				}
			}
			next.append(counter+""+ret.charAt(ret.length()-1));
			ret = next.toString();
			n--;
		}
		return ret;
    }
	
	public static void main(String args[]){
		System.out.println(new CountAndSay().countAndSay(2));
	}
}
