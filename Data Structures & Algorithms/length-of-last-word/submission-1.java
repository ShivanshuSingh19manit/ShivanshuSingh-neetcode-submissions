class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++){
            String temp = "";
            while(i<s.length() && s.charAt(i) != ' '){
                temp += s.charAt(i);
                i++;
            }
            if(temp.length() > 0){
            ans = temp.length();
            }
        }
        return ans;
    }
}