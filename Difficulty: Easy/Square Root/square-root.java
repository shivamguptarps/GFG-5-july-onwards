//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    int floorSqrt(int n) {
        int low=0;
        int high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            long check = mid*mid;
            if(check==n){
                return mid;
            }
            else if(check>n){
                high=mid-1;
            }
            else low=mid+1;
        }
        return high;
    }
}
