package assign1;

import java.util.*;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		// return 0; // TODO ADD YOUR CODE HERE
		int len = str.length();
		if (len == 0 || len == 1){
			return len;
		}
		int maxCnt = 0;
		for (int i=0; i<len-1; i++){
			int cnt = 1;
			for (int j=i+1; j<len; j++){
				if (str.charAt(j) == str.charAt(i)){
					cnt++;
				}
				else{
					break;
				}
			}
			if (cnt > maxCnt){
				maxCnt = cnt;
			}
		}
		return maxCnt;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		 // return null; // TODO ADD YOUR CODE HERE
		int len = str.length();
		if (len == 0){
			return "";
		}
		String newstr = "";
		for (int i=0; i<len; i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9'){
				if (c == '0' || i == len-1){
					continue;
				}
				char next = str.charAt(i+1);
				int t = Integer.parseInt(""+c);
				for (int j=0; j<t; j++){
					newstr = newstr + next;
				}	
			}
			else{
				newstr = newstr + c;
			}
		}
		return newstr;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		// return false; // TO DO ADD YOUR CODE HERE
		int alen = a.length(), blen = b.length();
		if (alen < len || blen < len){
			return false;
		}
		HashSet<String> s = new HashSet<String>();
		for (int i=0; i<alen-len+1; i++){
			s.add(a.substring(i, i+len));
		}
//		System.out.println(s);
		for (int i=0; i<blen-len+1; i++){
			if (s.contains(b.substring(i, i+len))){
				return true;
			}
		}
		return false;
	}
}
