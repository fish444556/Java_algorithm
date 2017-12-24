package JQYGGkdRRlQ;

public class SubArrayProducts {
	public boolean testing() {
		int[] a1 = {1,2,3,4};
		int[] a2 = {1,9,2,8,6,4,3};
		int[] a3 = {5,3,2};
		int[] a4 = {100,200};
		int[] a5 = {1,2,3};
		if (countSubArrayProductLessThanK(a1, 10) != 7				
				|| countSubArrayProductLessThanK(a2, 100) != 16
				|| countSubArrayProductLessThanK(a3, 16) != 5
				|| countSubArrayProductLessThanK(a4, 100) != 0
				|| countSubArrayProductLessThanK(a4, 101) != 1
				|| countSubArrayProductLessThanK(a5, 4) != 4
				|| countSubArrayProductLessThanK(a5, 7) != 6) {
			return false;
		}
		return true;
	}
	
	public int countSubArrayProductLessThanK(int[] a, long k) {
		int n = a.length;
		long p = 1;
		int res = 0;
		for (int start = 0, end = 0; end < n; end++) {

			// Move right bound by 1 step.
			// Update the product.
			p *= a[end];

			// Move left bound so guarantee that
			// p is again less than k.
			while (start < end && p >= k)
				p /= a[start++];

			// If p is less than k, update the counter.
			// Note that this is working even for
			// (start == end): it means that the
			// previous window cannot grow anymore
			// and a single array element is the only
			// addendum.
			if (p < k) {
				int len = end - start + 1;
				res += len;
			}
		}

		return res;
	}
}
