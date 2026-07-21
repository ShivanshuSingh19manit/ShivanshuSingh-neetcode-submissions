class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> preHash = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int temp = nums[i];
            int diff = target - temp;
            if(preHash.containsKey(diff)){
                return new int[]{preHash.get(diff),i};
            }
            preHash.put(temp,i);
        }
        return new int[]{-1,-1};
    }
}
