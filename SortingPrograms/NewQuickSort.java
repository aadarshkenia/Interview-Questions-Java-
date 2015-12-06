class NewQuickSort{
	public static void main(String args[]){
		//	int x[] = {4,1,8,6,10};
		int x[] = {10,9,8,7,6,5,4};
		int n = x.length;
		sort(x,0,n-1);
		for(int i: x)
			System.out.println(i+" ");
		System.out.println();
	}

	public static void sort(int x[], int start, int end){
		int len = end-start+1;
		if(start==end)
			return;

		int pivot = x[start];
		int i=start+1, j=end;
		while(i <= j){

			//Find first elem in left half greater than pivot
			while(i<=j && x[i] <= pivot )
				i++;

			//Find first elem in right half smaller than pivot
			while(j>=i && x[j] > pivot)
				j--;
			
			//swap i and j
			if(i <= j){
				swap(x, i, j);
				i++;
				j--;
			}
	
		}
		//Put pivot in its correct place
		swap(x, j, start);
		System.out.println("st:"+start+" end:"+end+ " i:"+i+" j:"+j);
		
		//Recursively sort left and right sub arrays
		if(j != start){
			sort(x, start, j-1);}
		if(j != end){
			sort(x, j+1, end);
			
		}
	}
	
	public static void swap(int x[], int i, int j){

		int temp = x[i];
		x[i] = x[j];
		x[j] = temp;
		
	}
}
