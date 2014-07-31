package n;

import java.util.ArrayList;
import java.util.List;

public class N_QUEENS {
	public List<String[]> solveNQueens(int n) {
		int[] board = new int[n];
		for (int i = 0; i < board.length; i++) {
			board[i] = -1;
		}
		List<String[]> retList = new ArrayList<String[]>();
		solveNQueens(0, board, retList, n);
		return retList;
	}

	private void solveNQueens(int index, int[] board, List<String[]> retList,
			int n) {
		if (index == board.length) {
			retList.add(convert(board));
		}

		for (int i = 0; i < n; i++) {
			if (checkVadility(board, index, i)) {
				board[index] = i;
				solveNQueens(index + 1, board, retList, n);
				board[index] = -1;
			}
		}

	}

	private boolean checkVadility(int[] board, int index, int numToFill) {
		for (int i = 0; i < index; i++) {
			if (board[i] == numToFill)
				return false;
			if (Math.abs(index - i) == Math.abs(numToFill - board[i]))
				return false;
		}
		return true;
	}

	private String[] convert(int[] board) {
		String[] ret = new String[board.length];

		for (int i = 0; i < ret.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < ret.length; j++) {
				if (board[i] == j) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			ret[i] = sb.toString();
		}
		return ret;
	}
}
