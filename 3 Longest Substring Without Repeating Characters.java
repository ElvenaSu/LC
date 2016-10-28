// O(2n)
public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int fast = 0, slow = 0;
    	int longest = 0;
    	Set<Character> hset = new HashSet<>();
    	while (fast < s.length()) {
    		while (!hset.add(s.charAt(fast))) {
    			hset.remove(s.charAt(slow));
    			slow++;
    		}
    		fast++;
    		longest = Math.max(longest, fast-slow);
    	}
    	return longest;
    }
}
// better solution
public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int longest = 0;
    	int[] index = new int[128];
    	Arrays.fill(index, -1);
    	int start = 0;
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		// better than index[c] != -1
    		// don't have to reset index array
    		if (index[c] >= start) {
    			start = index[c] + 1;
    		}
    		longest = Math.max(longest, i - start + 1);
    		index[c] = i;
    	}
    	return longest;
    }
}

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer
must be a substring, "pwke" is a subsequence and not a substring.