//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String s, int k) {
        if(s.length()==k) return "0";
        Stack<Character> st =new Stack<>();

        for(int i=0;i<s.length();i++){
            while(!st.isEmpty() && st.peek()>s.charAt(i) && k>0){
                st.pop();
                k--;
            }
            st.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        
        while((k--)>0) st.pop();

        for(char ch : st){
            if(ch=='0' && sb.length()==0) continue;
            else sb.append(ch);
        }
        
        if(sb.length()==0) return "0";
        return sb.toString();
    }
}