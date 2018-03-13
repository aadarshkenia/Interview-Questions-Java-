
class JumpGame{
	public static void main(String args[]){
		int x[] = {3,2,1,0,4};
		System.out.println(canJump(x));
	
	}

	public static boolean canJump(int[] nums){
		int n = nums.length;
		int rangeStart = 0, rangeEnd = 0;
		while(true){
			//System.out.println("rs"+rangeStart);
			//System.out.println("re"+rangeEnd);
			if(n-1 <= rangeEnd)
				return true;
			if(rangeStart == rangeEnd && nums[rangeStart] == 0)
				return false;

			
			int newEnd = rangeEnd;
			for(int i = rangeStart; i<= rangeEnd; i++){
				if(i + nums[i] > newEnd)
					newEnd = i + nums[i];	
			}
			if(newEnd == rangeEnd)
				return false;
			rangeStart = rangeEnd+1;
			rangeEnd = newEnd;
		}		
	}

}
