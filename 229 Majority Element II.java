public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int m = 0, n = 0, cm = 0, cn = 0;
        for (int num : nums) {
            if (num == m) {
                cm++;
            }else if (num == n) {
                cn++;
            }else if (cm == 0) {
                m = num;
                cm = 1;
            }else if (cn == 0) {
                n = num;
                cn = 1;
            }else {
                cm--;
                cn--;
            }
        }
        cm = cn = 0;
        for (int num : nums) {
            if (num == m) {
                cm++;
            }else if (num == n) {
                cn++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (cm > nums.length/3) {
            res.add(m);
        }
        if (cn > nums.length/3) {
            res.add(n);
        }
        return res;
    }
}

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
