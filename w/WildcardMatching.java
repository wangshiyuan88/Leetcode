package w;

public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int sp = 0;
		int pp = 0;
		int i = 0, j = 0;
		if (p.length() == 0)
			return s.length() == 0;
		boolean star = false;
		for (; i < s.length(); i++, j++) {
			if (j == p.length()) {
				if (!star)
					return false;
				else {
					sp++;
					i = sp;
					j = pp;
					continue;
				}
			}
			switch (p.charAt(j)) {
			case '?': {
				continue;
			}
			case '*': {
				star = true;
				i--;
				sp = i;
				do {
					j++;
				} while (j < p.length() && p.charAt(j) == '*');
				if (j == p.length())
					return true;
				j--;
				pp = j;
				continue;
			}
			default: {
				if (p.charAt(j) != s.charAt(i)) {
					if (!star) {
						return false;
					}
					sp++;
					i = sp;
					j = pp;
				}
				}
			}
		}
		while (j < p.length() && p.charAt(j) == '*') {
			j++;
		}
		return j == p.length();
	}
}
