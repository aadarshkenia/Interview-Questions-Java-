import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
class LRUCache {
	private Map<Integer, int[]> map = null;
	private LinkedList<int[]>  dll = null;
	private int capacity;
	/*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
       map = new HashMap<>();
       dll = new LinkedList<>();
       capacity = N;
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {
       	if(map.containsKey(x)) {
       		int[] dllVal = map.get(x);
       		dll.remove(dllVal);
       		dll.addFirst(dllVal);
       		return dllVal[1];
       	}
       	return -1;
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {		
		if(map.containsKey(x)) {
			int n[] = map.get(x);
			n[1] = y; //reset value
			dll.remove(n);
       		dll.addFirst(n);
		} else {
			int[] node = new int[2];
   			node[0] = x;
   			node[1] = y;	
			if(map.size() == capacity) {   			
				int[] removed = dll.removeLast();
				System.out.println("Removing key: "+ removed[0]);
				map.remove(removed[0]);
			} 
	       	map.put(x, node);
	   		dll.addFirst(node);
		}
		
    }


    public static void main(String args[]) {
    	LRUCache cache = new LRUCache(2);
    	cache.set(1, 1);
    	cache.set(2, 2);
    	cache.get(1);
    	cache.set(3, 3);

    }
}