import java.util.*;
class Heap<T extends Comparable>{
	private int capacity;
	private int lastIdx = -1;
	private List<T> data;
	private Comparator<T> comparator;

	public Heap(int capacity) {
		this.capacity = capacity;
		data = new ArrayList(this.capacity); 
		this.comparator = Comparator.naturalOrder();
	}

	public Heap(int capacity, Comparator<T> comparator) {
		this(capacity);
		this.comparator = comparator;
	}

	public void printHeap() {
		for(T t : data) {
			System.out.println(t.toString());
		}
	}

	public int size() {
		return lastIdx + 1;
	}

	public void add(T t) {
		if(lastIdx < capacity - 1) {
			System.out.println("Adding elem: " + t + " at index: " + (lastIdx+1));
			data.add(++lastIdx, t);
			heapifyBottomUp(lastIdx); //TODO: Dont really need to pass lastIdx, heapify bottom up should always start from last leaf node
			System.out.println("Heap size: " + data.size());
		} else {
			throw new RuntimeException("Heap is full!");
		}
	}

	public T deleteSmallest() {
		if(lastIdx < 0) {
			throw new IllegalStateException();
		}
		T retval = data.get(0);
		data.set(0, data.get(lastIdx));
		data.remove(lastIdx);
		lastIdx--;
		heapifyTopDown(0);
		return retval;
	}

	private void heapifyTopDown(int idx) {
		int parent = idx;
		while(parent < lastIdx) {
			int lc = leftChild(parent);
			int rc = rightChild(parent);
			int smallestChild = -1;
			if(lc < lastIdx && comparator.compare(data.get(lc), data.get(parent)) < 0) {
				smallestChild = lc;
			}
			if(rc < lastIdx && comparator.compare(data.get(rc), data.get(parent)) < 0) {
				smallestChild = rc;
			}
			if(smallestChild != -1) {
				swap(smallestChild, parent);
				parent = smallestChild;
			} else {
				break;
			}
		}
	}

	private void heapifyBottomUp(int index) {
		int child = index, parent = parent(child);
		while(child > 0) {
			if(comparator.compare(data.get(child), data.get(parent)) < 0) { //If child is smaller than parent, move child upwards
				swap(child, parent);
				child = parent;
			} else {
				break;
			}
		}		
	}

	private void swap(int i , int j) {
		T temp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, temp);
	}

	private int leftChild(int parent) {return 2*parent + 1;}
	private int rightChild(int parent) {return 2*parent + 2;}
	private int parent(int child) {return (child - 1)/2;}
}