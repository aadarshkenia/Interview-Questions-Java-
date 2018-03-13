import java.util.Arrays;
import java.util.List;
class SortColors{
	public static void main(String args[]){
		int x[] = {2};
		//int x[] = {0,0,1,2,0,2,1,1,0,1,1,0,1,0,2,2,0,0,2,2,2,1,0,2,1,1,1,2,0,0,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,2,0,1,1,2,1,1,2,2,0,1,1,1,0,0,2,1,2,0,2,0,1,2,2,2,0,2,0,2,1,2,1,2,0,0,1,1,2,0,1,2,0,0,1};
		sortColors(x);
		for(int i: x)
			System.out.print(i);
		System.out.println();
	}

	private static void sortColors(int[] nums){
		int n = nums.length;
		int i=0, k=n-1, j=i;
		while(j <= k){
			//System.out.println("i: "+i+" j: "+j+" k: "+k);
			switch(nums[j]){
				case 0:
					swap(nums, i++, j++);
					break;
				case 1:
					j++;
					break;
				case 2:
					swap(nums, j, k--);
					break;
				default:	
					break;
			}

		}
	
	}

	private static void swap(int[] x, int a, int b){
		if(a==b)
			return;
		x[a] = x[a] + x[b];
		x[b] = x[a] - x[b];
		x[a] = x[a] - x[b];
	}

}
