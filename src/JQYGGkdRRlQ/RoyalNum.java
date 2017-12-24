package JQYGGkdRRlQ;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RoyalNum {

	public boolean testing() {
		String[] strArr = { "Albert II", "Polo IV", "Alw V", "Elizabeth XXV", "Albert XL", "Polo XLVI" };
		String[] groundTrue = { "Albert XL", "Albert II", "Alw V", "Elizabeth XXV", "Polo XLVI", "Polo IV" };
		String[] res = solution(strArr);
		for (int i = 0; i < strArr.length; i++) {
			if (!res[i].equals(groundTrue[i])) {
				return false;
			}
		}
		return true;
	}

	public static String[] solution(String[] names) {
		int len = names.length;
		if (len <= 1)
			return names;
		PriorityQueue<String> q = new PriorityQueue<String>((a, b) -> {
			String[] arr1 = a.split(" ");
			String[] arr2 = b.split(" ");
			if (arr1[0].equals(arr2[0])) {
				int va = convert(arr1[1]);
				int vb = convert(arr2[1]);
				return vb - va;
			} else {
				return arr1[0].compareTo(arr2[0]);
			}
		});
		for (int i = 0; i < len; i++) {
			if (names[i] == "" || names[i] == " ")
				continue;
			q.add(names[i]);
		}
		int size = q.size();
		String res[] = new String[size];
		for (int j = 0; j < size; j++) {
			res[j] = q.poll();
		}
		return res;
	}

	public static int convert(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int res = 0;
		for (int i = 0, last = 0; i < s.length(); i++) {
			int val = map.get(s.charAt(i));
			if (i > 0 && last < val) {
				res -= 2 * last;
			}
			res += val;
			last = val;
		}
		return res;
	}

}