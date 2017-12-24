package JQYGGkdRRlQ;

import java.util.HashSet;
import java.util.Set;

public class UniqueArraySum {
	public boolean testing() {
		int[] arr = {3,2,1,2,7};
		if (uniqueArraySum(arr) != 17) {
			return false;
		}
		return true;
	}
	
	public int uniqueArraySum(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for (int a: arr) {
			if (set.contains(a)) {
				int tmp = a + 1;
				while(set.contains(tmp)) {
					tmp++;
				}
				set.add(tmp);
				sum += tmp;
			}
			else  {
				set.add(a);
				sum += a;
			}
		}
		return sum;
	}
}
