/*
68. Text Justification
Hard

Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters 
and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line 
do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
*/

class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new LinkedList<>();
		int count = 0;
		int len = words[0].length();
		String item = "";
		for (int i = 1; i < words.length; i++) {
			if (len + words[i].length() + 1 > maxWidth) {
				len = maxWidth - len;
				item = words[i - 1] + item;
				if (count > 0) {
					for (int j = 1; j <= count; j++) {
						for (int k = 0; k <= len / (count - j + 1); k++) {
							item = " " + item;
						}
						len -= len / (count - j + 1);
						item = words[i - j - 1] + item;
					}
				} else {
					for (int j = 0; j < len; j++) {
						item += " ";
					}
				}
				res.add(item);
				item = "";
				len = words[i].length();
				count = 0;
			} else {
				len += words[i].length() + 1;
				count++;
			}
		}
		item = words[words.length - 1];
		for (int i = 1; i <= count; i++) {
			item = words[words.length - i - 1] + " " + item;
		}
		len = item.length();
		for (int i = 0; i < maxWidth - len; i++) {
			item += " ";
		}
		res.add(item);
		return res;
	}
}