//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        
        HashMap<Character,Integer> map=new HashMap<>();
      for(int i=0;i<s.length();i++){
          char ch=s.charAt(i);
          map.put(ch,map.getOrDefault(ch,0)+1);
          
      }
      PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
      for(Map.Entry<Character,Integer> e: map.entrySet()){
          pq.add(e.getValue());
      }
      
      while(!pq.isEmpty()){
          if(k==0){
              break;
          }
          int val=pq.remove();
          val--;
          k--;
         
          pq.add(val);
      }
      int sum=0;
      while(!pq.isEmpty()){
          int r=pq.remove();
         
          sum+=r*r;
      }
     
      return sum;
        
    }
}