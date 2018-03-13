class DeepCopy{
	public static void main(String args[]){
		RandomListNode n1 = new RandomListNode(1);	
		RandomListNode n2 = new RandomListNode(2);	
		RandomListNode n3 = new RandomListNode(3);	
		RandomListNode n4 = new RandomListNode(4);

		n1.next = n2; n1.random = n3;
		n2.next = n3; n2.random = null;
		n3.next = n4; n3.random = n2;
		n4.next = null; n4.random = n1;
		RandomListNode newHead = copyRandomList(n1);	
		printList(newHead);
	}

	public static RandomListNode copyRandomList(RandomListNode head){
		//Creating initial copy of deep-copied list
		RandomListNode newHead = initNextPtrs(head);
		initRandomPtrs(head, newHead);
		restoreOldList(head, newHead);
		return newHead;
	}


	public static RandomListNode initNextPtrs(RandomListNode head){
		if(head == null)
			return null;
		RandomListNode deepCopyHead = new RandomListNode(head.label);
		RandomListNode oldPtr = head, newPtr = deepCopyHead;
		while(oldPtr != null){
			RandomListNode oldNext = oldPtr.next;
			oldPtr.next = newPtr;
			if(oldNext == null)
				break;
			RandomListNode newNode = new RandomListNode(oldNext.label);
			//System.out.println("Created label for : "+newNode.label);
			newPtr.next = oldNext;
			newPtr.random = oldPtr;
			
			//Updating for next iteration
			oldPtr = oldNext;
			newPtr = newNode;
		}
		return deepCopyHead;	
	}

	//Copy randomPointers for new list
	public static void initRandomPtrs(RandomListNode oldHead, RandomListNode newHead){
		RandomListNode oldPtr = oldHead, newPtr = newHead;
		while(oldPtr != null && newPtr != null){
			//System.out.println("here");
			RandomListNode oldRandom = oldPtr.random;
			if(oldRandom == null)
				newPtr.random = null;
			else{
				newPtr.random = oldRandom.next;
			}
			oldPtr = newPtr.next;
			if(newPtr.next != null)
				newPtr = oldPtr.next;
			else
				newPtr = null;
		}	
	}

	public static void restoreOldList(RandomListNode oldHead, RandomListNode newHead){
		RandomListNode oldPtr = oldHead, newPtr = newHead;
		while(oldPtr != null && newPtr != null){
			//System.out.println("Oldptr:"+oldPtr.label+" NewPtr:"+newPtr.label);
			RandomListNode oldNext = newPtr.next;
			RandomListNode newNext = oldNext == null ? null : oldNext.next;
			oldPtr.next = oldNext;
			newPtr.next = newNext;
			oldPtr = oldNext;
			newPtr = newNext;
		}	
	
	}



	//HELPER FUNCTION
	public static void printList(RandomListNode head){
		RandomListNode temp = head;
		while(temp != null){
			System.out.print("Node: "+temp.label+" ");
			if(temp.next != null)
				System.out.print("Next: "+temp.next.label+" ");
			if(temp.random != null)
				System.out.print("Random: "+temp.random.label);
			temp = temp.next;
			System.out.println();
		}
		
	}
}

class RandomListNode{
	int label;
	RandomListNode next, random;
	RandomListNode(int x){this.label = x;}
}
