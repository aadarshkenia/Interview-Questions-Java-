class PartitionList{

	public static void main(String args[]){
		LinkedList ll = new LinkedList();
		int x[] = {2,1,3};
		int n = 2;
		ll.createListFromArray(x);
		ll.print();

		ListNode newHead = partition(ll.head, n);
		print(newHead);
	}


	public static ListNode partition(ListNode head, int x) {
     	if(head == null || head.next == null)
     		return head;

     	ListNode curr = head;
     	ListNode frontHead = null, frontPtr = null;
     	ListNode tailHead = null, tailPtr = null;
     	while(curr != null){

     		if(curr.val < x){
     			if(frontHead == null){
     				frontHead = curr;
     				frontPtr = curr;
     				if (tailPtr != null) {
     					tailPtr.next = curr.next;
     				}
     			}
     			else{
     				frontPtr.next = curr;
     				frontPtr = curr;
     				if(tailPtr != null)
     					tailPtr.next = curr.next;
     			}

     		}
     		else{
     			if(tailHead == null)
     				tailHead = curr;
     			//Need to update prev
     			tailPtr = curr;
     		}
     		curr = curr.next;;
     	}
     	if(frontPtr != null)
  			frontPtr.next = tailHead;
  		if(tailPtr != null)
  			tailPtr.next = null;

     	return frontHead == null ? tailHead : frontHead;   
    }

    public static void print(ListNode node){
		ListNode temp = node;
		while(temp != null){
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
	}

}