/*
111. Minimum Depth of Binary Tree
Easy

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		int l = 1 + minDepth(root.left);
		int r = 1 + minDepth(root.right);
		if (root.left == null || root.right == null) {
			return Math.max(l, r);
		}
		return Math.min(l, r);
	}
}
