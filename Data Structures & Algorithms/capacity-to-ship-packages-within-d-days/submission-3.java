class Solution {

    public boolean canship(int[] weights, int canShip,int days){
        int currentship = 0;
        int currentDays = 1;

        for(int i=0;i<weights.length;i++){

            if(currentship+weights[i] <= canShip){
                    currentship += weights[i];
            }else{
                currentDays++;
                currentship = weights[i];
            }
        }
        return currentDays <= days ;
    }

    public int shipWithinDays(int[] weights, int days) {
        int minship = Integer.MIN_VALUE;
        int maxship = 0;
        for(int i=0;i<weights.length;i++){
            maxship += weights[i];
            minship = Math.max(minship,weights[i]);
        }
        int low = minship;
        int high = maxship;
        int ans = high;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canship(weights,mid,days)){
                high = mid -1;
                ans = mid;
            }else {
                low = mid + 1;
            }

        }

        return ans;

    }
}