package l;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}
		s = preprocess(s);
		int focus = 0;
		int[] resultArray = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if ((2 * focus - i)>=0 && (i + resultArray[2 * focus - i]) < (focus + resultArray[focus])) {
				resultArray[i] = resultArray[2 * focus - i];
			} else {
				int currentDistance = focus + resultArray[focus] - i;
				while ((i-currentDistance >= 0)&&(i + currentDistance) < s.length() && s.charAt(i + currentDistance) == s.charAt(i - currentDistance))
					currentDistance++;
				resultArray[i] = currentDistance - 1;
				focus = i;
			}
		}
		int max = 0;
		int index = -1;
		for (int i = 0; i < resultArray.length; i++) {
			if (resultArray[i] > max) {
				index = i;
				max = resultArray[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		String current = s.substring(index - max, index + max + 1);
		for (int i = 0; i < current.length(); i++) {
			if (current.charAt(i) != '#')
				sb.append(current.charAt(i));
		}
		return sb.toString();
	}

	private String preprocess(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append("#");
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i) + "#");
		}
		return sb.toString();
	}
	
	public static void main(String args[]){
		new LongestPalindromicSubstring().longestPalindrome("bb");
	}
}
