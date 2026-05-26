class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            freq[ch-'a']--;
            if(freq[ch-'a'] < 0){
                return ch;
            }
        }
        return ' ';
    }
}