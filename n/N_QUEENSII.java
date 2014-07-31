package n;

public class N_QUEENSII {
	 public int totalNQueens(int n) {
		 return totalNQueens(0, new int[n], n);
	 }

	private int totalNQueens(int index, int[] board, int n) {
		if(index == n){
			return 1;
		}
		
		int ret = 0;
		for(int i = 0; i < n; i++){
			
			if(checkVadility(board, index, i)){
				board[index] = i ;
				ret += totalNQueens(index+1, board, n);
			}
		}
		return ret;
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
	
	public static void main(String args[]){
		new N_QUEENSII().totalNQueens(1);
	}
}
