package LgYdDU1DUVlZ;

import java.util.HashMap;
import java.util.Map;

public class checkStatus {
	public boolean test() {
		char[][] i1 = {{'0', '0', '0', '0', '0', '0', '0'},
				{'0', '0', '0', '0', '0', '0', '0'},
				{'0', '0', '0', '0', '0', '0', 'Y'},
				{'0', '0', '0', '0', 'R', 'Y', 'R'},
				{'0', '0', '0', '0', 'Y', 'Y', 'Y'},
				{'R', 'Y', 'R', 'Y', 'R', 'R', 'R'}};
		String o1 = "Y";
		
		char[][] i2 = {{'R', 'R', 'R', 'R', '0', '0', '0'},
				{'Y', 'Y', 'R', 'Y', 'Y', '0', '0'},
				{'R', 'R', 'R', 'Y', 'R', '0', 'R'},
				{'Y', 'Y', 'Y', 'R', 'R', 'Y', 'R'},
				{'Y', 'R', 'Y', 'R', 'Y', 'Y', 'Y'},
				{'R', 'Y', 'R', 'Y', 'R', 'R', 'R'}};
		String o2 = "R";
		
		char[][] i3 = {{'R', 'R', 'R', 'Y', 'R', 'R', 'Y'},
				{'Y', 'Y', 'R', 'Y', 'Y', 'R', 'R'},
				{'R', 'R', 'R', 'Y', 'R', 'Y', 'R'},
				{'Y', 'Y', 'Y', 'R', 'R', 'Y', 'R'},
				{'Y', 'R', 'Y', 'R', 'Y', 'Y', 'Y'},
				{'R', 'R', 'R', 'Y', 'R', 'R', 'R'}};
		String o3 = "N";
		if (checkGameStatus(i1) != o1) {
			System.out.println("1111111111");
			return false;
		}
		if (checkGameStatus(i2) != o2) {
			System.out.println("222222222");
			return false;
		}
		if (checkGameStatus(i3) != o3) {
			System.out.println("3333");
			return false;
		}
		
		return true;
	}
	

    public String checkGameStatus(char[][] board) {    	
        String res = "";
        if (board == null || board.length == 0 || board[0].length == 0) {
            return res;
        }
        Map<Character, Boolean> map = new HashMap<>();
        map.put('Y', false);
        map.put('R', false);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (map.get(board[i][j]) != null && !map.get(board[i][j]) && checkPatterns(board, i, j, board[i][j])) {
                    map.put(board[i][j], true);
                }
//                else {
//                    board[i][j] ^= 255;
//                }
            }
        }
        if (map.get('Y') && map.get('R')) {
            res = "B";
        }
        else if (map.get('Y')) {
            res = "Y";
        }
        else if (map.get('R')) {
            res = "R";
        }  
        else {
        	res = "N";
        }
        return res;
    }

    private boolean checkPatterns (char[][] board, int x, int y, char ch) {
        if (ch != 'R' && ch != 'Y') {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean changed = false;
        // vertical
        if (x + 3 < m) {        	
            for (int i = x + 1; i <= x + 3; i++) {
                if (ch != board[i][y]) {
                	changed = true;
                    break;
                }
            }
            if (!changed) {
            	return true;
            }
        }
  
        // horizontal
        if (y + 3 < n) {        	
        	changed = false;
            for (int i = y + 1; i <= y + 3; i++) {
                if (ch != board[x][i]) {
                	changed = true;
                	break;
                }
            }
            if (!changed) {
            	return true;
            }
        }
        
        // positive diagonal
        if (x + 3 < m && y + 3 < n) {
        	changed = false;
            for (int i = x + 1, j = y + 1; i <= x + 3; i++, j++) {
                if (ch != board[i][j]) {
                	changed = true;
                	break;
                }
            }
            if (!changed) {
            	return true;
            }
        }
        
        // negative diagonal        
        if (x + 3 < m && y - 3 > 0) {
        	changed = false;
            for (int i = x + 1, j = y - 1; j >= y - 3; i++, j--) {
                if (ch != board[i][j]) {
                	changed = true;
                	break;
                }
            }
            if (!changed) {
            	return true;
            }
        }
        
        return false;
    }
}