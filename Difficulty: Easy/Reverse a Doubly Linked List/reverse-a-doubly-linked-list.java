/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        Node curr=head;
        Node prev,next;
        prev=null;
        
        while(curr!=null){
            next=curr.next;
            
            curr.next=prev;
            curr.prev=next;
            
            prev=curr;
            curr=next;
        }
        return prev;
        
    }
}