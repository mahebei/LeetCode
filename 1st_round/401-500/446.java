/*
446. Arithmetic Slices II - Subsequence
Hard

A sequence of numbers is called arithmetic if it consists of at least three elements
and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9

The following sequence is not arithmetic.
1, 1, 2, 5, 7


A zero-indexed array A consisting of N numbers is given.
A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk]
is arithmetic. In particular, this means that k ≥ 2.

The function should return the number of arithmetic subsequence slices in the array A. 

The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000.
The output is guaranteed to be less than 231-1.


Example: 
Input: [2, 4, 6, 8, 10]

Output: 7

Explanation:
All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
*/

/*
Keep a map for each ele in the array, to store the diff and the num of arithmetic sequences so far by the corresponding diff.
*/

class Solution {
	public int numberOfArithmeticSlices(int[] A) {
		int res = 0;
		HashMap<Integer, Integer>[] diffMaps = new HashMap[A.length];
		for (int i = 0; i < A.length; i++) {
			diffMaps[i] = new HashMap<>();
			for (int j = 0; j < i; j++) {
				if ((long) A[i] - A[j] > Integer.MAX_VALUE
						|| (long) A[i] - A[j] < Integer.MIN_VALUE) continue;
				int count = diffMaps[j].getOrDefault(A[i] - A[j], 0);
				res += count;
				diffMaps[i].put(A[i] - A[j], diffMaps[i].getOrDefault(A[i] - A[j], 0) + count + 1);
			}
		}
		return res;
	}
}
