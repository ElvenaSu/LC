Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000,
and there exists one unique longest palindromic substring.

public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
		String res = "";
		for (int i = 0; i < s.length()-1; i++) {
			String a = getPanlindrome(s, i, i);
			String b = getPanlindrome(s, i, i+1);
			if (a.length() > res.length()) {
				res = a;
			}
			if (b.length() > res.length()) {
				res = b;
			}
		}
		return res;
	}
	private String getPanlindrome(String s, int left, int right) {
		if (s.charAt(left) != s.charAt(right)) {
			return s.substring(left, right);
		}
		int idx = 0;
		while (left - idx >= 0 && right + idx < s.length() && s.charAt(left - idx) == s.charAt(right + idx)) {
			idx++;
		}
		return idx == 0? s.substring(left, right+1) : s.substring(left-idx+1, right+idx);
	}
}