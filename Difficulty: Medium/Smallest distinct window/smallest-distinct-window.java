//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String s) {
       Set<Character> hs = new HashSet<>();
       Map<Character,Integer> hm = new HashMap<>();
       
       
       for(int i=0;i<s.length();i++) hs.add(s.charAt(i));
       
       
       int lp=0;
       int ans=s.length();
       for(int i=0;i<s.length();i++){
           
           hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
           
           while(hm.get(s.charAt(lp))>1){
               hm.put(s.charAt(lp),hm.get(s.charAt(lp))-1);
               lp++;
           }
           
           if(hm.size()==hs.size()){
               ans=Math.min(ans,i-lp+1);
           }
           
       }
       return ans;
    }
}