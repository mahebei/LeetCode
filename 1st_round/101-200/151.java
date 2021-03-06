/*
151. Reverse Words in a String
Medium

Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
*/

public class Solution {
	public String reverseWords(String s) {
		while (s.contains("  ")) s = s.replace("  ", " ");
		String[] words = s.trim().split(" ");
		String res = "";
		for (String word : words) {
			res = " " + word.trim() + res;
		}
		return res.substring(1);
	}
}
