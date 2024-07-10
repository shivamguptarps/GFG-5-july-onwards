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

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        final int mod=1000000007;
        int sum=0;
        for(int t : arr) sum+=t;
        
        // if(sum==d) return 1;  Will give wrong answer as there is zero in array elements
        int target=(sum+d);
        if(target%2!=0) return 0;
        target=target/2;
        
        sum=target;
        
        int prev[]=new int[sum+1];
        prev[0]=1;
        
        
        for(int i=1;i<n+1;i++){
            for(int j=sum;j>=0;j--){
                if(arr[i-1]<=j){
                    prev[j]= (prev[j-arr[i-1]]%mod + prev[j]%mod)%mod;
                }
                else{
                    prev[j]=prev[j]%mod;
                }
            }
        }
        return prev[sum];
    }
}
        
