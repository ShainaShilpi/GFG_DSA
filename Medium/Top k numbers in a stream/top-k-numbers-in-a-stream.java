//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String St[] = br.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
           
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.kTop(arr, N, K);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        // code here
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.y==b.y?a.x-b.x:b.y-a.y);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<N;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
         pq.add(new Pair(arr[i],hm.get(arr[i])));
         int k=K;
         PriorityQueue<Pair> temp=new PriorityQueue<>((a,b)->a.y==b.y?a.x-b.x:b.y-a.y);
         ArrayList<Integer> aa=new ArrayList<>();
         Set<Integer> set=new HashSet<>();
         while(!pq.isEmpty() && k>0){
             if(!set.contains(pq.peek().x)){
                 aa.add(pq.peek().x);
                 set.add(pq.peek().x);
                 k--;
             }
             temp.add(pq.poll());
         }
         pq=temp;
         ans.add(aa);
        }
        return ans;
    }
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        
    }
}
        
