//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    private static String topSort(ArrayList<Integer> adj[],int V){
        int ind[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[i].size();j++){
                ind[adj[i].get(j)]++;
            }
        }
        
        for(int i=0;i<ind.length;i++){
            if(ind[i]==0) q.add(i);
        }
        
        int top[]= new int[V];
        int i=0;
        
        while(!q.isEmpty()){
            int temp =q.remove();
            top[i++]=temp;
            
            for(int it : adj[temp]){
                ind[it]--;
                if(ind[it]==0) q.add(it);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int it : top){
            sb.append((char)('a'+it));
        }
        return sb.toString();
        
    }
    
    public String findOrder(String [] dict, int n, int V)
    {
        boolean vis[] = new boolean[V];
        ArrayList<Integer> adj[]  = new ArrayList[V];
        
        for(int i=0;i<V;i++){
            adj[i]= new ArrayList<>();
        }
        
        for(int i=0;i<dict.length-1;i++){
            for(int j=0;j<Math.min(dict[i].length(),dict[i+1].length());j++){
                if(dict[i].charAt(j) != dict[i+1].charAt(j)){
                    adj[dict[i].charAt(j)-'a'].add(dict[i+1].charAt(j)-'a');
                    break;
                }
            }
        }
        
        
        return topSort(adj,V);
    }
}