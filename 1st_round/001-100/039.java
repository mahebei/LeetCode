/*
39. Combination Sum

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

class Solution {
	public List<List<Integer>> check(int[] candidates, int target, List<List<Integer>> res, List<Integer> item) {
		if (target == 0) {
			res.add(new LinkedList<>(item));
		} else {
			for (int i = 0; i < candidates.length; i++) {
				target -= candidates[i];
				if (target >= 0) {
					item.add(candidates[i]);
					res = check(Arrays.copyOfRange(candidates, i, candidates.length), target, res, item);
				}
				target += candidates[i];
			}
		}
		if (item.size() > 0) {
			item.remove(item.size() - 1);
		}
		return res;
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new LinkedList<>();
		return check(candidates, target, res, new LinkedList<>());
	}
}
