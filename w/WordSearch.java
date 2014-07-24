package w;


public class WordSearch {
	
	
	public class Solution {
		   public boolean exist(char[][] board, String word) {
				    if(word.length() == 0)return false;
				    if(board.length==0||board[0].length==0)return false;
		        	boolean[] trace = new boolean[board.length * board[0].length];
					
					for(int i = 0; i < board.length; i++){
						for(int j = 0; j < board[0].length; j++)
							trace[i*board[0].length+j] = false;
					}
					for(int i = 0; i < board.length; i++){
						for(int j = 0; j< board[0].length; j++){
							if(findWord(board, i, j, word,0, trace))
								return true;
						}
					}
			        return false;
			    }

			private boolean findWord(char[][] board, int i, int j, String word, int index,
					boolean[]trace) {
				if(index == word.length())
					return true;
				if(i<0||i>=board.length||j<0||j>=board[0].length)
					return false;
				if(trace[i*board[0].length+j])
					return false;
				char currentChar = word.charAt(index);
				trace[i*board[0].length+j] = true;
				if((board[i][j]==currentChar)&&(findWord(board, i+1, j, word, index+1, trace)||findWord(board, i-1, j, word, index+1, trace)||
						findWord(board, i, j+1, word, index+1, trace)||findWord(board, i, j-1, word, index+1, trace)))
					return true;
				trace[i*board[0].length+j] = false;
				return false;
			}
		}
}
