//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s){
        HashMap<Character,Integer> hm = new HashMap<>();
        int length=0;
        int lPointer=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)) hm.put(ch,i);
            else{
                if(hm.get(ch)>=lPointer)
                    lPointer=(hm.get(ch))+1;
               hm.put(ch,i);
            }
            length=Math.max(length,i-lPointer+1);    
        }
        return length;
        
    }
}