public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        int[] res = new int[2];
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }else if (numbers[i] + numbers[j] > target) {
                j--;
            }else {
                i++;
            }
        }
        return res;
    }
}
//更优解！！！结合binary search和two pointer!
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length <= 1) {
            return new int[]{0, 0};
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int value = numbers[start] + numbers[end];
            if (value == target) {
                return new int[]{start + 1, end + 1};
            } else if (value < target) {
                start = binarySearch(numbers, start + 1, end - 1, target - numbers[end]);
            } else {
                end = binarySearch(numbers, start + 1, end - 1, target - numbers[start]);
            }
        }
        throw new RuntimeException("not found!");
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
