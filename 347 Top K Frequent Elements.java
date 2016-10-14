public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        //List<Integer>[] count = new List<Integer>[nums.length+1];
        //申明一个list array的方法。。。学着点啊。。。
        List<Integer>[] count = new List[nums.length+1];
        for (int num : hm.keySet()) {
            int tmp = hm.get(num);
            if (count[tmp] == null) {
                count[tmp] = new ArrayList<Integer>();
            }
            count[tmp].add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i > 0 & k > 0; i--) {
            if (count[i] != null) {
                res.addAll(count[i]);
                k -= count[i].size();
            }
        }
        return res;
    }
}

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n)
