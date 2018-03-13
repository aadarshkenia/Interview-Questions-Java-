import java.util.*;
import java.io.*;

class WindowMax{
	
	static void print(int x[], int size){
		for(int i=0; i < size; i++)
			System.out.print(x[i] + " ");
		System.out.println();
	}

	public static void main(String args[]){
		int x[] = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		
		ArrayList<Integer> input = getArr("input.txt");
		ArrayList<Integer> exp = getArr("output.txt");

		int inputarr[] = new int[input.size()];
		int ctr = 0;
		for(int i : input)
			inputarr[ctr++] = i;
		int output[] = maxSlidingWindow(inputarr, 100);

		for(int i=0; i < output.length; i++){
			if(exp.get(i) != output[i])
				System.out.println("index "+i+" mismatch. Elem: " + inputarr[i] + " Exp: "+exp.get(i) +" Act: "+output[i]);
		}


		/*
		int n = x.length;
		int heapOffsets[] = new int[n];
		MyMaxHeap heap = new MyMaxHeap();
		heap.insert(0, x, heapOffsets);
		print(heapOffsets, heap.size());
		heap.insert(1, x, heapOffsets);
		print(heapOffsets, heap.size());
		heap.insert(2, x, heapOffsets);
		print(heapOffsets, heap.size());
		heap.insert(3, x, heapOffsets);
		print(heapOffsets, heap.size());
		heap.insert(4, x, heapOffsets);
		print(heapOffsets, heap.size());
		heap.insert(5, x, heapOffsets);
		print(heapOffsets, heap.size());

		//heap.print();
		heap.delete(1, x, heapOffsets);
		System.out.println("After del");
		print(heapOffsets, heap.size()+1);
		//heap.print();
		*/
		// int output[] = maxSlidingWindowAliter(x, k);
		// for(int i:output)
		// 	System.out.println(i);
	}


	public static int[] maxSlidingWindowAliter(int[] nums, int k){

		int n = nums.length;
		int output[] = new int[n-k+1];
		for(int i=k-1; i < n; i++){
			int beginIndex = i-k+1;
			output[beginIndex] = getMax(nums, beginIndex, i);
		}
		return output;
	}

	public static int getMax(int nums[], int start, int end){
		if(start > nums.length-1)
			return Integer.MIN_VALUE;
		int max = nums[start];
		for(int i=start+1; i<=end; i++)
			if(max < nums[i])
				max = nums[i];
		return max;
	}

	public static ArrayList<Integer> getArr(String filename){
		ArrayList<Integer> input = new ArrayList(66000);

		
		try{
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			String str = br.readLine();
			str = str.substring(1, str.length()-1);
			String[] tokens = str.split(",");
			for(String token : tokens){
				if(!token.equals(""))
					input.add(Integer.parseInt(token));
			}
		}	
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return input;	
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
    	MyMaxHeap heap = new MyMaxHeap();
    	int n = nums.length;
    	int output[] = new int[n-k+1];
    	int heapOffsets[] = new int[n];

    	for(int i = 0; i < n; i++){
    		if(i < k){
    			int insertIndex = heap.insert(i, nums, heapOffsets);
    			if(i == k-1)
    				output[0] = heap.root(nums);
    		}

    		else{
    			int removeIndex = i-k;
    			//Remove start of previous window from heap
    			heap.delete(heapOffsets[removeIndex], nums, heapOffsets);
				//Insert current elem into heap
    			int insertIndex = heap.insert(i, nums, heapOffsets);
    			output[i-k+1] = heap.root(nums);
    		}
    	}
    	return output;    
    }		
    
}

class MyMaxHeap{
	private int x[];
	private int size;
	final int capacity = 100000;

	public MyMaxHeap(){
		x = new int[capacity];
		size = 0;
	}

	public int size(){
		return size;
	}

	//Returns index into x
	public int insert(int elem, int nums[], int heapOffsets[]){
		if(size==capacity){
			System.out.println("Cannot insert, heap full.");
			return Integer.MIN_VALUE;
		}
		x[size] = elem;
		heapOffsets[elem] = size++; 
		return heapifyBottomUp(size-1, nums, heapOffsets);
	}

	public int root(int nums[]){
		if(size > 0)
			return nums[x[0]];
		else
			System.out.println("Empty heap! Cannot get root elem");
		return Integer.MIN_VALUE;
	}
	
	//Returns deleted elem
	public int delete(int index, int nums[], int heapOffsets[]){
		if(size == 0 || index > size-1 || index < 0){
			System.out.println("Error, cannot delete.");
			return Integer.MIN_VALUE;
		}
		else{
			int delElem = x[index];
			x[index] = x[size-1];
			heapOffsets[x[size-1]] = index;
			size--;
			heapifyTopDown(index, nums, heapOffsets);
			return delElem;
		}
	}
	
	public int heapifyTopDown(int index, int nums[], int heapOffsets[]){
		int temp = index;
		while(temp <= parent(size-1) && size!=1){
			int left_index = leftChild(temp);
			int right_index = rightChild(temp);
			int swap_index = temp;
		
			if(nums[x[left_index]] > nums[x[swap_index]] && left_index < size)
				swap_index = left_index;
			if(nums[x[right_index]] > nums[x[swap_index]] && right_index<size)
				swap_index = right_index;

			if(swap_index==temp)
				break;
			else{
				swap(swap_index, temp, heapOffsets);
				temp = swap_index;
			}
		}
		return temp;
	}

	public int heapifyBottomUp(int index, int nums[], int heapOffsets[]){
		int temp = index;
		int par = parent(temp);
		while(par>=0){
			if(nums[x[temp]] > nums[x[par]]){
				swap(temp, par, heapOffsets);
				temp = par;
				par = parent(par);
			}
			else
				break;
		}
		return temp;
	}

	public int parent(int index){
		return (index-1)/2;
	}

	public int leftChild(int par){
		return 2*par+1;
	}

	public int rightChild(int par){
		return 2*par+2;
	}

	public void swap(int index1, int index2, int heapOffsets[]){
		if(index1 == index2)
			return;
		int temp = x[index1];
		x[index1] = x[index2];
		x[index2] = temp;

		//Changing
		heapOffsets[x[index1]] = index1;
		heapOffsets[x[index2]] = index2;
	}

	public void print(){
		for(int i=0 ; i<size;i++)
			System.out.print(x[i]+" ");
		System.out.println();
	}
}

