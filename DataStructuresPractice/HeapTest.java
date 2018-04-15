class HeapTest {
	
	public static void main(String args[]) {
		Heap<Integer> heap = new Heap<>(3);
		int x[] = {2,11,4,5,3};
		for(int i : x) {
			System.out.println("Adding : " + i);
			if(heap.size() == 3) {
				heap.deleteSmallest();
			}
			heap.add(i);
			heap.printHeap();		
			System.out.println();
		}
	}
}