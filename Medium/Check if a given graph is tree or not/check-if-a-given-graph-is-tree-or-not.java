//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // code here
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(ArrayList<Integer> i : edges) {
            graph.get(i.get(0)).add(i.get(1));
            graph.get(i.get(1)).add(i.get(0));
        }
        
        boolean visited[] = new boolean[n];
        boolean ans = solve(graph,-1,0,visited);
        for(int i=0; i<n; i++) if(!visited[i]) return false;
        
        return ans;
        
    }
    
    static boolean solve(ArrayList<ArrayList<Integer>> graph,int parent,int curr,boolean visited[]) {
        visited[curr] = true;
        
        for(int i: graph.get(curr)) {
            if(i == parent) continue;
            if(visited[i]) return false;
            if(!solve(graph,curr,i,visited))return false;
        }
        return true;
    }
    
}

