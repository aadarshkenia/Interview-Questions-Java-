import java.util.*;

class CombinationSum3{
	public static void main(String args[]){
		int k = 4, n = 20;
		List<List<Integer>> ans = combinationSum3(k, n);
		for(List<Integer> sublist : ans)
			System.out.println(sublist);
	}

	static List<List<Integer>> combinationSum3(int k, int n){
		List<List<Integer>> ans = new ArrayList();
		helper(k, n, 1, ans, new ArrayList());
		return ans;
	}

	static void helper(int k, int n, int start, List<List<Integer>> lists, List<Integer> currentList){
		//System.out.println("CL: "+currentList);
		/*
		if(k == 1 && n >= start && n < 9){
			currentList.add(n);
			lists.add(currentList);
			return;
		}
		*/

		if(k == 0){
			if(n == 0){
				List<Integer> copy = copyList(currentList);
				lists.add(copy);
			}
			return;
		}
		
		for(int i=start; i <= 9; i++){
			if(i <= n){
				currentList.add(i);
				helper(k-1, n-i, i+1, lists, currentList);
				currentList.remove(currentList.size()-1);
			}
		}	
	}

	static List<Integer> copyList(List<Integer> orig){
		List<Integer> copy = new ArrayList();
		for(int i: orig)
			copy.add(i);
		return copy;
	}
}
