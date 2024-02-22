package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 * @author vz
 *
 */
public class _79_word_search {

	public static void main(String[] args) {
		
		char[][] board = new char[][] {
			new char[] { 'F','Y','C','E','N','R','D'},
			new char[] { 'K','L','N','F','I','N','U'},
			new char[] { 'A','A','A','R','A','H','R'},
			new char[] { 'N','D','K','L','P','N','E'},
			new char[] { 'A','L','A','N','S','A','P'},
			new char[] { 'O','O','G','O','T','P','N'},
			new char[] { 'H','P','O','L','A','N','O'}
		};

		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		String word = "POLAND";
		System.out.println("Word: " + word);
		System.out.println(new Solution().exist(board, word));
	}

	static class Solution {
		public boolean exist(char[][] board, String word) {
			for (int i = 0; i < board.length; i++) {
				char[] boardRow = board[i];
				for (int j = 0; j < boardRow.length; j++) {
					boolean exist = checkWord(board, i, j, word, 0, new HashMap<String, Boolean>());
					if (exist) {
						return true;
					}
				}
			}
			return false;
		}

		public boolean checkWord(char[][] board, int row, int column, String word, int wordPosition,
				Map<String, Boolean> usedPositions) {
			if (wordPosition >= word.length()) {
				return false;
			}
			char wordChar = word.charAt(wordPosition);
			char boardChar = board[row][column];
			if (boardChar == wordChar) {
				if (usedPositions.containsKey(key(row, column))) {
					return false;
				}
				if(wordPosition == word.length() -1) {
					return true;
				}
				usedPositions.put(key(row, column), true);
				wordPosition++;
				boolean checkTop = row - 1 >= 0 && checkWord(board, row - 1, column, word, wordPosition, usedPositions);
				boolean checkRight = column + 1 <= board[row].length - 1
						&& checkWord(board, row, column + 1, word, wordPosition, usedPositions);
				boolean checkBottom = row + 1 <= board.length - 1
						&& checkWord(board, row + 1, column, word, wordPosition, usedPositions);
				boolean checkLeft = column - 1 >= 0
						&& checkWord(board, row, column - 1, word, wordPosition, usedPositions);
				boolean check = checkTop || checkRight || checkBottom || checkLeft;
				if(!check) {
					usedPositions.remove(key(row,column));
				}
				return check;
			}
			return false;
		}

		public String key(int i, int j) {
			return i + "," + j;
		}
	}
}
