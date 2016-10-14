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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length-1, 0, inorder.length-1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int proot, int instart, int inend) {
        if (proot < 0 || instart > inend) {
                    return null;
        }
        TreeNode root = new TreeNode(postorder[proot]);
        int idx = -1;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == root.val) {
                idx = i;
            }
        }
        if (idx == -1) {
            return null;
        }
        int rightsize = inend - idx;
        root.left = helper(inorder, postorder, proot-1-rightsize, instart, idx-1);
        root.right = helper(inorder, postorder, proot-1,idx+1, inend);
        return root;
    }
}

Given inorder and postorder traversal of a tree, construct the binary tree.
Duplicates do not exists.
