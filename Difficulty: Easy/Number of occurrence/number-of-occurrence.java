class Solution {
    int lowerBound(int[] nums, int x) {
        int ans=nums.length;
        int low=0,high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
        
    }
    public int searchRange(int[] nums, int target) {
        int lb1 = lowerBound(nums,target);
        if(lb1==nums.length || nums[lb1]!=target) return 0;
        int lb2 = lowerBound(nums,target+1);
        // lb2 is for target+1 hence (lb2-1)
        return (lb2-1)-lb1+1;
    }
    
    int countFreq(int[] arr, int target) {
        return searchRange(arr,target);
        
    }
}
