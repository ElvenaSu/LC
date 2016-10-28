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
    public int pathSum(TreeNode root, int sum) {
    	if (root == null) {
    		return 0;
    	}
        return pathSum(root.left, sum) + pathSum(root.right, sum) + helper(root, sum);
    }
    private int helper(TreeNode root, int sum) {
        int res = 0;
    	if (root == null) {
            return res;
        }
        if (root.val == sum) {
            res++;
    	}
    	if (root.left != null) {
    		res += helper(root.left, sum - root.val);
    	}
    	if (root.right != null) {
    		res += helper(root.right, sum - root.val);
    	}
        return res;
    }
}