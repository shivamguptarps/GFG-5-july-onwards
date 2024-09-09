//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private String solve(String s){
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<26;i++){
            if(freq[i]>0){
                sb.append(((char)(i+'a')));
                sb.append(freq[i]);
            }
        }
        return sb.toString();
    }
     public List<List<String>> Anagrams(String[] strs) {
        List<List<String>> arl = new ArrayList<>();

        HashMap<String,List<String>> hm = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String temp=solve(strs[i]);
            if(!hm.containsKey(temp)){
                hm.put(temp,new ArrayList<>());
            }
                hm.get(temp).add(strs[i]);
            // else{
            // }
        }
        for(List<String> l1 : hm.values()){
            // arl.add(new ArrayList<>());
            // for(int i=0;i<hm.get(s).size();i++){
            //     arl.get(arl.size()-1).add(hm.get(s).get(i));
            // }
            arl.add(l1);
        }

        return arl; 
    }
}
