//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    
    PriorityQueue<Integer> right = new PriorityQueue<>();
    PriorityQueue<Integer> left = new PriorityQueue<>( Comparator.reverseOrder()  );
    
    //Function to insert heap.
    public void insertHeap(int x)
    {
        // add your code here
        
        if( left.isEmpty() || x < left.element() ){
            
            left.add( x);
            
        }else{
            
            right.add(x);
        }
    
        
        balanceHeaps();
        
    }
    
    //Function to balance heaps.
    public void balanceHeaps()
    {
       // add your code here
       
        int diff = left.size() - right.size();
       
        switch(diff){
          
        
        case -1: left.add(right.poll());
                break;
                 
        case 2: right.add( left.poll());
                break;
                 
                 
        default: break;
           
       }
       
    }
    
    //Function to return Median.
    public double getMedian()
    {
        // add your code here
        
        int totalSize = left.size() +  right.size();
        
 
        if (totalSize % 2 != 0) {
    
            return left.peek();
            
        } else {
            
             return (left.peek() + right.peek()) / 2.0;
        }
        
    }
    
}