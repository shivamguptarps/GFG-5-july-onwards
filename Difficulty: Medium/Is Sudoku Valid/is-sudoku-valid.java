//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    private static boolean isValidC(int board[][],int row,int col,int num){
        int nrow=(row/3)*3;
        int ncol=(col/3)*3;
        for(int i=0;i<9;i++){
            if(board[row][i]==num) return false;
            if(board[i][col]==num) return false;
            if(board[nrow+i/3][ncol+i%3]==num) return false;
        }
        return true;
    }
    static int isValid(int board[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!=0){
                    int num=board[i][j];
                    board[i][j]=0;
                    if(!isValidC(board,i,j,num)) return 0;
                    board[i][j]=num;
                }
            }
        }
        return 1;
    }
}