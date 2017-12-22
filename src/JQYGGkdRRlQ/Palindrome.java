package JQYGGkdRRlQ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Palindrome {
	private List<String> curList;
	private Set<String> set;
	
	
	public boolean testing() {
		if(partition("aabaa") != 5) {
			return false;
		}
		return true;
	}
    public int partition(String s) {
        set = new HashSet<>();
        if (s == null || s.length() == 0) {
			return 0;
		}
        curList = new ArrayList<>();
        dfs(s, 0);
        return set.size();
    }

    private void dfs(String s, int left) {
    	if (curList.size() > 0 && left >= s.length()) {
    		return ;
    	}
    	for (int i = left; i < s.length(); i++) {
    		if (isPalindrome(s, left, i)) {
    			if (left == i) {
    				set.add(Character.toString(s.charAt(left)));
    			}
    			else {
    				set.add(s.substring(left, i + 1));
    			}
    			dfs(s, i + 1);
    		}
    	}
    }

    private boolean isPalindrome(String s, int left, int right) {
    	while (left < right) {
    		if (s.charAt(left++) != s.charAt(right--)) {
    			return false;
    		}
    	}
    	return true;
    }
}