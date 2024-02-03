//{ Driver Code Starts
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}

class LinkedList1
{
    Node head;  // head of lisl
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node)
    {
        if (head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        String s = sc.nextLine();
        while(t>0)
        {
            int n = sc.nextInt();
            String s1 = sc.nextLine();
            LinkedList1 llist = new LinkedList1();

            if (n > 0)
            {
                int a1=sc.nextInt();
                Node head= new Node(a1);
                llist.addToTheLast(head);
            }
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
            System.out.println(new Solution().DecimalValue(llist.head));
            t--;
        }
    }
}


// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}
This is method only submission.  You only need to complete the method. */

class Solution
{
    long modulo = 1000000007;
    
    long len(Node head)
    {
        Node curr = head;
        long length=0;
        while(curr!=null)
        {
            curr = curr.next;
            length++;
        }
        return length;
    } 
    
    long[] calculatePowersOfTwo(long length) {
        long[] powersOfTwo = new long[(int) length];
        powersOfTwo[0] = 1;

        for (int i = 1; i < length; i++) {
            powersOfTwo[i] = (powersOfTwo[i - 1] * 2) % modulo;
        }

        return powersOfTwo;
    }
    
    long DecimalValue(Node head)
    {
       
       long n = len(head);
        long sum = 0;
        Node curr = head;

        long[] powersOfTwo = calculatePowersOfTwo(n);

        while (curr != null) {
            long mul = powersOfTwo[(int) (n - 1)] % modulo;
            mul = (mul * curr.data) % modulo;
            sum = (sum + mul) % modulo;
            n--;
            curr = curr.next;
        }

        return sum;
       
   }
}