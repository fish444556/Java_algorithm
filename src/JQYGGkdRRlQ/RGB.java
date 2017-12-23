package JQYGGkdRRlQ;

import java.util.ArrayList;
import java.util.List;

public class RGB {
	public boolean testing() {
		String[] strArr = {"101111010110011011100100"
				,"110000010101011111101111"
				,"100110101100111111101101"
				,"010111011010010110000011"
				,"000000001111111111111111"};		
		
		String[] res = RGB_Dis(strArr);
		String[] groundTrue = {"White", "White", "White", "Green", "Ambiguous"};
		for (int i = 0; i < res.length; i++) {
			if (res[i] != groundTrue[i]) {
				return false;
			}
		}
		return true;
	}
	
	public String[] RGB_Dis(String[] input) {
		if (input == null || input.length == 0) {
			return null;
		}
		String[] res = new String[5];
		for (int i = 0; i < input.length; i++) {
			int r = changeStirngNum(input[i].substring(0, 8));
			int g = changeStirngNum(input[i].substring(8, 16));
			int b = changeStirngNum(input[i].substring(16, 24));
			res[i] = distance(r, g, b);
		}
		return res;
	}
	
	private String distance(int r, int g, int b) {
		Double min = Double.MAX_VALUE;
		int idx = 0;
		int[][] rgbs = {{0,0,0}, {255,255,255}, {255,0,0}, {0,255,0}, {0,0,255}};
		String[] groundTrue = {"Black", "White", "Red", "Green", "Blue"};
		for (int i = 0; i < rgbs.length; i++) {
			Double cur = Math.sqrt((rgbs[i][0] - r) * (rgbs[i][0] - r) 
					+ (rgbs[i][1] - g) * (rgbs[i][1] - g)
					+ (rgbs[i][2] - b) * (rgbs[i][2] - b));
			if (i != 0 && Math.abs(min - cur) < 0.001 ) {
				return "Ambiguous";
			}
			if (cur < min) {
				min = cur;
				idx = i;
			}
		}
		return groundTrue[idx];
	}
	
	private int changeStirngNum(String str) {
		int res = 0;
		int len = str.length() - 1;
		for (int i= 0; i < str.length(); i++) {
			if (str.charAt(i) != '0') {
				res += Math.pow(2, len - i);				
			}			
		}
		return res;
	}
}
