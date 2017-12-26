package JQYGGkdRRlQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dominated {
	public boolean testing() {
		int[][] arr = {{1,2}, {3,4}, {10,2}, {7,8}, {1, 15}};
		List<int[]> groudTrue = new ArrayList<>();
		groudTrue.add(new int[]{1,15});
		groudTrue.add(new int[]{7,8});
		groudTrue.add(new int[]{10,2});
		List<int[]> res = getDominated(arr);
		if (res.size() != groudTrue.size()) {
			return false;
		}
		for (int i = 0; i < res.size(); i++) {
			if (res.get(i)[0] != groudTrue.get(i)[0] 
					|| res.get(i)[1] != groudTrue.get(i)[1]) {
				return false;
			}
		}
		return true; 
	}
	
	
	/*
	 * I can not find a algorithm which time complexity is less than n*n
	 * Removed the array which is dominated by other array. Hoped this can
	 * reduce a little of the time complexity.  
	 */
	public List<int[]> getDominated(int[][] arr) {
		Set<String> set = new HashSet<>();
		for (int[] a: arr) {
			String str = a[0] + " " + a[1];
			set.add(str);
		}
		for (int i = 0; i < arr.length - 1 && set.contains(arr[i][0] + " " + arr[i][1]); i++) {
			for (int j = i + 1; j < arr.length && set.contains(arr[j][0] + " " + arr[j][1]); j++) {
				int tmp = dominated(arr[i], arr[j]);
				if (tmp != 0) {
					if (tmp == 1) {
						set.remove(arr[j][0] + " " + arr[j][1]);
					}
					else {
						set.remove(arr[i][0] + " " + arr[i][1]);
						break;
					}
				}				
			}
		}
		List<int[]> res = new ArrayList<>();
		for (String str: set) {
			String[] ss = str.split(" ");
			int[] tmp = new int[] {Integer.parseInt(ss[0]), Integer.parseInt(ss[1])};
			res.add(tmp);
		}
		Collections.sort(res, (a,b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});
		return res;
	}
	
	private int dominated(int[] a, int[] b) {
		if (a[0] > b[0] && a[1] > b[1]) {
			return 1;
		}
		else if (a[0] < b[0] && a[1] < b[1]) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
