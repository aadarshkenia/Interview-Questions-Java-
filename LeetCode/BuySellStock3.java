class BuySellStock3{
	

	public static void main(String args[]){
		//int x[] = {4,6,2,1,15,14,19,10,22,1};
		//int z[] = {8,3,6,2,8,8,8,4,2,0,7,2,9,4,9};
		//int z[] = {6,5,4,8,6,8,7,8,9};
		int z[] = {1,7,4,2,11};
		int z1[] = {100,0,1,2,8,6,8,7,8,8,9,10};
		//int z[] = {2,8,0,7,2,9};
		//System.out.println(maxProfit(x));
		System.out.println(maxProfit(z1));
	}

	private static int maxProfit(int[] x){
		int n = x.length;
		int gm = 0, lm = 0, profit = 0;
		int t1[] = new int[n];
		for(int i=1; i < n; i++){
			t1[i] = Math.max(x[i] - x[gm], t1[i-1]);
			if(x[i] < x[gm]){
				gm = i;
				lm = i;
				//System.out.println("lm changed : "+lm);
			}
			else{
				if(x[i] < x[i-1]){
					if(lm == gm || (t1[i-1] > t1[lm-1] - (x[lm] - x[i]))){
						lm = i;
						//System.out.println("lm changed : "+lm);
					}
				}
				else{
					int cp = x[i] - x[lm];
					if(lm > 0)
						cp += t1[lm-1];
					//Update overall profit
					if(cp > profit){
						profit = cp;
					}
					cp = x[i] - x[gm];
					if(gm > 0)
						cp += t1[gm-1];
					if(cp > profit){
						profit = cp;
					}
				}
			}
		}
		return profit;
	}//maxProfit()


}
