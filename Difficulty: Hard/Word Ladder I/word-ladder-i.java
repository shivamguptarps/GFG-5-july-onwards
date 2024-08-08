//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    static class Pair{
        String s;
        int l;
        
        public Pair(String s,int l){
            this.s=s;
            this.l=l;
        }
    }
    public int wordLadderLength(String start, String target, String[] wL)
    {
        Set<String> hs = new HashSet<>();
        
        for(String it : wL) hs.add(it);
        hs.remove(start);
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,1));
        
        while(!q.isEmpty()){
            Pair p=q.remove();
            String temp=p.s;
            if(temp.equals(target)) return p.l;
            for(int i=0;i<temp.length();i++){
                char arr[]=temp.toCharArray();
            for(char k='a' ; k<='z';k++){
                    arr[i]=k;
                    String t1=new String(arr);
                    if(hs.contains(t1)){
                        // System.out.println(t1);
                        q.add(new Pair(t1,p.l+1));
                        hs.remove(t1);
                    }
                }
            }
        }
    return 0;
    }
    
}