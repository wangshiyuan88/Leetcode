package freq2;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	 public boolean isValidSudoku(char[][] board) {
		 Set<Character> set;
		 for(int i = 0; i < board.length; i++){
			 set = new HashSet<Character>();
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j]!='.'){
					if(set.contains(board[i][j]))
						return false;
					else
						set.add(board[i][j]);
				}
			}
		 }
		 for(int j = 0; j < board[0].length; j++){
			set = new HashSet<Character>();
			 for(int i = 0; i < board.length; i++){
				 if(board[i][j]!='.'){
						if(set.contains(board[i][j]))
							return false;
						else
							set.add(board[i][j]);
				 }
			 }
		 }
		 for(int is = 0; is < 9; is+=3){
			 for(int js = 0; js < 9; js+=3){
				 set = new HashSet<Character>();
				 for(int i = is; i < is+3; i++){
					 for(int j = js; j < js+3; j++){
						 if(board[i][j]!='.'){
								if(set.contains(board[i][j]))
									return false;
								else
									set.add(board[i][j]);
						 }
					 }
				 }
			 }
		 }
		 
		 return false;
	 }
}
