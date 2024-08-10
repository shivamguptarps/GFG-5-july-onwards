//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    private int lRA(int[] arr) {
        int n=arr.length;
        int ans=0;
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
            int nse=n;
            int pse=!st.isEmpty()? st.peek() : -1;
            
            ans=Math.max(ans,arr[t]*(nse-pse-1));
        }
    return ans;
    }
    
    public int maxArea(int mat[][], int n, int m) {
        // add code here.
        for(int i=1;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=0)
                mat[i][j]=mat[i][j]+mat[i-1][j];
            }
        }
        int ans=0;
        for(int i=0;i<mat.length;i++){
                ans=Math.max(ans,lRA(mat[i]));
            }

        return ans;
    }
}