package JQYGGkdRRlQ;

import java.util.ArrayList;
import java.util.List;

public class Dominated {
	public boolean testing() {
		int[][] arr = {{1,2}, {3,4}, {6,2}, {7,8}};
		List<int[]> res = getDominated(arr);
		return res.get(0)[0] == 7 && res.get(0)[0] == 8;
	}
	
	public List<int[]> getDominated(int[][] arr) {
		List<int[]> res = new ArrayList<>();
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		for (int[] a: arr) {
			maxX = Math.max(a[0], maxX);
			maxY = Math.max(a[1], maxY);
		}
		
		for (int[] a: arr) {
			if (a[0] == maxX && a[1] == maxY) {
				res.add(a);
			}
		}
		
		return res;
	}
}
