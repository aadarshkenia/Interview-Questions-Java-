import java.util.*;

class Permutations{
	public static void main(String args[]){
		int x[] = {1,1,3};
		List<List<Integer>> ans = permute(x);
		for(List<Integer> permutation : ans){
			System.out.println(permutation);
		}
	}

	//Modified code for unique permutations
	private static List<List<Integer>> permute(int [] nums){
		List<List<Integer>> ans = new ArrayList();
		if(nums.length == 1){
			List<Integer> temp = new ArrayList();
			temp.add(nums[0]);
			ans.add(temp);
		}
		else{
			HashSet<Integer> hs = new HashSet();
			for(int i=0; i < nums.length; i++){
				if(hs.contains(nums[i]))
					continue;
				hs.add(nums[i]);
				int sub[] = new int[nums.length-1];
				int counter=0;
				for(int j=0; j < nums.length; j++){
					if(i != j)
						sub[counter++] = nums[j];
				}
				List<List<Integer>> subList = permute(sub);
				for(List<Integer> subPermute : subList){
					subPermute.add(0, nums[i]);
					ans.add(subPermute);
				}
			}
		}
		return ans;
	}
}
