class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        int n = details.length;
        for(int i=0;i<n;i++){
            int ten = details[i].charAt(11) - '0';
            int one = details[i].charAt(12) - '0';
            int age = one + 10*ten;
            if(age>60){
                ans++;
            }

        }
        return ans;
    }
}