//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int power(int pow,int m,int num){
        long n=1;
        for(int i=1;i<=pow;i++){
            n=n*m;
            if(n>num) return 0;
        }
        if(n==num) return 1;
        return 2;
    }
    
    public int NthRoot(int pow, int num)
    {
        int low=1;
        int high=num;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            int f=power(pow,mid,num);

            if(f==1)return mid;
            else if(f==0) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
}