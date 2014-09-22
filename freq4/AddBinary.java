package freq4;

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		addBinary(a, a.length()-1, b, b.length()-1, 0, sb);
		return sb.toString();
    }

	private void addBinary(String a, int i, String b, int j, int carry,
			StringBuilder sb) {
		if(i<0&&j<0&&carry==0){
			return;
		}
		int current = i<0? 0 : a.charAt(i)-'0';
		current += j<0? 0 : b.charAt(j)-'0';
		current += carry;
		sb.insert(0, current%2);
		addBinary(a, i-1, b, j-1, current/2, sb);
	}
}
