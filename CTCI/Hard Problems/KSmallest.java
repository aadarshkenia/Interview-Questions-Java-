import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class KSmallest {
	
	public static void main(String args[]) throws IOException {
		int x[] = {1, 2, 1, 5, 1, -10};
		System.out.println(new KSmallest().qsortModified(x, Integer.parseInt(args[0])));
	}

	//Returns k largest elems in array
	public List<Integer> qsortModified(int x[], int k) {		
		qsortModifiedUtil(x, 0, x.length-1, k);
		return getList(x, 0, k-1);
	}

	public void qsortModifiedUtil(int x[], int start, int end, int k) {
		System.out.println("Function call: ");
		print(x, start, end);
		if(end - start == k - 1) 
			return;
		int pivot = start;
		int lo = start + 1, hi = end;
		while(lo <= hi) {
			while(lo <= hi && x[lo] <= x[pivot]) {
				lo++;
			}

			while(lo <= hi && x[hi] > x[pivot]) {
				hi--;
			}

			if(lo < hi) {
				swap(x, lo, hi);
			}
		}
		//Swap pivot with lo - 1;
		swap(x, pivot, lo - 1);

		if(lo == k) {
			return;
		} else if(lo < k){
			qsortModifiedUtil(x, lo, end, k);
		} else {
			qsortModifiedUtil(x, start, lo - 1, k);
		}
	}	

	private List<Integer> getList(int x[], int start, int end) {
		List<Integer> list = new ArrayList<>();
		for(int i=start; i <= end; i++) {
			list.add(x[i]);
		}
		return list;
	}

	public void qsort(int x[], int start, int end) {
		if(start >= end) return;
		int pivot = start;
		int lo = start + 1, hi = end;
		while(lo <= hi) {
			while(lo <= hi && x[lo] <= x[pivot]) {
				lo++;
			}

			while(lo <= hi && x[hi] > x[pivot]) {
				hi--;
			}

			if(lo < hi) {
				swap(x, lo, hi);
			}
		}
		//Swap pivot with lo - 1;
		swap(x, pivot, lo - 1);
		qsort(x, start, lo - 2);
		qsort(x, lo, end);
	}

	private void print(int x[], int start, int end) {
		for(int i=start; i<= end;i++) {
			System.out.print(x[i]+ " ");
		}
		System.out.println();
	}

	private void swap(int x[], int idx1, int idx2) {
		int temp = x[idx1];
		x[idx1] = x[idx2];
		x[idx2] = temp;
	}
}