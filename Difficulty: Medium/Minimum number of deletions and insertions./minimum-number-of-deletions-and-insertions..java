//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String text1, String text2) 
	{ 
	    int n=text1.length();
        int m = text2.length();
        
        int prev[]=new int[m+1];
        
        for(int i=1;i<n+1;i++){
            int curr[]=new int[m+1];
            for(int j=1;j<m+1;j++){
                if(text1.charAt(i-1)==(text2.charAt(j-1))){
             curr[j]= 1 + prev[j-1];
        }
        else{
            curr[j]= Math.max(prev[j],curr[j-1]);
        }
            }
            prev=curr;
        }

        return n+m-prev[m]-prev[m];
	} 
}