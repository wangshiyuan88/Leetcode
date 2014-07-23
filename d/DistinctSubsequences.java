package d;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {	
		return numDistinct(S, 0, T, 0);
    }

	private int numDistinct(String s, int i, String t, int j) {
		if (j == t.length()) {
			return 1;
		}
		if (s.length() - i < t.length() - j)
			return 0;
		int ret = 0;
		if (s.charAt(i) == s.charAt(j)) {
			ret += numDistinct(s, i + 1, t, j + 1);
		}
		ret += numDistinct(s, i + 1, t, j);
		return ret;
	}
	
	public static void main(String args[]){
		System.out.println(new DistinctSubsequences().numDistinct("bbi", "bi"));
	}
}
