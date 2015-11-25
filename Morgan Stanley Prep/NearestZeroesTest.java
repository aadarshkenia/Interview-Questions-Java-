import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class NearestZeroesTest{
	public static void main(String args[]){
		NearestZeroes nz = new NearestZeroes();
		int r = 4;
		int c = 3;
		int input[][] = new int[r][c];
		input[0][0] = -1;
		input[0][2] = -1;
		input[1][0] = -1;
		input[1][1] = -1;
		input[1][2] = -1;
		input[2][0] = -1;
		input[2][1] = -1;
		input[2][2] = -1;
		input[3][0] = -1;
		input[3][1] = -1;


		int output[][] = nz.findDistance(input, r, c);
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(output[i][j]+" ");
			}
			System.out.println();
		}
	}
}


class NearestZeroes{

	public int[][] findDistance(int input[][], int r, int c){
		
		boolean filled[][] = new boolean[r][c];
		int output[][] = new int[r][c];

		ArrayList<Position> zeroPositions = getZeroPositions(input, r, c);
		Queue<Position> queue = new LinkedList();
		for(Position position : zeroPositions){
			queue.add(position);
			filled[position.row][position.col] = true;
			output[position.row][position.col] = 0;
		}

		while(!queue.isEmpty()){
			Position current = queue.remove();
			
			//left elem
			if(current.col !=0 && !filled[current.row][current.col-1]){
				Position left = new Position(current.row, current.col-1, current.dist+1);
				queue.add(left);
				output[left.row][left.col] = left.dist; 
				filled[left.row][left.col] = true;
			}

			//right elem
			if(current.col != c-1 && !filled[current.row][current.col+1]){
				Position right = new Position(current.row, current.col+1, current.dist+1); 
				queue.add(right);
				output[right.row][right.col] = right.dist;
				filled[right.row][right.col] = true;
			}

			//top elem
			if(current.row !=0 && !filled[current.row-1][current.col]){
				Position top = new Position(current.row-1, current.col, current.dist+1); 
				queue.add(top);
				output[top.row][top.col] = top.dist;
				filled[top.row][top.col] = true;
			}

			//bottom elem
			if(current.row !=r-1 && !filled[current.row+1][current.col]){
				Position bottom = new Position(current.row+1, current.col, current.dist+1);
				queue.add(bottom);
				output[bottom.row][bottom.col] = bottom.dist;
				filled[bottom.row][bottom.col] = true;
			}
		}

		return output;
	}

	//Finds positions of zero in the input matrix
	public ArrayList<Position> getZeroPositions(int input[][], int r, int c){
		ArrayList<Position> zeroPos = new ArrayList();
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++){
				if(input[i][j]==0){
					Position zero = new Position(i,j,0);
					zeroPos.add(zero);
				}
			}
		return zeroPos;
	}


}

class Position{
	int row;
	int col;
	int dist;

	Position(int row, int col, int dist){
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
}

