class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int minans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minans = Math.min(minans,nums[i]);
        }
        return minans;
    }
}
