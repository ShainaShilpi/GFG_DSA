//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        // code here
        
        char[] str= S.toCharArray();
        StringBuilder  sb = new StringBuilder();
        for(int i=str.length-1; i>=0; i--){
            sb.append(str[i]);
        }
      
        if(sb.toString().equals(S)){
            return 1;
        }
        else{
            return 0;
        }
    }
};