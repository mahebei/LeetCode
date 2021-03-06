/*
65. Valid Number
Hard

Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.
*/

class Solution {
	public boolean isNumber(String s) {
		s = s.trim();
		boolean num = false;
		boolean point = false;
		boolean e = false;
		boolean eNum = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				num = true;
				eNum = true;
			} else if (s.charAt(i) == '.') {
				if (point || e) {
					return false;
				}
				point = true;
			} else if (s.charAt(i) == 'e') {
				if (!num || e) {
					return false;
				}
				e = true;
				eNum = false;
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				if (i != 0 && s.charAt(i - 1) != 'e') {
					return false;
				}
			} else {
				return false;
			}
		}
		return num && eNum;
	}
}
