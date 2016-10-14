//brute force O(n) solution
public class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return i;
            }
        }
        return nums.length-1;
    }
}

// requirement O(logn) solution, binary search
public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1;
        // l < r - 1 to avoid mid - 1 < 0 or mid + 1 > length
        while (l < r - 1) {
            int mid = l + ((r-l)>>1);
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid+1]) {
                return mid;
            }else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                l = mid;
            }else {
                r = mid;
            }
        }
         return nums[l] > nums[r] ? l: r;
    }
}
