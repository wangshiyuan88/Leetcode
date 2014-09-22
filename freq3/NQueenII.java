package freq3;


public class NQueenII {
	public int totalNQueens(int n) {
		int[] board = new int[n];
		return solveQueen(0, board);
    }
	
	private int solveQueen(int index, int[] board) {
		if(index==board.length){
			return 1;
		}
		int result = 0;
		for(int i = 0; i < board.length; i++){
			if(checkValid(board, index, i)){
				board[index] = i;
				result +=solveQueen(index+1, board);
			}
		}
		return result;
	}
	
	private boolean checkValid(int[] board, int index, int num){
		for(int i = 0; i < index; i++){
			if(board[i]==num)
				return false;
			if(Math.abs(board[i]-num)==Math.abs(i-index))
				return false;
		}
		return true;
	}
}
