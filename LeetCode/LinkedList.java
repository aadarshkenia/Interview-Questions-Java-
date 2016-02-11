class LinkedList{
	
	ListNode head = null;

	public void print(){
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public int getCount(ListNode head){
		int count=0;
		while(head!=null){
			count++;
			head = head.next;
		}
		return count;
	}


	public void createListFromArray(int x[]){
		ListNode prev = null;
		for(int i=0;i<x.length;i++){
			if(i==0){
				head= new ListNode(x[i]);
				prev = head;
			}
			else{
				ListNode curr = new ListNode(x[i]);
				prev.next = curr;
				prev=curr;
			}
		}
	}
}


class ListNode{
	int val;
	ListNode next;

	ListNode(int val){
		this.val = val;
	}
}