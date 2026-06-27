class Solution {
    public int minFlips(String target) {
        int count =0;
        char state = '0';
        for(int i=0;i<target.length();i++){
            if(target.charAt(i) != state){
                count++;
                state = target.charAt(i);
            }
        }
        return count;
    }
}