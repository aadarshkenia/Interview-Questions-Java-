import org.junit.*;

class _25Test {
	_25 instance = new _25();

	@Test
	public void testReverse() {
		int x[]= {1,2,3,4,5};
		int k = 2;
		ListNode head = getListFromArray(x);
		printList(head);
		ListNode newHead = instance.reverseKGroup(head, k);
		printList(newHead);
	}


	private ListNode getListFromArray(int[] x) {
		ListNode prev = null, start = null;
		for(int i=0; i < x.length; i++) {
			ListNode node = new ListNode(x[i]);
			if(prev == null) {
				prev = node;
				start = node;
			} else {
				prev.next = node;
			}
		}
		return start;
	}

	private void printList(ListNode node) {
		ListNode start = node;
    	while(start != null) {
    		System.out.println(start.val + " ");
    		start = start.next;
    	}
	}

}