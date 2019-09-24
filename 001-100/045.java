/*
45. Jump Game II
Hard

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.
*/

class Solution {
	public int jump(int[] nums) {
		int res = 0, currJumpRange = 0, nextJumpRange = 0;
		if (nums.length < 2) {
			return 0;
		}
		for (int i = 0; i < nums.length; i++) {
			nextJumpRange = Math.max(nextJumpRange, i + nums[i]);
			if (currJumpRange == i) {
				res++;
				currJumpRange = nextJumpRange;
			}
			if (currJumpRange >= nums.length - 1) {
				return res;
			}
		}
		return res;
	}
}
