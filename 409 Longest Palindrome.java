public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[(int)s.charAt(i)]++;
        }
        int res = 0;
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i]%2 > 1) {
                odd = 1;
            }
            res += (count[i]>>1)*2;
        }
        return res+odd;
    }
}
