//{ Driver Code Starts
import java.util.Scanner;
class Matrix{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			int[][] b = new int[n][n];
			int[][] c = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j]=sc.nextInt();
			for(int i = 0 ;i < n; i++)
				for(int j = 0; j < n; j++)
					b[i][j]=sc.nextInt();
			GfG g = new GfG();
			g.multiply(a,b,c,n);
			for (int i = 0; i < n; i++)
			{for (int j = 0; j < n; j++)
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG
{
      public static void multiply(int m1[][], int m2[][], int ans[][], int N)
        {
           for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                
                for(int k=0;k<N;k++){
                    ans[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        }
}