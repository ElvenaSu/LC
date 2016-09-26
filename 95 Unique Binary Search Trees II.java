/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*

 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return helper(1,n);
    }
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start,i-1);
            List<TreeNode> right = helper(i+1, end);

            for (TreeNode nodel : left) {
                for (TreeNode noder : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = nodel;
                    root.right = noder;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
