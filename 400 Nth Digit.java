public class Solution {
    public int findNthDigit(int n) {
        int digits = 1, base = 9, ith = 1;
        while (n > (long)base*digits) {
            n -= base*digits++;
            ith *= 10;
            base *= 10;
        }
        String str = Integer.toString(ith+(n-1)/digit);
        return str.charAt((n - 1) % digit) - '0';
    }
}
