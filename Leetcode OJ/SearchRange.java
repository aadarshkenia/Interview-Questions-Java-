public class SearchRange {

   

    public static void main(String args[]){
        SearchRange searcher = new SearchRange();
        int x[] = {1,2,3,4,5,6,8,8};
        int target = 8;
        int ans[] = searcher.searchRange(x, target);
        System.out.println(ans[0]);
        System.out.println(ans[1]);

    }


    public static int[] searchRange(int[] nums, int target) {
        return searchRangeHelper(nums, 0, nums.length-1, target);
    }
    
    public static int[] searchRangeHelper(int[] nums, int low, int high, int target){
        int ans[] = new int[2];
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                ans[0] = leftIndenums(nums, low, mid, target);
                ans[1] = rightIndenums(nums, mid, high, target);
                return ans;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        ans[0] = -1;
        ans[1] = -1;
        return ans;
    }
    
    //Finds the left position of range given that target enumsists.
    public static int leftIndenums(int[] nums, int low, int high, int target){
        
        int mid = low + (high-low)/2;
        if(nums[mid] == target){
            if(mid == low)
                return low;
            else if (nums[mid-1] != target)
                return mid;
            else
                return leftIndenums(nums, low, mid-1, target);
        }
        else
            return leftIndenums(nums, mid+1, high, target);
        
    }
    
    //Finds the right position of range given that target enumsists.
    public static int rightIndenums(int[] nums, int low, int high, int target){
        int mid = low + (high-low)/2;
        if(nums[mid] == target){
            if(mid == high)
                return high;
            else if (nums[mid+1] != target)
                return mid;
            else
                return rightIndenums(nums, mid+1, high, target);
        }
        else
            return rightIndenums(nums, low, mid-1, target);          
    }
}