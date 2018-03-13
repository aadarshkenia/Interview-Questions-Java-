lass DetermineSCC{
	public static void main(String args[]){
		Graph g = new Graph("input_scc.txt");
		System.out.println("n: "+g.n);
		System.out.println(isSCC(g.adj, g.n));

	}

	public static boolean isSCC(int adj[][], int n){
		int root = 1;
		boolean vis[] = new boolean[n+1];
		if(dfs(n, root, adj, vis) == n){
			int trans[][] = transpose(adj, n);
			//Reset vis matrix
			for(int i=1; i<=n; i++)
				vis[i] = false;
			
			if(dfs(n, root, trans, vis) == n)
				return true;
		}
		return false;

	}

	//Returns number of nodes traversed
	public static int dfs(int n, int root, int adj[][], boolean vis[]){
		vis[root] = true;
		int retVal = 1;
		for(int i=1; i<=n; i++){
			if(adj[root][i] == 1 && !vis[i])
				retVal += dfs(n, i, adj, vis);
		}
		return retVal;
	}

	public static int[][] transpose(int[][] adj, int n){
		int trans[][] = new int[n+1][n+1];
		for(int i=1; i <= n; i++){
			for(int j=1; j <= n; j++){
				if(adj[i][j] == 1)
					trans[j][i] = 1;			
			}
		}
		return trans;
	}

}
