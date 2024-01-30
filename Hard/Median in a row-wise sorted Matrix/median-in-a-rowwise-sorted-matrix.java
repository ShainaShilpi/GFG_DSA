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
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int mat[][], int R, int C) {
        // code here   
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int req = (R * C) / 2;

        for (int i = 0; i < R; i++) {
            low = Math.min(mat[i][0], low);
            high = Math.max(mat[i][C - 1], high);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = countSmallerEq(mat, R, C, mid);

            if (cnt <= req)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
        
    }
    
    private int upperBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int mid, ans = n;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int countSmallerEq(int[][] arr, int n, int m, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int val = upperBound(arr[i], m, x);
            cnt += val;
        }
        return cnt;
    }
    
}