//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        Node zero=new Node(-1);
        Node one=new Node(-1);
        Node two=new Node(-1);
        Node zero1,one1,two1;
        zero1=zero;
        one1=one;
        two1=two;
        
        while(head!=null){
            if(head.data==0){
                zero.next=head;
                zero=zero.next;
            }
            else if(head.data==1){
                one.next=head;
                one=one.next;
            }
            else{
                two.next=head;
                two=two.next;
            }
            head=head.next;
            zero.next=null;
            one.next=null;
            two.next=null;
        }
        if(one1.next!=null){
            zero.next=one1.next;
            one.next=two1.next;
        }
        else
            zero.next=two1.next;
            
        return zero1.next;
        
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends