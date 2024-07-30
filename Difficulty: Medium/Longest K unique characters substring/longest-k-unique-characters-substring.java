//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int lPointer=0;
        int ans=-1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
            if(hm.size()>k){
                char t=s.charAt(lPointer);
                if(hm.get(t)==1) hm.remove(t);
                else hm.put(t,hm.get(t)-1);
                
                lPointer++;
            }
            
            if(hm.size()==k) ans=Math.max(ans,i-lPointer+1);
            
        }
        // System.out.println(hm);
        return ans;
    }
}