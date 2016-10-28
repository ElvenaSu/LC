/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 错误示范！！！ fail test case: [10,5,15,null,null,6,20]
public class Solution {
    public boolean isValidBST(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	if (root.left != null && root.left.val >= root.val) {
    		return false;
    	}
    	if (root.right != null && root.right.val <= root.val) {
    		return false;
    	}
    	return isValidBST(root.left) && isValidBST(root.right);
    }
}

// 正确解法, 但是 fail test case: [2147483647]
public class Solution {
	public boolean isValidBST(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public boolean helper(TreeNode node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.val < min || node.val > max) {
			return false;
		}
		return helper(node.left, min, node.val) &&
					helper(node.right, node.val, max);
	}
}

// 正确解法, 中序遍历 inorder traversal, BFS来做
public class Solution {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		List<Integer> nodes = new ArrayList<>();
		helper(root, nodes);
		for (int i = 0; i < nodes.size()-1; i++) {
			if (nodes.get(i) >= nodes.get(i+1)) {
				return false;
			}
		}
		return true;
	}
	public void helper(TreeNode root, List<Integer> nodes) {
		if (node == null) {
			return;
		}
		helper(root.left, nodes);
		nodes.add(root.val);
		helper(root.right, nodes);
	}
}