class _25 {
	public ListNode reverseKGroup(ListNode head, int k) {
        int n = getNumNodes(head);
        ListNode curr = head, prevTail = null;
        ListNode newHead = null;
        int iterations = 1 , lastIteration = n%k == 0 ? n / k : n/k + 1;
        while(curr != null) {
        	ListNode prev = null;
        	if(iterations == lastIteration && n%k != 0) {
        		if(prevTail != null)
        			prevTail.next = curr;
        		break;
        	} else {
        		ListNode currentHead = curr;
	        	for(int i = 0 ; i < k; i++) {
	        		ListNode nx = curr.next;
	        		curr.next = prev;
	    			prev = curr;
	    			curr = nx;
	        	}
	        	if(prevTail != null) {
	        		prevTail.next = prev;
	        	}
	        	prevTail = currentHead;
	        	if(newHead == null) {
	        		newHead = prev;	
	        	}
	        	iterations++;	
        	}        	
        }

        return newHead != null ? newHead : head;
    }

    private int getNumNodes(ListNode head) {
    	int i = 0;
    	ListNode start = head;
    	while(start != null) {
    		i++;
    		start = start.next;
    	}
    	return i;
    }

}

