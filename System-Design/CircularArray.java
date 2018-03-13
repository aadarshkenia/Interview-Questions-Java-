public class CircularArray<T> implements Iterable<T> {
	private T[] arr;
	private int startOffset = 0;

	@SuppressWarnings("unchecked")
	public CircularArray(int size) {
		arr = (T[]) new Object[size];
	}

	@Override
	public Iterator<T> iterator() {
		
	}

	public T get(int index) {
		int len = arr.length;
		return arr[(startOffset + index) % len];
	}

	public void set(T t, int index) {
		if(index >= arr.length) {
			throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
		}
		arr[(startOffset + index) % len] = t;
	}

	//rotate left
	public void rotateLeft(int offset) {
		startOffset = offset % arr.length;
	}

	//Rotate right
	public void rotateRight(int offset) {
		rotateLeft(arr.length - offset);
	}

	public void length() {
		return arr.length;
	}

}

class MyIterator<T> implements Iterator<T> {
	private T[] arr;
	private int offset;
	private int current; //current index

	MyIterator(T[] arr, int offset) {
		this.arr = arr;
		this.offset = offset;
		this.current = offset;
	}

	@Override
	public T next() {
		if(hasNext()) {
			T elem = arr[current++];
			if(current == arr.length){
				current = 0;
			}
			return elem;
		}
		throw new NoSuchElementException("No elem.");
	}

	@Override
	public boolean hasNext() {
		return current != offset - 1;
	}

	@Override
	public void remove() {
		if(arr[current] == null) {
			throw new IllegalStateException("Remove already called.");
		}
		arr[current] = null;
		
	}


}