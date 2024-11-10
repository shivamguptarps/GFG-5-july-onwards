//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
       if(stalls.length<k) return -1;
        Arrays.sort(stalls);

        int min=1;
        int max=stalls[stalls.length-1]-stalls[0];

        while(min<=max){
            int mid=(min+(max-min)/2);
            int kcalc=1;
            int prev=0;
            for(int i=1;i<stalls.length;i++){
                if(stalls[i]-stalls[prev]>=mid){
                     kcalc++;
                     prev=i;
                }
                if(kcalc>=k) break;
            }
            if(kcalc>=k) min=mid+1;
            else max=mid-1;
        }
        return max;
    }
}