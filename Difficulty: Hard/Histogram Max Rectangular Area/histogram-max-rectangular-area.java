//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long arr[], long n) 
    {
        long ans=0;
        Stack<Integer> st = new Stack<>();
        
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                int t=st.pop();
                int pse=!st.isEmpty()? st.peek() : -1;
                int nse=i;
                
                ans=Math.max(ans,arr[t]*(nse-pse-1));
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int t=st.pop();
            int nse=(int)n;
            int pse=!st.isEmpty()? st.peek() : -1;
            
            ans=Math.max(ans,arr[t]*(nse-pse-1));
        }
    return ans;
    }
        
}



