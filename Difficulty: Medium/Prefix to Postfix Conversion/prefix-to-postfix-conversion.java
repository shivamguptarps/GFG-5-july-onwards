//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToPost(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToPost(String exp) {
        Stack<String> st = new Stack<>();
        
        for(int i=exp.length()-1;i>=0;i--){
            char ch= exp.charAt(i);
            if(Character.isLetterOrDigit(ch)) st.push(Character.toString(ch));
            else{
                String s1=st.pop();
                String s2=st.pop();
                st.push(s1+s2+ch);
            }
        }
            return st.pop();
    }
}
