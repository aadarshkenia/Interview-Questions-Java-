//GAME OF LIFE

class _289{
	public static void main(String args[]){
		int b[][] = {{1,0,0}, {0,0,1}, {1,0,0}};
		print(b);
		System.out.println("Next state: ");
		gameOfLife(b);
		print(b);
	}
	public static void gameOfLife(int[][] board) {
    	int r = board.length;
		if(r < 0)
			return;
		int c = board[0].length;

		for(int i=0; i < r; i++)
			for(int j = 0; j < c; j++){
				int cellVal = board[i][j];
				int newState=0;
				if(cellVal == 0)
					newState = getNewState(0, i, j, board);
				else if(cellVal == 1)
					newState = getNewState(1, i, j, board);
				board[i][j] = newState;	
			}

		// print(board);
		//Update board with new vals
		for(int i=0; i < r; i++)
			for(int j = 0; j < c; j++){
				if(board[i][j] == 2)
					board[i][j] = 1;
				if(board[i][j] == 3)
					board[i][j] = 0;
			}
    }
	
	
	private static int getNewState(int oldState, int r, int c, int[][] board){
		int nr = board.length;
		int nc = board[0].length;

		int liveCount = 0;
		if(r != 0){
			if(c != 0)
				if(board[r-1][c-1] % 2 == 1)
					liveCount++;
			if(c != nc-1)
				if(board[r-1][c+1] % 2 == 1)
					liveCount++;
			if(board[r-1][c] % 2 == 1)
				liveCount++;
		}


		if(r != nr-1){
			
			if(c != 0)
				if(board[r+1][c-1] % 2 == 1)
					liveCount++;
			if(c != nc-1)
				if(board[r+1][c+1] % 2 == 1)
					liveCount++;
			if(board[r+1][c] % 2 == 1)
				liveCount++;
		}

		if(c != 0)
			if(board[r][c-1] %2 == 1)
				liveCount++;
		
		if(c != nc-1)
			if(board[r][c+1] %2 == 1)
				liveCount++;

		if(oldState == 0){
			if(liveCount == 3)
				return 2;
			else
				return 0;
		}
		if(oldState == 1){
			if(liveCount < 2 || liveCount > 3)
				return 3;
			else
				return 1;
		}
			
		//Should never reach here.
		System.out.println("Something is wrong!");
		return -1;
	}

	private static void print(int board[][]){
		int nr = board.length;
		int nc = board[0].length;
		for(int i=0; i < nr; i++){
			for(int j=0; j < nc; j++)
				System.out.print(board[i][j] + " "); 
			System.out.println();
		}

	}

}
