package s;

public class SudokuSolver {
	 public void solveSudoku(char[][] board) {
	     if(board==null||board.length==0){
	    	 return;
	     }
		 solve(board);
	    }
	 
	 public boolean solve(char[][] board){
		 for(int i = 0; i < board.length; i++){
			 for(int j = 0; j < board[0].length; j++){
				 if(board[i][j]=='.'){
					 for(char c = '1'; c <= '9'; c++){
						 board[i][j] = c;
						 if(isValid(i, j, board)&&solve(board)){
							 return true;
						 }
						 board[i][j] = '.';
					 }
					 return false;
				 }
			 }
		 }
		 return true;
	 }
	 public boolean isValid(int i, int j, char[][]board){
		 char num = board[i][j];
		 for(int x = 0; x < board.length; x++){
			 if(x!=i&&num==board[x][j]){
				 return false;
			 }
		 }
		 for(int y = 0; y < board[0].length; y++){
			 if(y!=j&&num==board[i][y]){
				 return false;
			 }
		 }
		 
		 int base_i = i/3;
		 int base_j = j/3;
		 
		 for(int x = base_i*3; x < base_i*3+3; x++){
			 for(int y = base_j*3; y < base_j*3+3; y++){
				 if((x!=i||y!=j)&&board[x][y]==num){
					 return false;
				 }
			 }
		 }
		 
		 return true;
	 }
}
