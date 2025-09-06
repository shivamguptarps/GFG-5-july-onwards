class Solution {
    public int countAtMostK(int arr[], int k) {
        int ans=0;
        int lp=0;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int it = arr[i];
            hm.put(it, hm.getOrDefault(it, 0) + 1);
            while (hm.size() > k) {
                hm.put(arr[lp], hm.get(arr[lp]) - 1);
                if (hm.get(arr[lp]) == 0) {
                    hm.remove(arr[lp]);
                }
                lp++;
            }
            if(hm.size()<=k) ans+=i-lp+1;
        }
        return ans;
        
    }
}
