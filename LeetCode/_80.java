import java.util.HashMap;

class _80{
	public static void main(String args[]){
		int x[] = {1,1,1,2,2,2,2,3,4,5,6};
		int newsize = removeDuplicates(x);
		for(int i=0; i < newsize; i++)
			System.out.print(x[i]+" ");
		System.out.println();
	}
	public static int removeDuplicates(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap();
        if(nums.length < 1)
        	return 0;
        int i = 1;
        map.put(nums[0], 1);
        for(int k = 1; k < nums.length; k++){
        	if(map.containsKey(nums[k])){
        		if(map.get(nums[k]) < 2){
        			nums[i++] = nums[k];
        			map.put(nums[k], 2);
        		}
        	}
        	else{
        		nums[i++] = nums[k];
        		map.put(nums[k], 1);
        	}
        }
        return i;
    }	
}