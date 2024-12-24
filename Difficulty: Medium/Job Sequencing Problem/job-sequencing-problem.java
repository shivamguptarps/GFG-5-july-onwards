//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] jobIDStrings = sc.nextLine().split(" ");
            String[] deadlineStrings = sc.nextLine().split(" ");
            String[] profitStrings = sc.nextLine().split(" ");

            // Convert the input strings to integer arrays
            int[] jobIDs = new int[jobIDStrings.length];
            int[] deadlines = new int[deadlineStrings.length];
            int[] profits = new int[profitStrings.length];

            for (int i = 0; i < jobIDStrings.length; i++) {
                jobIDs[i] = Integer.parseInt(jobIDStrings[i]);
                deadlines[i] = Integer.parseInt(deadlineStrings[i]);
                profits[i] = Integer.parseInt(profitStrings[i]);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.JobSequencing(jobIDs, deadlines, profits);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        int n=deadline.length;
        int arr[][]=new int[n][2];
        int maxD=0;
        for(int i=0;i<n;i++){
            arr[i][0]=deadline[i];
            arr[i][1]=profit[i];
            maxD=Math.max(maxD,deadline[i]);
        }
        int ansJob=0;
        int ansProfit=0;
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        int temp[]=new int[maxD+1];
        for(int i=0;i<arr.length;i++){
            // System.out.println(Arrays.toString(arr[i]));
            for(int j=arr[i][0];j>=1;j--){
                if(temp[j]==0){
                    temp[j]=arr[i][1];
                    ansJob++;
                    ansProfit+=arr[i][1];
                    break;
                }
            }
            // System.out.println(Arrays.toString(temp));
            
        }
        return new ArrayList<Integer>(Arrays.asList(ansJob,ansProfit));
    }
}
