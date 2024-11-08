//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {

            // size of array
            int N = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int P = Integer.parseInt(br.readLine().trim());
            // calling frequncycount() function
            Solution ob = new Solution();
            ob.frequencyCount(arr, N, P);

            // printing array elements
            for (int i = 0; i < N; i++) System.out.print(arr[i] + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int n, int p) {
        for(int i=0;i<n;i++){
            if(arr[i]>n) arr[i]=0;
        }
        int n1=n+1;
        for(int i=0;i<n;i++){
            if(arr[i]==0) continue;
            int idx=arr[i]%n1;
            if(idx==0) continue;
            else arr[--idx]+=n1;
        }
        
        for(int i=0;i<n;i++){
            arr[i]=arr[i]/n1;
        }
    }
}
