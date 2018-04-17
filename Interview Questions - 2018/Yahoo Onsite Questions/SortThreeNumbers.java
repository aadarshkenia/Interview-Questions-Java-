class SortThreeNumbers { 

	public static void main(String args[]) {
		SortThreeNumbers sorter = new SortThreeNumbers();
		int x[] = {0,2,1,1,2,0};
		printArr(x);
		sorter.sort(x);
		printArr(x);
		System.out.println();
		int x1[] = {0,1,2,0};
		printArr(x1);
		sorter.sort(x1);
		printArr(x1);
		System.out.println();
		int x2[] = {2,2,0,0,1,1};
		printArr(x2);
		sorter.sort(x2);
		printArr(x2);
		System.out.println();
		int x3[] = {0,1,2,0,1,2};
		printArr(x3);
		sorter.sort(x3);
		printArr(x3);
		System.out.println();
	}

	public void sort(int[] x) {
		int n = x.length;
		int ptr0 = 0, ptr2 = n - 1, i = 0;
		while(i <= ptr2) {
			if(x[i] == 2) {
				swap(x, i, ptr2);
				ptr2--;
			} else if(x[i] == 1) {
				i++;
			} else {
				swap(x, i, ptr0);
				ptr0++;
				i++;
			}
		}
	}

	private static void printArr(int x[]) {
		for(int i: x) System.out.print(i + " ");
		System.out.println();
	}

	private void swap(int x[], int i, int j) {
		if(i == j) return;
		int temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}
}