class TransitiveClosure{
	public static void main(String args[]){
		Graph g = new Graph("input_transitive.txt");
		int tc[][] = transitiveClosure(g.adj, g.n);
		
		for(int i=1; i<=g.n; i++){
			for(int j=1; j<=g.n; j++)
				System.out.print(tc[i][j]+" ");
			System.out.println();
		}
	}

	public static int[][] transitiveClosure(int[][] adj, int n){
		int tc[][] = new int[n+1][n+1];
		//Init transitive closure to adjacency
		for(int i=1; i<=n; i++)
			for(int j=1; j<=n; j++)
				tc[i][j] = adj[i][j];

		for(int k=1; k<= n; k++)
			for(int i=1; i<=n; i++)
				for(int j=1; j<=n; j++)
					if(tc[i][j] == 0)
						if(tc[i][k] == 1 && tc[k][j] == 1)
							tc[i][j] = 1;
						
		return tc;		
	}
}
