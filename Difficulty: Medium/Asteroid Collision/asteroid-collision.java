//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int n, int[] ast) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> arl = new ArrayList<>();

        for(int it : ast){
            boolean flag=false;
            while(!st.isEmpty() && (st.peek()>0 && it<0) ){
                if(Math.abs(st.peek())==Math.abs(it)){
                    st.pop();
                    flag=true;
                    break;
                }
                else if(Math.abs(st.peek())<Math.abs(it)){
                    st.pop();
                }
                else {
                    flag=true;
                    break;
                }

            }

            if(!flag)
            st.push(it);
        }
        while(!st.isEmpty()){
            arl.add(st.pop());
        }
        int ans[]=new int[arl.size()];
        int k=0;
        for(int i=arl.size()-1;i>=0;i--) ans[k++]=arl.get(i);
        return ans;
    }
}
