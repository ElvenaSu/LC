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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);

    }
    private TreeNode helper(int[] preorder, int[] inorder, int pstart, int instart, int inend) {
        if (instart > inend || pstart >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int idx = -1;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == preorder[pstart]) {
                idx = i;
            }
        }
        if (idx == -1) {
            return null;
        }
        root.left = helper(preorder, inorder, pstart+1, instart, idx - 1);
        root.right = helper(preorder, inorder, pstart+1+idx-instart,idx + 1, inend);
        return root;
    }
}
