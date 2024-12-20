//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> p, List<Integer> wt, int W) {
        // code here
        int n = p.size();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=p.get(i);
            arr[i][1]=wt.get(i);
        }
        Arrays.sort(arr,(a,b)->Double.compare(b[0]/(b[1]*1.0),a[0]/(a[1]*1.0)));
        double ans=0;

        for(int it[]: arr){
            if(it[1]<W){
                ans+=it[0];
                W-=it[1];
            }
            else{
                ans+=(it[0]/(it[1]*1.0))*W;
                W=0;
                break;
            }
        }
        return ans;
    }
}