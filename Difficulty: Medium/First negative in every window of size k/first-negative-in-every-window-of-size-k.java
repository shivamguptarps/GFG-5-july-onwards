//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long nums[], int N, int k)
    {
        Queue<Integer> dq= new LinkedList<>();
            long ans[]=new long[nums.length-k+1];

            for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peek()<=i-k) dq.remove();
            // while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]) dq.removeLast();
            if(nums[i]<0)
            dq.add(i);
            if(!dq.isEmpty() && i-k+1>=0)
            ans[i-k+1]=nums[dq.peek()];

            }
            return ans;
    }
}