import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;


class Subsets2{
	public static void main(String args[]){
		int x[] = {1, 2, 3};
		List<List<Integer>> subsets = subsetsWithDup(x);
		System.out.println(subsets);
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        //Initialize result to an empty set
        List<Integer> emptyList = new ArrayList();
        result.add(emptyList);

        //Get frequencies of numbers
        Arrays.sort(nums);
        int n = nums.length;
		if(n == 0)
    		return result;
        HashMap<Integer, Integer> freq = new HashMap();
        getFrequencies(nums, freq);
        
        int i=0;
        while(i < n){

        	int frequency = freq.get(nums[i]);
        	List<List<Integer>> newSubsetResults = new ArrayList();
			for(int j = 1; j <= frequency; j++){
    			for(List<Integer> subset : result){
        			List<Integer> newSubset = copySubset(subset);
        			for(int k = 1; k <= j; k++)
        				newSubset.add(nums[i]);
        			newSubsetResults.add(newSubset);
    			}		
    		}

			//Merge old and new results
    		result.addAll(newSubsetResults);

    		i += frequency;
        }
        return result;
    }

    public static List<Integer> copySubset(List<Integer> subset){
    	List<Integer> newSubset = new ArrayList();
    	for(int i : subset)
    		newSubset.add(i);
    	return newSubset;
    }

    public static void getFrequencies(int[] x, HashMap<Integer, Integer> f){
    	int n = x.length;    	
    	int cur = x[0], freq = 0;
    	for(int i=0; i < n; i++){
    		if(x[i] == cur)
    			freq++;
   			else{
   				f.put(cur, freq);
   				freq = 1;
   				cur = x[i];
   			}
   			if(i == n-1)
   				f.put(cur, freq);
    	}
    }
}
