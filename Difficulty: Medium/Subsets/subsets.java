//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            ArrayList<Integer> A = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                A.add(arr[i]);
            }

            ArrayList<ArrayList<Integer>> res = new Solution().subsets(A);
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            // System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static void solve(ArrayList<Integer> nums,int idx,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> temp){
        if(idx>=nums.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }
            temp.add(nums.get(idx));
            solve(nums,idx+1,ans,temp);
            temp.remove(temp.size()-1);
            solve(nums,idx+1,ans,temp);
        
    }
    
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(a,0,ans,new ArrayList<>());
        
        Collections.sort(ans,(ls1,ls2)->{
            int n1=ls1.size();
            int n2=ls2.size();
            
            for(int i=0;i<Math.min(n1,n2);i++){
                int cmp=Integer.compare(ls1.get(i),ls2.get(i));
                if(cmp!=0) return cmp;
            }
            return Integer.compare(n1,n2);
        });
        
        return ans;
    }
}