package JQYGGkdRRlQ;

public class CanReach {
	public boolean testing() {
		int[] s1 = {1, 4};
		int[] d1 = {5, 9};
		return canReach(s1, d1);
	}
	
	public boolean canReach(int[] s, int[] d) {
		if (s.length != 2 || d.length != 2 || s[0] > d[0] || s[1] > d[1]) {
			return false;
		}
		if (s[0] == d[0] && s[1] == d[1]) {
			return true;
		}
		return canReach(new int[] {s[0] + s[1], s[1]}, d) || 
				canReach(new int[] {s[0], s[0] + s[1]}, d);
	}
	
}
