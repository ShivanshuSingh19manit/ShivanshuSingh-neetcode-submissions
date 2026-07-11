class Solution {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        int res = 0;
        while(low <= high){
            long mid = low + (high-low)/2;
            if((int)mid*mid == x){
                return (int)mid;
            }else if((int)mid*mid > x){
                high = (int)mid-1;
            }else {
                low = (int)mid + 1;
            }
        }
        return high;
    }
}