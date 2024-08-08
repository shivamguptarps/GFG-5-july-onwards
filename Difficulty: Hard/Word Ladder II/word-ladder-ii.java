//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++) x += a.get(i);
        for (int i = 0; i < b.size(); i++) y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for (int i = 0; i < n; i++) {
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans =
                obj.findSequences(startWord, targetWord, wordList);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                Collections.sort(ans, new comp());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size(); j++) {
                        sb.append(ans.get(i).get(j) + " ");
                    }
                    if (i != ans.size() - 1) sb.append("\n");
                }
                System.out.println(sb);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair{
        String s;
        int l;
        
        public Pair(String s,int l){
            this.s=s;
            this.l=l;
        }
    }
    public ArrayList<ArrayList<String>> findSequences(String start,
                                                      String target,
                                                      String[] wL) {
        Set<String> hs = new HashSet<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(String it : wL) hs.add(it);
        hs.remove(start);
        ArrayList<String> arlAdd=new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        arlAdd.add(start);
        q.add(arlAdd);
        
        int count=Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            ArrayList arl=q.remove();
            // System.out.println(arl.get(arl.size()-1));
            String temp=arl.get(arl.size()-1).toString();
            
            if(temp.equals(target)){
                count=Math.min(count,arl.size());
                ans.add(arl);
            } 
            
            hs.remove(temp);
            for(int i=0;i<temp.length();i++){
          
                StringBuilder sb = new StringBuilder(temp);
            for(char k='a' ; k<='z';k++){
                    sb.setCharAt(i,k);
                    String sb1=sb.toString();
                    if(hs.contains(sb1)){
                        ArrayList<String> arlN=new ArrayList<>(arl);
                        arlN.add(sb1);
                        q.add(arlN);
                    }
                }
            }
        }
        // System.out.print(count);
        // System.out.print(ans);
        int i=0;
        for(;i<ans.size();){
            if(ans.get(i).size()>count){
                //  System.out.println(ans.get(i));
                 ans.remove(i);
            }
            else i++;
        }
        return ans;
    
    }
}