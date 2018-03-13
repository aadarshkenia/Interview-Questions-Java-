import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class CountSmallNos{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.out.println("Enter number to insert: ");
		// int x = Integer.parseInt(br.readLine());
		// List<Integer> list = new ArrayList();
		// list.add(1);
		// list.add(2);
		// list.add(3);
		// list.add(4);

		// System.out.println(getNextLargeIndex(list, x));
		int x[] = {5,4,4,2,1};
		List<Integer> out = countSmaller(x);
		for(int i : out)
			System.out.print(i+" ");
		System.out.println();
	}
	public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        if(n < 1)
        	return new ArrayList();
        int output[] = new int[n];

        List<Integer> list = new ArrayList();
        list.add(nums[n-1]);
        for(int i = n-2; i >= 0; i--){
        	int nextIndex = getNextLargeIndex(list, nums[i]);
        	output[i] = nextIndex+1;
        	list.add(nextIndex+1, nums[i]);
        }

        List<Integer> out = new ArrayList(n);
        for(int i : output)
        	out.add(i);
        return out;
    }


    //Returns index of largest integer that is smaller than x
    public static int getNextLargeIndex(List<Integer> list, int x) {
        int n = list.size();
        int lo = 0, hi = n-1;
        while(lo <= hi){
        	int mid = lo + (hi - lo)/2;
        	if(list.get(mid) >= x){
        		if(mid != 0){
        			if(list.get(mid - 1) < x)
        				return mid - 1;
        			else
        				hi = mid - 1;
        		}
        		else
        			return -1;
        	}
        	else{
        		lo = mid+1;
        	}
        }
        return n-1;
    }





}