//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
     private static void printPer(String s,String temp,List<String> arl){
        if(s.length()==0){
            arl.add(temp);
            return;
        }
        for(int  i=0;i<s.length();i++){
            if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)) continue;
            printPer(s.substring(0, i)+s.substring(i+1), temp+s.charAt(i),arl);
        }
    }
    public List<String> find_permutation(String S) {
        
        List<String> arl = new ArrayList<>();
        char arr[]=S.toCharArray();
        Arrays.sort(arr);
        S=new String(arr);
        printPer(S,"",arl);
        return arl;
        
    }
}