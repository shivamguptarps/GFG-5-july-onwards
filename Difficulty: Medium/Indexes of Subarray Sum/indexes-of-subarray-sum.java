//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        StringBuilder sb = new StringBuilder();
        for (int e : a) sb.append(e + " ");
        System.out.println(sb);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(arr, n, s);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends




class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
     static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> arl = new ArrayList<>();
        int sum=0;
        int j=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            
            while(sum>s && j<i){
                sum-=arr[j];
                j++;
            }
            
            if(sum==s){
                arl.add(j+1);
                arl.add(i+1);
                return arl;
            }
        }
        
        
            arl.add(-1);
        
        return arl;
    }
}