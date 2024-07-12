//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find length of longest increasing subsequence.
    
    public static int lowerBound(ArrayList<Integer> arr, int ele) {
        int ans = arr.size();
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) >= ele) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    static int longestSubsequence(int n, int nums[]) {
        ArrayList<Integer> arl = new ArrayList<>();

         for(int i=0;i<nums.length;i++){
            if(arl.isEmpty() || arl.get(arl.size()-1)<nums[i]){
                arl.add(nums[i]);
            }
            else{
                int lowerB=lowerBound(arl,nums[i]);
                arl.set(lowerB,nums[i]);
            }
         }
         return arl.size();
    }
}