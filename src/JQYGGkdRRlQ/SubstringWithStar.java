package JQYGGkdRRlQ;

public class SubstringWithStar {
	public boolean testing() {
		String s = "kjhsifiuewanthasmwii";
		String sub = "ant**s";
		if (findSubstr(s, sub) != 10) {
			return false;
		}
		return true;
	}
	
	public int findSubstr(String s, String sub) {
		if (s == null || s.length() < sub.length()) {
			return -1;
		}
		int len = sub.length();
		
		for (int i = 0; i + len < s.length(); i++) {
			if(s.charAt(i) == sub.charAt(0)) {
				int j = 1;
				while (j < len && 
						(s.charAt(i + j) == sub.charAt(j) || sub.charAt(j) == '*')) {
					j++;
				}
				if (j == len) {
					return i;
				}
			}
		}
		return -1;
	}
}
