import java.util.*;
class _632 {

	public static void main(String args[]) {
		_632 instance = new _632();
		Integer a1[] = {4,10,15,24,26}; //[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]] 
		Integer a2[] = {0,9,12,20};
		Integer a3[] = {5,18,22, 30};
		List<List<Integer>> input = new ArrayList<>();
		input.add(Arrays.asList(a1));
		input.add(Arrays.asList(a2));
		input.add(Arrays.asList(a3));
		int ans[] = instance.smallestRange(input);
		System.out.println(String.format("Window: [%d, %d]", ans[0], ans[1]));
	}


	public int[] smallestRange(List<List<Integer>> nums) {
		int k = nums.size();
    	int maxElem = Integer.MIN_VALUE;
    	int ans[] = new int[2];
    	int largest = Integer.MIN_VALUE;
    	PriorityQueue<ListElemPointer> pq = new PriorityQueue<>(k, (elem1, elem2) -> {
    		return Integer.compare(getElem(nums, elem1), getElem(nums, elem2));
    	});  
    	for(int i = 0; i < k; i++) {
    		List<Integer> list = nums.get(i);
    		if(list.size() > 0){
    			ListElemPointer listElemPointer = new ListElemPointer(i, 0);
    			if(getElem(nums, listElemPointer) > maxElem) {
    				maxElem = getElem(nums, listElemPointer);
    			}
    			pq.add(listElemPointer);    			
    			//update largest
    			if(list.size() > 0 && list.get(list.size() - 1) > largest){
	    			largest = list.get(list.size() - 1);
    			}
    		} 
    	}
    	if(pq.size() == 0) return ans;
    	else if(pq.size() < k){
    		ans[0] = getElem(nums, pq.peek());
    		ans[1] = largest; 
    	}
    	ans[0] = getElem(nums, pq.peek());
    	ans[1] = maxElem;

    	while(true) {
    		ListElemPointer root = pq.poll();
    		ListElemPointer newptr = new ListElemPointer(root.listPtr, root.elemPtr + 1);
    		if(newptr.elemPtr >= nums.get(newptr.listPtr).size()) break;
    		else {
    			pq.add(newptr);    			 
    			if(getElem(nums, newptr) > maxElem) {
    				maxElem = getElem(nums, newptr);
    			}
			}
			//Update window size.
			if(Math.abs(getElem(nums, pq.peek()) - maxElem) < Math.abs(ans[0] - ans[1])) {
				ans[0] = getElem(nums, pq.peek());
				ans[1] = maxElem;
			}
    	}
    	return ans;

    }

    private int getElem(List<List<Integer>> nums, ListElemPointer ptr) {
    	return nums.get(ptr.listPtr).get(ptr.elemPtr);
    }
}

class ListElemPointer {
	
	int listPtr;
	int elemPtr;
	ListElemPointer(int listPtr_, int elemPtr_) {
		listPtr = listPtr_;
		elemPtr = elemPtr_;
	}

}