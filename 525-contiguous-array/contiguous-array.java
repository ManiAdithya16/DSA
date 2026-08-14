class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int bal = 0;
        int maxlen = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                bal--;
            }else{
                bal++;
            }
            if(map.containsKey(bal)){
            int len = i - map.get(bal);
            maxlen = Math.max(len, maxlen);
            }else{
            map.put(bal, i);
            }
        }
        return maxlen;
    }
}