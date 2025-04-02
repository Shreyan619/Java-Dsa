// 138. Copy List with Random Pointer

public class lc138 {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            //create a new node with the same data as the original one
            Node newNode = new Node(temp.val);
            map.put(temp,newNode);
            temp=temp.next;
        }
        // initialise temp to head
        temp=head;
        while(temp!=null){
            //cloning the original list
            Node copy=map.get(temp);
            //creating the connections
            copy.next=map.get(temp.next);
            copy.random=map.get(temp.random);
            temp=temp.next;
        }
        return map.get(head);
    }
}
