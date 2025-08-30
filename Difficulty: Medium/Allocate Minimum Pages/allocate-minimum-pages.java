class Solution {
    public int findPages(int[] arr, int k) {
        if(k>arr.length) return -1;
        
        int low=Integer.MAX_VALUE,high=0;
        for(int it : arr){
            low = Math.min(low,it);
            high+=it;
        }
        
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            
            boolean check=helper(arr,k,mid);
            if(check){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    private boolean helper(int stalls[],int k,int mid){
        int temp=1;
        int sum=0;
        for(int i=0;i<stalls.length;i++){
            if(stalls[i]>mid) return false;
            if(sum+stalls[i]>mid){
                temp++;sum=stalls[i];
            }
            else sum+=stalls[i];
        }
        return temp<=k;
    }
}