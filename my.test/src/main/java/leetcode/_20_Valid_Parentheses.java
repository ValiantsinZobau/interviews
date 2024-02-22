package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * 
 * Example 1:
 * 
 * Input: "()" Output: true Example 2:
 * 
 * Input: "()[]{}" Output: true Example 3:
 * 
 * Input: "(]" Output: false Example 4:
 * 
 * Input: "([)]" Output: false Example 5:
 * 
 * Input: "{[]}" Output: true
 * 
 * @author vz
 *
 */
public class _20_Valid_Parentheses {
	public static void main(String[] args) {
		System.out.println(new Solution().isValid("({})"));
	}

	static class Solution {

		public boolean isValid(String s) {
			Set<Character> openBrackets = new HashSet<>();
			openBrackets.add('(');
			openBrackets.add('{');
			openBrackets.add('[');
			Map<Character, Character> pairs = new HashMap<>();
			pairs.put('(', ')');
			pairs.put('{', '}');
			pairs.put('[', ']');

			LinkedList<Character> list = new LinkedList<>();
			for (int i = 0; i < s.length(); i++) {
				Character ch = s.charAt(i);
				if (!list.isEmpty()) {
					Character last = list.getLast();
					if (!openBrackets.contains(ch)) {
						if (!ch.equals(pairs.get(last))) {
							return false;
						} else {
							list.removeLast();
						}
					} else {
						list.add(ch);
					}

				} else {
					list.add(ch);
				}

			}
			return list.isEmpty();
		}
	}
}
