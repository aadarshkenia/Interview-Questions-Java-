import java.util.*;
class _39 {

	public static void main(String args[]) {
		int candidates[] = {1,2};
		int target = 3;
		System.out.println(new _39().combinationSum(candidates, target));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
     	if(candidates == null || target < 0) throw new IllegalArgumentException();
     	int n = candidates.length;
     	List<List<List<Integer>>> dp = new ArrayList<>(target);
     	for(int i = 1; i <= target; i++) {
     		List<List<Integer>> temp = new ArrayList<>();
     		for(int j = 0; j < n && i >= candidates[j]; j++) { 
     			if(candidates[j] == i) { //special case
     				List<Integer> t1 = new ArrayList<>();
     				t1.add(candidates[j]);
     				temp.add(t1);
     			} else {
     				List<List<Integer>> sublists = dp.get(i - candidates[j] - 1);
     				for(List<Integer> sublist : sublists) {
	     				if(sublist.size() > 0 && sublist.get(sublist.size() - 1) <= candidates[j]) {
	 						temp.add(getList(candidates[j], sublist));
	 					}
     				}	
     			}
     		}
     		dp.add(i-1, temp);
     	}
     	return dp.get(target-1);
    }

    private List<Integer> getList(int elem, List<Integer> list) {
    	List<Integer> ans = new ArrayList<>(list.size());
    	ans.addAll(list);
    	ans.add(elem);
    	return ans;
    }
}