package freq3;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public List<String[]> solveNQueens(int n) {
		int[] board = new int[n];
		List<String[]> result = new ArrayList<String[]>();
		solveQueen(0, board, result);
		return result;
    }

	private void solveQueen(int index, int[] board, List<String[]> result) {
		if(index==board.length){
			result.add(convertToResult(board));
		}
		for(int i = 0; i < board.length; i++){
			if(checkValid(board, index, i)){
				board[index] = i;
				solveQueen(index+1, board, result);
			}
		}
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
	
	public String[] convertToResult(int[] board){
		String[] ret = new String[board.length];
		for(int i = 0; i < ret.length; i++){
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < ret.length; j++){
				if(j==board[i])
					sb.append("Q");
				else
					sb.append(".");
			}
			ret[i] = sb.toString();
		}
		return ret;
	}
}

