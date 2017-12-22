package JQYGGkdRRlQ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Task {
	
	public void testing() {
		int[] a2 = {1};
        int[] b2 = {2};
        
        int[] a3 = {1, 2};
        int[] b3 = {2, 1};
        
        System.out.println(maxTask(2, a2, b2) == 2);
        System.out.println(maxTask(2, a3, b3) == 1);
        
        System.out.println(maxTask(5, a3, b3) );

	}
    public int maxTask(int n, int[] a, int[] b) {
        if (b.length == 0 ) {
            return n;
        }
        int len = b.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();        
        // int[] indegree = new int[n];
        for (int i = 0; i < len; i++) {
            if (map.containsKey(a[i])) {
                map.get(a[i]).add(b[i]);
            }
            else {
                Set<Integer> tmp = new HashSet<>();
                tmp.add(b[i]);
                map.put(a[i], tmp);
            }            
        }
        int numTake = 0;
//        PriorityQueue<Map> queue = new PriorityQueue<>();
//        for (int i = 0; i < len; i++) {
//            if (map.containsKey(a[i])) {
//                queue.offer(a[i]);
//            }
//        }
//        boolean change = true;
//        while (!queue.isEmpty() && change) {
//        	int cur = queue.poll();
//        	numTake++;        	
//            change = false;
//            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
//                Set<Integer> set = entry.getValue();
//                if (set.contains(cur)) {
//                    change = true;
//                    set.remove(cur);
//                    if (set.isEmpty()) {
//                     queue.add(entry.getKey());
//                     map.remove(entry.getKey());
//                 }
//             }
//         }
//     }
//     return n - queue.size() ;
       return n;
 }
}

