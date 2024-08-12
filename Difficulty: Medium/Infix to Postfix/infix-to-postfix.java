//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    private static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='+' || ch=='-') return 1;
        return 0;
    }
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(Character.isLetterOrDigit(ch)) sb.append(ch);
            else if(ch=='(') st.push(ch);
            else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && priority(ch)<=priority(st.peek())){
                    sb.append(st.pop());
                }
                
                st.push(ch);
            }
        }
        while(!st.isEmpty()) sb.append(st.pop());

        return sb.toString();
    }
}