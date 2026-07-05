class Solution {

    public boolean canship(int[] weights, int canShip ,int days){
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
        return currentDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int minship = Integer.MIN_VALUE;
        int maxship = 0;
        for(int i=0;i<weights.length;i++){
            maxship += weights[i];
            minship = Math.max(minship,weights[i]);
        }
        for(int i=minship;i<=maxship;i++){
            if(canship(weights,i,days)){
                return i;
            }
        }
        return -1;

    }
}