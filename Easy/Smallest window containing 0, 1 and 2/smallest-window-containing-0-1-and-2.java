//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        
        char[] ch = S.toCharArray();
        int index0=0, index1=0, index2=0;
        boolean flag0=false, flag1=false, flag2=false;
        int windowSize = Integer.MAX_VALUE;
        
        for(int i=0; i<ch.length; i++){
            if(ch[i] == '0'){
                flag0 = true;
                index0 = i;
                
            }else if(ch[i] == '1'){
                flag1 = true;
                index1 = i;
                
            }else if(ch[i] == '2'){
                flag2 = true;
                index2 = i;
            }
            
            if(flag0 && flag1 && flag2){
                int mini=0, maxi=0, temp=0;
                
                temp = Math.min(index0, index1);
                mini = Math.min(index2, temp);
                
                if(mini == index0)
                    flag0 = false;
                else if(mini == index1)
                    flag1 = false;
                else
                    flag2 = false;
                
                temp = Math.max(index0, index1);
                maxi = Math.max(index2, temp);
                
                windowSize = Math.min(windowSize,maxi-mini +1);
            }   
        }
        return windowSize==Integer.MAX_VALUE?-1:windowSize;
        
    }
};
