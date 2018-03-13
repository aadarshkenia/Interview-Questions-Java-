import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class MinHtTrees{
	public static void main(String args[]){
		int n = 4;
		int edges[][] = {{1,0},{1,2},{1,3}};
		List<Integer> output = findMinHeightTrees(n, edges);
		for(int i : output)
			System.out.print(i+" ");
		System.out.println();
	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	int adj[][] = new int[n][n];
    	HashMap<Integer, ArrayList<Integer>> map = new HashMap();

    	int r = edges.length;
    	for(int i = 0; i < r; i++){
    		adj[edges[i][0]][edges[i][1]] = 1;
    		adj[edges[i][1]][edges[i][0]] = 1;
    	}

    	int minHt = Integer.MAX_VALUE;
    	for(int i=0; i < n; i++){
    		boolean vis[] = new boolean[n];
    		int ht = getHeight(i, adj, n, vis);
    		if(ht < minHt)
    			minHt = ht;
    		if(map.containsKey(ht)){
    			ArrayList<Integer> val = map.get(ht);
    			val.add(i);
    		}
    		else{
    			ArrayList<Integer> newList = new ArrayList();
    			newList.add(i);
    			map.put(ht, newList);
    		}
    	}

    	if(map.containsKey(minHt))
    		return map.get(minHt);
    	return new ArrayList();
    }

    static int getHeight(int root, int adj[][], int n, boolean vis[]){
    	vis[root] = true;
    	int maxHt = 0;
    	for(int i=0; i < n; i++){
    		if(i != root){
    			if(adj[root][i] == 1 && !vis[i]){
    				int ht = 1 + getHeight(i, adj, n, vis);
    				if(ht > maxHt)
    					maxHt = ht;
    			}
    		}
    	}
    	return maxHt;
    }
}