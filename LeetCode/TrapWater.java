class TrapWater{
	public static void main(String args[]){
		int x[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		int ans = trap(x);
		System.out.println(ans);
	}

	public static int trap(int height[]){
		int n = height.length;
		int maxTillNow = 0;
		int waterStored=0;
		int rmax[] = rightMaxBars(height);
		for(int i=0; i<n; i++){
			if(i==0){
				maxTillNow=  height[i];
			}
			else{
				if(height[i] < maxTillNow && height[i] < rmax[i]){
					waterStored += Math.min(maxTillNow, rmax[i]) - height[i];
				} 
				if(height[i] > maxTillNow)
					maxTillNow = height[i];
			}
		}
		return waterStored;
	}

	//Helper function to find max heights on right side of bars
	public static int[] rightMaxBars(int height[]){
		int n = height.length;
		int rmax[] = new int[n];
		int maxTillNow = 0;
		for(int i=n-1; i>=0; i--){
			if(i==n-1){
				rmax[i] = 0;
				maxTillNow = height[i];
			}
			else{
				rmax[i] = maxTillNow;
				maxTillNow = maxTillNow < height[i] ? height[i] : maxTillNow;
			}
		}
		return rmax;
	}
}
