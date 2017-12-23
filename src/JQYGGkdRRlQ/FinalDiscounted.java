package JQYGGkdRRlQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinalDiscounted {
	public boolean testing() {
		int[] arr = {5,1,3,4,6,2};
		return finalDiscounted(arr) == 14;
	}
	
	public long finalDiscounted(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		long res = 0;
		int minVal = arr[arr.length - 1];
		res += minVal;
		List<Integer> idx = new ArrayList<>();
		idx.add(arr.length - 1);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < minVal) {
				minVal = arr[i];
				res += minVal;
				idx.add(i);
			}
			else {
				res += (arr[i] - minVal);
			}
		}
		Collections.reverse(idx);
		System.out.println(idx);
		return res;
		
	}
}
