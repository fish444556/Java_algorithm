package JQYGGkdRRlQ;

public class PreSuffix {
	public boolean testing() {
		System.out.println(PreSuffix("bruno", "ingenious", "nothing") == 5);
		System.out.println(PreSuffix("bruno", "ingenious", "fdsafnodfingdsanothingfdsa") == 5);
		return true;
	}
	
	public boolean testing2() {
		return PreSuffix2("bruno", "ingenious", "nothing") == "nothing" &&
				PreSuffix2("b", "a", "ab") == "b" ;
	}
	
	public int PreSuffix(String pre, String sub, String text) {
		char preLast = pre.charAt(pre.length() - 1);
		char subFirst = sub.charAt(0);
		int l = text.indexOf(preLast, 1);
		int r = text.lastIndexOf(subFirst, text.length() - 2);
		int res = 0;
		while (l < r) {
			res = Math.max(matchCharacterNum(sub, 1, text, r + 1, true) + 
					matchCharacterNum(pre, pre.length() - 2, text, l - 1, false) , res);			
			l = text.indexOf(preLast, l);
			r = text.lastIndexOf(subFirst, text.length() - r);
		} 
		return res;
	}
	
	private int matchCharacterNum(String a, int ai, String b, int bi, boolean forward) {
		int res = 1;
		if (forward) {
			while (ai < a.length() && bi < b.length() && a.charAt(ai) == b.charAt(bi)) {
				ai++;
				bi++;
				res++;
			}
		}
		else {
			while (ai >= 0 && bi >= 0 && a.charAt(ai) == b.charAt(bi)) {
				ai--;
				bi--;
				res++;
			}
		}
		return res;
	}
	
	public String PreSuffix2(String pre, String sub, String text) {
		String output = "";
		int max_prefix_count = 0, prefix_count = 0,
			max_suffix_count = 0, suffix_count = 0, 
			sstr_start = 0, sstr_end = 0,
			i=0,j=0;
		
		while(i<text.length())
		{
			int k=i,start=-1,end=-1;
			j=0;prefix_count = 0;
			
			while(  (k<text.length() && j<pre.length()) 
					&& (text.charAt(k) != pre.charAt(j)))
			j++;
			
			while((k<text.length() && j<pre.length()) 
					&& (text.charAt(k) == pre.charAt(j)))
			{
				if(start == -1)
					start = k;
				
				prefix_count++;
				k++; j++;
			}

			//update prefix index as we get the new string.
			if(prefix_count > max_prefix_count)
			{
				max_prefix_count = prefix_count;
				sstr_start = start;
			}

			k=i;j=0;
			suffix_count = 0;

			while((k<text.length() && j<sub.length()) 
					&& (text.charAt(k) != sub.charAt(j)))
				j++;
			
			while((k<text.length() && j<sub.length()) 
					&& (text.charAt(k) == sub.charAt(j)))
			{
				suffix_count++;
				k++; j++;
			}

			end = k;
			
			//update prefix index as we get the new string.
			if(suffix_count > max_suffix_count)
			{
				max_suffix_count = suffix_count;
				sstr_end = end;
			}
			i++;
		}
		if(sstr_end>sstr_start)
			return text.substring(sstr_start, sstr_end);
//			System.out.println("output:"+text.substring(sstr_start, sstr_end));
		else
			return text.substring(sstr_start);
//			System.out.println("output:"+text.substring(sstr_start));
	}
}
