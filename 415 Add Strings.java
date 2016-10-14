public class Solution {
    public String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1, carry = 0;
        String sum = "";
        while (idx1 >= 0 || idx2 >= 0) {
            int tmp = carry;
            tmp += idx1 >= 0 ? (num1.charAt(idx1)-'0') : 0;
            tmp += idx2 >= 0 ? (num2.charAt(idx2)-'0') : 0;
            sum = tmp%10 + sum;
            carry = tmp/10;
            idx1--;
            idx2--;
        }
        return carry > 0 ? carry+sum : sum;
    }
}
