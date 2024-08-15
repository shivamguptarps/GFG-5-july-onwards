//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
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
    
    private static boolean solve(int board[][],int i,int j){
        // System.out.println(Arrays.toString(board[i]));
        if(i==9) return true;
        if(j==9) return solve(board,i+1,0);
        if (board[i][j] != 0) return solve(board,i,j+1);

          for (int c = 1; c <= 9; c++) {
            if (isValidC(board, i, j, c)) {
              board[i][j] = c;
              if(solve(board,i,j+1)) return true;
              board[i][j]=0;
            }
          }
    return false;
    }
    
    static boolean SolveSudoku(int grid[][])
    {
        return solve(grid,0,0);
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(grid[i][j]+" ");
            }
        }
    }
}