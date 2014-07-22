package v;

public class ValidSudoku {

	    public boolean isValidSudoku(char[][] board) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	    	boolean[] array;
	        int size = board.length;
	        for(int i = 0; i < size ; i++){
	            array = initArray();
	            for(int j = 0; j < size; j++){
	            	if(board[i][j]!='.'){
	            		if(array[Integer.valueOf(board[i][j])-49]){
	            			return false;
	            		}
	            		else
	            			{
	            			array[Integer.valueOf(board[i][j])-49] = true;
	            			}
	            	}
	            }
	        }
	        for(int j = 0; j < size; j++){
	        	array = initArray();
	        	for(int i = 0; i< size; i++){
	        		if(board[i][j]!='.'){
	        			if(array[Integer.valueOf(board[i][j])-49]){        				
	        				return false;
	        			}
	        			else{
	        				array[Integer.valueOf(board[i][j])-49] = true;
	        			}
	        		}
	        	}
	        }
	        for(int row_times = 0; row_times < 3; row_times++){
	        	for(int col_times = 0; col_times < 3; col_times++){
	        		array = initArray();
	        		for(int i = 0; i < 3; i++){
	        			for(int j = 0; j<3; j++){
	        				if(board[i+row_times*3][j+ col_times*3]!='.'){
	        					if(array[Integer.valueOf(board[i+row_times*3][j+ col_times*3])-49]){
	        						return false;
	        					}else
	        						array[Integer.valueOf(board[i+row_times*3][j+ col_times*3])-49] = true;
	        					
	        				}
	        			}
	        		}
	        	}
	        }
			return true;
	    }
	
	private boolean[] initArray(){
		boolean[] array = new boolean[9];
		for(int i = 0; i < array.length; i++){
			array[i] = false;
		}
		return array;
	}
	
	public char[][] generate(String[] input){
		char[][] output = new char[9][];
		for(int i = 0; i < 9; i++){
			output[i] = input[i].toCharArray();
		}
		try{
			
		}catch(Exception e){
			
		}
		return output;
	}
}
