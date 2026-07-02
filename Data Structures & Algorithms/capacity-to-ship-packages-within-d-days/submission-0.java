class Solution {

   public boolean canShip(int[] weights,int maxCap, int days){

    int currCap = 0;
    int currDay = 1;

    int n = weights.length;

    for(int i=0;i<n;i++){
        if(currCap + weights[i] > maxCap){
            currDay++;
            currCap = weights[i];
        }else {
            currCap += weights[i];
        }
    }
    return currDay <= days;

   }

    public int shipWithinDays(int[] weights, int days) {
        int maxCap = 0;
        int minCap = 0;
        int n = weights.length;
        for(int i =0;i<n;i++){
            maxCap += weights[i];
            minCap = Math.max(minCap,weights[i]);
        }
        for(int i = minCap;i<= maxCap;i++){
            if(canShip(weights,i,days))
            return i;
        }
        return -1;
    }
}