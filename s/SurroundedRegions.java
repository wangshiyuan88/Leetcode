package s;

import java.util.LinkedList;


public class SurroundedRegions {
	public void solve(char[][] board) {
		if(board.length==0)return ;
		for(int i = 0; i < board.length; i++){
			bfs(i , 0,  board, new LinkedList<Integer>());
			bfs(i , board[0].length-1,  board,new LinkedList<Integer>());
		}
		for(int j = 0; j < board[0].length; j++){
			bfs(0 , j,  board,new LinkedList<Integer>());
			bfs(board.length-1 , j,  board,new LinkedList<Integer>());
		}
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j]!='+'){
					board[i][j]='X';
				}else{
					board[i][j]='O';
				}
			}
		}
    }

	private void bfs(int i, int j, char[][] board, LinkedList<Integer> linkedList) {
		visit(i, j, board, linkedList);
		
		while(!linkedList.isEmpty()){
			int x = linkedList.peek()/board[0].length;
			int y = linkedList.peek()%board[0].length;
			visit(x+1 , y,  board, linkedList);
			visit(x-1 , y,  board, linkedList);
			visit(x , y+1,  board, linkedList);
			visit(x , y-1,  board, linkedList);
			linkedList.pop();
		}
	}
	
	private void visit(int i , int j, char[][]board, LinkedList<Integer> linkedList){
		if(i<0||i>=board.length||j<0||j>=board[0].length){
			return;
		}
		if(board[i][j]!='O'){
			return;
		}
		board[i][j] = '+';
		linkedList.add(i*board[0].length+j);
	}
}
