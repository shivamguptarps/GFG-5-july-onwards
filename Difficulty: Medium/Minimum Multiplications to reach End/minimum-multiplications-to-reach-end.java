//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    static class Pair{
        int res;
        int dist;
        
        public Pair(int res,int dist){
            this.res=res;
            this.dist=dist;
        }
        
    }
    int minimumMultiplications(int[] arr, int st, int end) {
        int dist[]=new int[100000];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[st]=0;

        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(st,0));
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            // System.out.println(p.res);
            // if(p.res==end) return p.dist;
            for(int i=0;i<arr.length;i++){
                int temp=(p.res*arr[i])%100000;
                // if(temp==end) return p.dist+1;
                if(dist[temp]==Integer.MAX_VALUE){
                    q.add(new Pair(temp,p.dist+1));
                    dist[temp]=p.dist+1;
                }
            }
        }
        return dist[end]==Integer.MAX_VALUE ? -1 : dist[end];
    }
}