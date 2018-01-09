package JQYGGkdRRlQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tt {
	public int[] ttt(int[][] m, int[] t) {
		int n = m.length;
		List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int tmp = Math.abs(list.get(i)[0] - list.get(j)[0]) + Math.abs(list.get(i)[1] - list.get(j)[1]);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
        int[] res = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            res[i] = map.getOrDefault(t[i], 0);
        }
        return res;
	}
}
