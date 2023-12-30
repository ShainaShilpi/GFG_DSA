//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        
        
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        for(int r = 0; r < S.length() ; r++){
            char ch = S.charAt(r);
            while(set.contains(ch)){
                set.remove(S.charAt(left));
                left++;
            }
            set.add(ch);
            int len = r-left+1;
            max = Math.max(max,len);
        }
        return max;
        
    }
}