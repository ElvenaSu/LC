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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> zigzag = new ArrayList<>();
    	if (root == null) {
    		return zigzag;
    	}
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	Boolean oddrow = true;
    	while (!queue.isEmpty()) {
    		int size = queue.size();
    		List<Integer> tmp = new ArrayList<>();
    		for (int i = 0; i < size; i++) {
    			TreeNode node = queue.poll();
    			if (node != null) {
    				tmp.add(node.val);
    				if (node.left != null){
    					queue.offer(node.left);
    				}
    				if (node.right != null) {
    					queue.offer(node.right);
    				}
    			}
    		}
    		if (!oddrow) {
    			Collections.reverse(tmp);
    			oddrow = true;
    		}else{
    			oddrow = false;
    		}
    		zigzag.add(tmp);

    	}
    	return zigzag;
    }
}

Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]