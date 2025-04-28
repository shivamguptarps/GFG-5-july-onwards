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
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if(arr.length<k) return -1;
        int min=Integer.MIN_VALUE;
        int max=0;
        for(int it : arr){
            max+=it;
            min=Math.max(min,it);
        }
        int ans=-1;
        while(min<=max){
            int mid=min+(max-min)/2;
            // System.out.println(mid);
            int cs=0,stu=0;
            for(int i=0;i<arr.length;i++){
                cs+=arr[i];
                if(cs==mid){
                    stu++;cs=0;
                }
                else if(cs>mid){
                    stu++;
                    cs=arr[i];
                }
            }
            if(cs>0) stu++;
            // System.out.println(mid+" "+stu);
            if(stu<=k){
                ans=mid;max=mid-1;
            }
            if(stu>k){
                min=mid+1;
            }
            else{
                max=mid-1;
            }
        }
        return ans;
        
    }
}