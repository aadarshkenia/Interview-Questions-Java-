class _79{
	public static void main(String args[]){
		char[][] matrix = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}; 
		String word = "ABCESEEEFS";
		System.out.println(exist(matrix, word));
		
	}

	public static boolean exist(char[][] board, String word){
		boolean ans = false;
		int len = word.length();
		int r = board.length;
		int c = r != 0 ? board[0].length : 0;
		for(int i=0; i < r; i++){
			for(int j = 0; j < c; j++){
				if(board[i][j] == word.charAt(0)){
					//Initialize a matrix
					boolean vis[][] = new boolean[r][c];
					ans |= existHelper(vis, i, j, board, word, 1);
					if(ans)
						return true;
				}
			}
		}
		return ans;		
	}
	public static boolean existHelper(boolean vis[][], int r, int c, char[][] board, String word, int nextIndex){
		System.out.println("r: "+r+" c: "+c);
		if(nextIndex > word.length()-1)
			return true;

		int endRow = board.length-1;
		int endCol = 0;
		if(endRow != 0)
			endCol = board[0].length-1;

		char next = word.charAt(nextIndex);
		vis[r][c] = true;
		boolean ans = false;
		int wordLen = word.length();
		//bottom cell
		if(r != endRow){
			if(!vis[r+1][c]){
				if(board[r+1][c] == next){
					if(nextIndex == wordLen-1)
						return true;
					ans |= existHelper(vis, r+1, c, board, word, nextIndex+1);
				}
			}
		}
		//top cell		
		if(!ans && r != 0){
			if(!vis[r-1][c]){
				if(board[r-1][c] == next){
					if(nextIndex == wordLen-1)
						return true;
					ans |= existHelper(vis, r-1, c, board, word, nextIndex+1);
				}
			}
		}

		//right cell
		if(!ans && c != endCol){
			if(!vis[r][c+1]){
				if(board[r][c+1] == next){
					if(nextIndex == wordLen-1)
						return true;
					ans |= existHelper(vis, r, c+1, board, word, nextIndex+1);
				}
			}
		}

		//left cell
		if(!ans && c != 0){
			if(!vis[r][c-1]){
				if(board[r][c-1] == next){
					if(nextIndex == wordLen-1)
						return true;
					ans |= existHelper(vis, r, c-1, board, word, nextIndex+1);
				}
			}
		}

		return ans;

	}


}
