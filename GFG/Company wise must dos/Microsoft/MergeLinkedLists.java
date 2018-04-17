class MergeLinkedLists {

    public static void main(String args[]) {
        MergeLinkedLists ll = new MergeLinkedLists();
        int x1[] = {5,10,15,40};
        int x2[] = {2,3,20};
        Node head1 = ll.createLLFromArray(x1);
        Node head2 = ll.createLLFromArray(x2);
        ll.print(ll.mergeResult(head1, head2));
    }


    Node mergeResult(Node node1, Node node2) {
        if(node1 == null && node2 == null) return null;
        Node[] ans = mergeResultUtil(node1, node2);
        return ans[0];
    }
    
    Node[] mergeResultUtil(Node node1, Node node2)
    {
        // Your code here   
        if(node1 == null) {
            return reverse(node2);   
        }
        else if(node2 == null) {
            return reverse(node1);   
        }
        else {
            if(node1.data < node2.data) {
                Node[] merged = mergeResultUtil(node1.next, node2);
                print(merged[0]);
                System.out.println();
                merged[1].next = node1;
                node1.next = null;
                merged[1] = node1;
                return merged;
            } else {
                Node[] merged = mergeResultUtil(node1, node2.next);
                print(merged[0]);
                System.out.println();
                merged[1].next = node2;
                node2.next = null;
                merged[1] = node2;
                return merged;
            }
        }
        
    }
    
    Node[] reverse(Node n) {
        Node prev = null, curr = n;
        while(curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        Node[] ans = new Node[2];
        ans[0] = prev;
        ans[1] = n;
        return ans;
    }

    private void print(Node n) {
        while(n != null) {
            System.out.print(n.data+ " ");
            n = n.next;      
        }
      
    }

    private Node createLLFromArray(int[] x) {
        Node prev = null, ans = null;
        for(int i : x) {
            Node n = new Node(i);
            if(ans == null){
                ans = n;  
                prev = n;
            } 
            else {
                prev.next = n; 
                prev = n;
            }
        }
        return ans;
    }
}

class Node{
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
} 