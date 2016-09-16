public class Solution {
    public int maxRotateFunction(int[] A) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            int start = i;
            for (int j = 0; j < A.length; j++) {
                sum += start*A[j];
                start++;
                if (start == A.length) {
                    start = 0;
                }
            }
            maxValue = Math.max(maxValue, sum);
        }
        return maxValue;
    }
}
