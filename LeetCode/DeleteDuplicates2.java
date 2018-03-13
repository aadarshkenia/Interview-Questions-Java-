class DeleteDuplicates2{
	public static ListNode deleteDuplicates(ListNode head) throws Exception{
	  	if(head == null)
			return null;
		ListNode curr = head, prev = null;
		ListNode newHead = head;
		while(curr != null && curr.next != null){
			ListNode succ = curr.next;
			if(succ != null){
				if(curr.val == succ.val){
					ListNode newNode = succ;
					while(newNode != null && newNode.val == curr.val){
						newNode = newNode.next;
					}

					if(prev == null)
						newHead = newNode;
					else{
						prev.next = newNode;
						//prev = curr;
					}
					curr = newNode;
				}
				else{
					prev = curr;
					curr = curr.next;
				}
			}

		}
		return newHead;
	}//deleteDuplicates()

	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		try{
			printList(deleteDuplicates(n1));
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void printList(ListNode head){
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}

	}
}

