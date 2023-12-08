//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int arr[], int size)
    {
        // your code here
        
         int result = -1;
        int Count = -1;
        int temp = 1;
        if(size == 1) return arr[0];
        Arrays.sort(arr);
        for(int i = 1; i< size; i++){
            if(arr[i] == arr[i-1])
            temp++;
            else temp = 1;
            if(temp > Count){
                Count = temp;
                result = arr[i];
            }
        }
        if (Count <= size/2) return -1;
        return result;
        
    }
}