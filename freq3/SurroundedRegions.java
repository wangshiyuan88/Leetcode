package freq3;


public class SurroundedRegions {
	
	// dfs doesn't work as good as bfs in this problem
	 public void solve(char[][] board) {
		 if(board==null||board.length==0)
			 return;
		 for(int j = 0; j < board[0].length; j++){
			dfs(0, j, board);
			dfs(board.length-1, j, board);
		}
		
		for(int i = 1; i < board.length-1; i++){
			dfs(i, 0, board);
			dfs(i, board[0].length-2, board);
		}
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j]=='+')
					board[i][j] = 'O';
				else
					board[i][j] = 'X';
			}
		}
		
	 }

	private void dfs(int i, int j, char[][] board) {
		if(i<0||j<0||i>board.length-1||j>board[0].length-1)
			return;
		if(board[i][j]!='O')
			return;
		board[i][j] = '+';
		dfs(i-1, j, board);
		dfs(i+1, j, board);
		dfs(i, j+1, board);
		dfs(i, j-1, board);	
	}
}
