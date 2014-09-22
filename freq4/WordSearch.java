package freq4;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
	     boolean[] trace = new boolean[board.length*board[0].length];
	     for(int i = 0; i < trace.length; i++){
	    	 trace[i] = false;
	     }
	     for(int i = 0; i < board.length; i++){
	    	 for(int j = 0; j < board[0].length; j++){
	    		 if(findWord(i, j, 0, word, trace, board))
	    			 return true;
	    	 }
	     }
		return false;
	}

	private boolean findWord(int i, int j, int index, String word, boolean[] trace, char[][] board) {
		if(i<0||i>=board.length||j<0||j>=board[0].length)
			return false;
		if(board[i][j]!=word.charAt(index))
			return false;
		if(trace[i*board[0].length+j])
			return false;
		trace[i*board[0].length+j]=true;
		if(findWord(i+1, j, index+1, word, trace, board)||findWord(i, j+1, index+1, word, trace, board)||findWord(i-1, j, index+1, word, trace, board)||findWord(i, j-1, index+1, word, trace, board))
			return true;
		trace[i*board[0].length+j]=false;
		return false;
	}
}
