class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=0;i<stones.length;i++){
            ans.add(stones[i]);
        }
        while(ans.size() != 1){
        Collections.sort(ans);
        int size = ans.size();
        int x = ans.get(size - 1);
        int y = ans.get(size - 2);
        if(x == y){
            ans.remove(size - 1);
            ans.remove(size - 2);
            ans.add(0);
        } else {
            ans.add(Math.abs(y-x));
            ans.remove(size - 1);
            ans.remove(size - 2);
        }
        }
        return ans.get(0);
    }
}
