class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        int COL = matrix[0].length;

        int top = 0;
        int bot = ROW -1;

        while(top <= bot){
            int mid = top + (bot-top)/2;
            if(matrix[mid][0] > target){
                bot = mid - 1;
            }else if(matrix[mid][COL-1] < target){
                top = mid + 1;
            }else{
                break;
            }
        }
        if(!(top <= bot)){
            return false;
        }
        int l = 0; int r = COL - 1;
        int row = (top+ bot)/2;
        while(l <= r){
            int m = l + (r-l)/2;
            if(matrix[row][m] == target){
                return true;
            }else if(matrix[row][m] > target){
                r = m -1;
            }else {
                l = m+1;
            }
        }
        return false;
    }
}
