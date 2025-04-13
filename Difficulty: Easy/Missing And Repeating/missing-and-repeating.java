//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int nums[]) {
        int n= nums.length;
        for(int i=0;i<n;i++){
            int idx=nums[i]%n;
            nums[idx]+=n;
        }
        int ans[]=new int[2];
        for(int i=0;i<n;i++){
            if ((float)nums[i] / n > 2) ans[0] = i;
            if ((float)nums[i] / n <=1) ans[1] = i; 
        }
        ans[0]=ans[0]==0?n:ans[0];
        ans[1]=ans[1]==0?n:ans[1];
        ArrayList<Integer> ans1 = new ArrayList<>();
        for (int num : ans) {
            ans1.add(num);
        }
        return ans1;
    }
}
