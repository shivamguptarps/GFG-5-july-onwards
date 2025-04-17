//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        int nums[]=new int[arr.size()];
        for(int i=0;i<nums.length;i++){
            nums[i]=arr.get(i);
        }
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid-1>=0 && nums[mid]<nums[mid-1]) return mid;
            else if(nums[mid]<=nums[high]) high=mid-1;
            else if(nums[mid]>=nums[low]) low=mid+1;
        }
        return 0;
    }
}
