//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        
        long out[] = new long[n];
        Stack<Integer> dst = new Stack<>();
        dst.push(0);
        for (int i=1;i<n;i++) {
           
            while (!dst.isEmpty() && arr[dst.peek()] < arr[i]) {
                    out[dst.peek()] = arr[i];
                    dst.pop();
                    
            }
            dst.push(i);
            
        }
        while (!dst.isEmpty()) {
            out[dst.pop()] = -1;
        }
        return out;
        
    } 
}