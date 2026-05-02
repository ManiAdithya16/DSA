class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for(int i=0;i<p.length();i++){
            cnt1[p.charAt(i) - 'a']++;
        }
        int k = p.length();
        for(int i=0;i<s.length();i++){
            cnt2[s.charAt(i) - 'a']++;

            if(i>=k){
                cnt2[s.charAt(i-k) - 'a']--;
            }
            if(matches(cnt1, cnt2)){
                ans.add(i-k+1);
            }
        }
        return ans;
    }
    private boolean matches(int[] a, int[] b){
        for(int i =0;i<26;i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}