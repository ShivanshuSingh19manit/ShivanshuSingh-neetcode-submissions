class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int minRate = 1;
       int maxRate = Integer.MIN_VALUE;
       for(int i=0;i<piles.length;i++){
          maxRate = Math.max(maxRate,piles[i]);
       }
        int left = minRate;
        int right = maxRate;
        int res = right;
        while(left <= right){
        long totaltime = 0;
        int mid = left + (right-left)/2;
        for(int pile : piles){
            totaltime += (int)Math.ceil((double)pile/mid);
        }
        if(totaltime <= h){
            res = mid;
            right = mid - 1;
        }else{
            left = mid +1;
        }
    }
        return res;

    }
    }

