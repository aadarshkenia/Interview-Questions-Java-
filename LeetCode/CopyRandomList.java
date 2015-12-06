class RandomListNode{
	int label;
	RandomListNode next, random;
	RandomListNode(int x){
		this.label = x;
	}
}

class CopyRandomList{
	public RandomListNode copyRandomList(RandomListNode head){
		if(head==null)
			return null;
		RandomListNode newHead = copyList(head);
	
	}

	//Creates a new copy list with correct next pointers.
	public RandomListNode copyList(RandomListNode head){
		RandomListNode oldPtr = head;
		RandomListNode newPtr = null;
		RandomListNode newHead = null;
		while(oldPtr != null){
			RandomListNode newNode = new RandomListNode(oldPtr.label);
			if(newPtr == null){
				newPtr = newNode;
				newHead = newNode;
			}
			else{
				newPtr.next = newNode;
				newPtr = newNode;
			}
			RandomListNode oldNext = oldPtr.next;
			oldPtr.next = newNode;
			newNode.random = oldPtr;
			oldPtr = oldNext;
		}
		return newHead;
	}
}
