/*
416. Partition Equal Subset Sum
Medium

Given a non-empty array containing only positive integers,
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal. 

Note:

1.Each of the array element will not exceed 100.
2.The array size will not exceed 200.


Example 1: 
Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].



Example 2: 
Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
*/

class Solution {
	public boolean canPartition(int[] nums) {
		if (nums.length < 2) return false;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 == 1) return false;
		sum /= 2;
		boolean[] memo = new boolean[sum + 1];
		memo[0] = true;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= sum) {
				for (int j = sum; j - nums[i] >= 0; j--) {
					memo[j] = memo[j] || memo[j - nums[i]];
				}
			} else {
				return false;
			}
		}
		return memo[sum];
	}
}
