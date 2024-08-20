//{ Driver Code Starts


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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution

{
    private static boolean isPrime2(int n){
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    
    public int[] AllPrimeFactors(int n)
    {
        
        ArrayList<Integer> arl = new ArrayList<>();
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0 && isPrime2(i)) arl.add(i);
        }
        for(int i=(int)Math.sqrt(n);i>=1;i--){
            if(n%i==0 && isPrime2(n/i)) arl.add(n/i);
        }
        
        int arr[]=new int[arl.size()];
        int k=0;
        for(int it : arl) arr[k++]=it;
        return arr;
    }
}