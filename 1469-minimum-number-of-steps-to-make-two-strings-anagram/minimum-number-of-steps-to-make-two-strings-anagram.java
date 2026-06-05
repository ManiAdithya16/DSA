class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        for(char ch1: s.toCharArray()){
            freq[ch1 -'a']++;
        }
        for(char ch2 : t.toCharArray()){
            freq[ch2 - 'a']--;
        }
        int steps = 0;
        for(int cnt : freq){
            if(cnt > 0){
                steps += cnt;
            }
        }
        return steps;
    }
}