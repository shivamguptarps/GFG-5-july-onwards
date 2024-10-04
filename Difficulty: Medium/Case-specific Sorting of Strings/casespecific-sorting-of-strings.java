//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        int freqL[]=new int[26];
        int freqU[]=new int[26];
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            
            if(ch>='A' && ch<='Z') freqU[ch-'A']++;
            else freqL[ch-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        int m=0;int n=0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='A' && ch<='Z') {
                while(freqU[m]<1){
                    m++;
                }
                sb.append((char)(m+'A'));
                freqU[m]--;
            }
            else {
                while(freqL[n]<1){
                    n++;
                }
                sb.append((char)(n+'a'));
                freqL[n]--;
            }
        }
        
        return sb.toString();
        
    }
    
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends