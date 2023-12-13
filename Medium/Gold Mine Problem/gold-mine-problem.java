//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        
         for(int i = 1; i < M[0].length; i++){
            for(int j = 0; j < M.length; j++){
                int max = M[j][i-1];
                
                if(j > 0 && M[j - 1][i - 1] > max){
                    max = M[j - 1][i - 1];
                }
                if(j < M.length - 1 && M[j + 1][i - 1] > max){
                    max = M[j + 1][i - 1];
                }
                M[j][i] += max;
            }
        }
        
        int ans = 0;
        int lc = M[0].length - 1;
        for(int i = 0; i < M.length; i++){
            if(M[i][lc] > ans){
                ans = M[i][lc];
            }
        }
        
        return ans;
        
    }
}