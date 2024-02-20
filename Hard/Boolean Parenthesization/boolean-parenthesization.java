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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countWays(int N, String S){
        // code here
        
        return count(S.toCharArray(), 0, N-1, 1, new HashMap<>());
    }
    
    private static int count(char[] s, int i, int j, int isTrue, Map<String, Integer> map) {
        if (i > j) return 0;
        
        if (i == j)
            return isTrue == 1 ? (s[i] == 'T' ? 1 : 0) : (s[i] == 'F' ? 1 : 0);
        
        String key = i + "-" + j + "-" + isTrue;
        
        int res = map.getOrDefault(key, -1);
        if (res != -1) return res;
        
        long ways = 0;
        
        for (int k = i + 1; k < j; k += 2) {
            int lT = count(s, i, k - 1, 1, map);
            int lF = count(s, i, k - 1, 0, map);
            int rT = count(s, k + 1, j, 1, map);
            int rF = count(s, k + 1, j, 0, map);
            
            if (s[k] == '&')
                ways += isTrue == 1 ? (lT * rT) : (lT * rF + lF * rT + lF * rF);
            
            if (s[k] == '|')
                ways += isTrue == 1? (lT * rT + lT * rF + lF * rT) : (lF * rF);
            
            if (s[k] == '^')
                ways += isTrue == 1? (lT * rF + lF * rT) : (lT * rT + lF * rF);
            
            ways %= 1003;
        }
        int ans = (int) ways;
        
        map.put(key, ans);
        return ans;
        
    }
}