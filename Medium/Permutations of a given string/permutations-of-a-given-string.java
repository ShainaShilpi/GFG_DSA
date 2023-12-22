//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        
        List<String>l = new ArrayList<>();
        char c[] = S.toCharArray();
        int n = S.length();
        
        permu(0, n, c, l);
        Collections.sort(l);
        
        return l;
    }
    
    void permu(int idx, int n, char c[], List<String>ans){
         
        if(idx==n){
            
            String str = new String(c);
            if(!ans.contains(str))
                ans.add(str);
            return;
        }
        
        for(int i = idx; i < n; i++){
            swap(idx, i, c);
            permu(idx + 1, n, c, ans);
            swap(idx, i, c);
        }
    }
    
    void swap(int a, int b, char c[]){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
        
    }
}