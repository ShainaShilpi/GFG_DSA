//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        
         HashMap<String , Integer> fmap = new HashMap<>();
        for(String name : arr){
            fmap.put(name , fmap.getOrDefault(name, 0) + 1);
        }
        int max = 0;
        String winner = null;
        for(Map.Entry<String, Integer> entry : fmap.entrySet()){
            if(entry.getValue() > max || (entry.getValue() == max && entry.getKey().compareTo(winner)<0)){
                max = entry.getValue();
                winner = entry.getKey();
            }
        }
        return new String[]{winner, String.valueOf(max)};
        
    }
}

