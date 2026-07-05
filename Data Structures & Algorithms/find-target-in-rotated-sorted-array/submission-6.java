class Solution {

    public int mid(int[] nums){
        int low = 0;
        int high = nums.length -1;

        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[high]){
                 low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
    int bineary(int []nums, int target,int low, int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }

        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int mid = mid(nums);
        if(nums[mid] == target){
            return mid;
        }
        if(mid == 0){
            return bineary(nums,target,0,nums.length-1);
        }
        if(nums[0] <= target && target <= nums[mid-1]){
        return bineary(nums,target, 0, mid-1);
        } else {
        return  bineary(nums,target,mid,nums.length-1);
        }
        // return -1;

    }
}
