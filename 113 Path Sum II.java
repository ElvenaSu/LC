
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> res = new ArrayList<>();
    	if (root == null) {
    		return res;
    	}
    	helper(root, sum, res, new ArrayList<Integer>());
    	return res;
    }
    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
    	list.add(root.val);
    	if (root.left == null && root.right == null && root.val == sum) {
    		res.add(new ArrayList<>(list));
    		//list.remove(list.size()-1);
    		//return;
    	}
    	if (root.left != null) {
    		helper(root.left, sum - root.val, res, list);
    	}
    	if (root.right != null) {
    		helper(root.right, sum - root.val, res, list);
    	}
        list.remove(list.size()-1);
    }
}

Given a binary tree and a sum,
find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
