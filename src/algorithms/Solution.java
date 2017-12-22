package algorithms;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
        System.out.println("Hello World!"); // Display the string.
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        MySolution ms = new MySolution();
        int[] a2 = {1};
        int[] b2 = {2};
        
        int[] a3 = {1};
        int[] b3 = {2};
    }
}


class MySolution {
    public int canFinish(int n, int[] a, int[] b) {
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
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(a[i])) {
                queue.offer(a[i]);
            }
        }
        boolean change = true;
        while (!queue.isEmpty() && change) {
        	int cur = queue.poll();
        	numTake++;        	
            change = false;
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                Set<Integer> set = entry.getValue();
                if (set.contains(cur)) {
                    change = true;
                    set.remove(cur);
                    if (set.isEmpty()) {
                     queue.add(entry.getKey());
                     map.remove(entry.getKey());
                 }
             }
         }
     }
     return n - queue.size() ;
 }
}

