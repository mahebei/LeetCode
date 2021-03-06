/*
104. Maximum Depth of Binary Tree
Easy

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
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
	public static int traverse(TreeNode root, int depth) {
		if (root == null) return depth;
		depth++;
		depth = Math.max(traverse(root.left, depth),Math.max(traverse(root.right, depth), depth));
		return depth;
	}
	public static int maxDepth(TreeNode root) {
		return traverse(root, 0);
	}
}
