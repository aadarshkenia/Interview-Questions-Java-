import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class Combinations{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter n:");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter k:");
		int k = Integer.parseInt(br.readLine());
		List<List<Integer>> output = combine(n, k);
		for(List<Integer> list : output)
			System.out.println(list);
		

	}
	
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new ArrayList();
		if(k == 0 && n > 0){
			ans.add(new ArrayList());
			return ans;
		}
		if( k < 0 || n < 1)
			return ans;

		//Fill up for k=1
		List<List<Integer>> prev = new ArrayList();
		for(int i = 1; i<=n; i++){
			List<Integer> curr = new ArrayList();
			curr.add(i);
			prev.add(curr);
		}

		//Fill up remainder of map in bottom up manner
		//Each iteration represents list size
		for(int i=2; i<=k; i++){
			List<List<Integer>> curr = new ArrayList();
			if(prev.size() > 0){
				for(List<Integer> list : prev){
					int firstElem = list.get(0);
					for(int newInsertion=1; newInsertion < firstElem; newInsertion++){
						List<Integer> newList = new ArrayList();
						newList.add(newInsertion);
						for(int j : list)
							newList.add(j);
						curr.add(newList);
					}
				}
				prev = curr;
			}
		}
		return prev;
		//return combineHelper(1, n, k);
	}
	
	public static List<List<Integer>> combineHelper(int start, int n, int k){
		
		List<List<Integer>> ans = new ArrayList();
		if(start <= n && k == 0){
			ans.add(new ArrayList());
			return ans;
		}
		//base case
		if(start > n || k < 1)
			return ans;
		if(k == 1){
			for(int i = start; i <= n; i++){
				List<Integer> curr = new ArrayList();
				curr.add(i);
				ans.add(curr);
			}
		}
		else{
			for(int i=start; i <= n; i++){
				List<List<Integer>> children = combineHelper(i+1, n, k-1);
				if(children.size() > 0){
					for(List<Integer> child : children){
						child.add(0, i);
						ans.add(child);
					}
				}
			}
		}
		return ans;
	}


}
