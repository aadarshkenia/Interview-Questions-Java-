import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class FourSum{
	
	public static void main(String args[]){
		FourSum obj = new FourSum();
		//int nums[] = {2,1,0,0,-1,-2};
		int nums[] = {1,1,1,1,1,1};
		int target = 4;
		List<List<Integer>> ans = obj.fourSum(nums, target);
		for(List<Integer> fourList : ans){
			for(int elem : fourList)
				System.out.print(elem+" ");
			System.out.println();
		}

	}


	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        int n = nums.length;
     	if(n < 4)
            return returnList;
        for(int i=0; i < n-3 ; i++){
        	if(i!=0 && nums[i] == nums[i-1])
        		continue;	
        	for(int j = i+1; j<n-2; j++){
        		if(j!=(i+1) && nums[j] == nums[j-1])
        			continue;
        		int diff = target - nums[i] - nums[j];
        		List<List<Integer>> twoList = twoSum(nums, j+1, n-1, diff);
        		if(twoList!=null){
        			for(List<Integer> eachtwoList : twoList){
        				List<Integer> fourList = new ArrayList<Integer>();
        				fourList.add(nums[i]);
        				fourList.add(nums[j]);
        				fourList.add(eachtwoList.get(0));
        				fourList.add(eachtwoList.get(1));
        				returnList.add(fourList);
        			}
        		}
        	}//inner for
        }//outer for
        return returnList;
    }//fourSum()
    

    public List<List<Integer>> twoSum(int[] nums, int start, int end, int sum){
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	int i = start, j=end;
    	while(i<j){
    		if(i!=start && nums[i]==nums[i-1]){
    			i++;
    			continue;
    		}
    		if(j!=end && nums[j]==nums[j+1]){
    			j--;
    			continue;
    		}
    		if(nums[i] + nums[j] == sum){
    			ArrayList<Integer> twoList = new ArrayList<Integer>();
    			twoList.add(nums[i]);
    			twoList.add(nums[j]);
    			ans.add(twoList);
    			i++;
    			j--;
    		}
    		else if(nums[i] + nums[j] > sum)
    			j--;
    		else
    			i++;
    	}	
    	if(ans.size() > 0)
    		return ans;
    	return null;
    }



}