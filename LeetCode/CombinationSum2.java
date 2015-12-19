import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class CombinationSum2{
	public static void main(String args[]){
		int x[] = {1, 1, 1, 4, 5, 10};
		int target = 7;
		
		Arrays.sort(x);
		//Method call
		ArrayList<ArrayList<Integer>> sets = getSubsets(x, 0, x.length-1, target);
		for(ArrayList<Integer> smallList : sets)
			System.out.println(smallList);
	}

	//Recursive function defn: x is sorted
	public static ArrayList<ArrayList<Integer>> getSubsets(int x[], int start, int end, int sum){
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(start > end || sum == 0)
			return ans;
		else{
			for(int i=start; i<=end; i++){
				if(i==start || x[i]!=x[i-1]){
					if(x[i] == sum){
						ArrayList<Integer> temp = new ArrayList();
						temp.add(x[i]);
						ans.add(temp);
					}
					else if(x[i] < sum){
						int diff = sum - x[i];
						ArrayList<ArrayList<Integer>> diffLists = getSubsets(x, i+1, end, diff);
						if(diffLists.size() > 0){
							for(ArrayList<Integer> diffSubList : diffLists)
								if(diffSubList.size() > 0){
									diffSubList.add(0, x[i]);
									ans.add(diffSubList);	
								}
						}
					}
							
				}
			}
		}
		return ans;
	}

	//Alternate DP solution
	public static List<List<Integer>> getSubsetsDP(int candidates[], int target){
		List<List<Integer>> ans = new ArrayList();
		int n = candidates.length;
		//Outer map: key = target val
		//Inner map: key = index of array elem
		HashMap<Integer, HashMap<Integer, List<List<Integer>>>> map = new HashMap();
		for(int i=1; i<=target; i++){
			for(int j=0; j < n; j++){
				if(candidates[j] == i && (j==0 || candidates[j] != candidates[j-1])){
					List<Integer> temp = new ArrayList();
					temp.add(candidates[j]);
					//continue from here
				}
			}
		}
	}



}
