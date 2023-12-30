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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        
        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<S.length();i++)
        {
            for(int j=i;j<S.length();j++)
            {
                if(set.add(S.charAt(j))==false)
                {
                    if(set.size()>max)
                    max=set.size();
                    set.clear();
                    break;
                }
            }
        }
        return max;
        
    }
}