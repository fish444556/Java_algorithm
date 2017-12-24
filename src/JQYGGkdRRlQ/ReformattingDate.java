package JQYGGkdRRlQ;

import java.util.HashMap;
import java.util.Map;

public class ReformattingDate {
	public boolean testing() {
		String[][] testCases = {
				{"1st Mar 1984", "1984-03-01"},
				{"2nd Feb 2013", "2013-02-02"},
				{"4th Apr 1900", "1900-04-04"}
		};
		for(int i = 0; i < testCases.length; i++) {
			if (testCases[i][1].equals(reformatting(testCases[i][0]))) {
				return false;
			}
		}
		return true;
	}
	
	public String reformatting(String date) {
		String res = "";
		Map<String, String> MONTH = new HashMap<>();
		MONTH.put("Jan", "01");
		MONTH.put("Feb", "02");
		MONTH.put("Mar", "03");
		MONTH.put("Apr", "04");
		MONTH.put("May", "05");
		MONTH.put("Jun", "06");
		MONTH.put("Jul", "07");
		MONTH.put("Aug", "08");
		MONTH.put("Sep", "09");
		MONTH.put("Oct", "10");
		MONTH.put("Nov", "11");
		MONTH.put("Dec", "12");
		Map<Integer, String> DAY = new HashMap<>();
		DAY.put(1, "1st");
		DAY.put(2, "2nd");
		DAY.put(3, "3rd");
		DAY.put(11, "1st");
		DAY.put(12, "12nd");
		DAY.put(13, "13rd");
		DAY.put(21, "21st");
		DAY.put(22, "22nd");
		DAY.put(23, "23rd");
		DAY.put(31, "31st");
		for (int i = 4; i < 31; i++) {
			if (!DAY.containsKey(i)) {
				DAY.put(i, i + "th");
			}
		}
		Map<String, String> DAY2 = new HashMap<>();
		for (Map.Entry<Integer, String> entry: DAY.entrySet()) {
			DAY2.put(entry.getValue(), entry.getKey() + "");
		}
		String[] strArr = date.split(" ");
		res = strArr[2] + MONTH.get(strArr[1]) + DAY2.get(strArr[0]);
		return res;
	}
}
