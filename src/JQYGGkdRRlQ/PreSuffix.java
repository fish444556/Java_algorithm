package JQYGGkdRRlQ;

public class PreSuffix {
	public boolean testing() {
		return PreSuffix("bruno", "ingenious", "nothing") == 5;
	}
	
	public int PreSuffix(String pre, String sub, String text) {
		char preLast = pre.charAt(pre.length() - 1);
		char subFirst = sub.charAt(0);
		int l = text.indexOf(preLast, 1);
		int r = text.lastIndexOf(subFirst, text.length() - 2);
		int res = 0;
		while (l < r) {
			res = Math.max(matchCharacterNum(sub, 1, text, r + 1, true) + 
					matchCharacterNum(pre, pre.length() - 2, text, l - 1, false) , res);			
			l = text.indexOf(preLast, l);
			r = text.lastIndexOf(subFirst, text.length() - r);
		} 
		return res;
	}
	
	private int matchCharacterNum(String a, int ai, String b, int bi, boolean forward) {
		int res = 1;
		if (forward) {
			while (ai < a.length() && bi < b.length() && a.charAt(ai) == b.charAt(bi)) {
				ai++;
				bi++;
				res++;
			}
		}
		else {
			while (ai >= 0 && bi >= 0 && a.charAt(ai) == b.charAt(bi)) {
				ai--;
				bi--;
				res++;
			}
		}
		return res;
	}
}
