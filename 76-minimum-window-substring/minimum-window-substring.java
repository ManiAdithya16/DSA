class Solution {
    public String minWindow(String s, String t) {
        int l=0;
        int r=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int cnt =0;
        int minlen = Integer.MAX_VALUE;
        int sind = -1;
        while(r < s.length()){
            char ch = s.charAt(r);
            if(map.getOrDefault(ch, 0) > 0){
                cnt++;
            }
            map.put(ch, map.getOrDefault(ch, 0) -1);
            while(cnt == t.length()){
                if(r-l+1 < minlen){
                    minlen = r-l+1;
                    sind = l;
                }
                char leftchar = s.charAt(l);
                map.put(leftchar, map.get(leftchar) +1);
                if(map.get(leftchar) > 0){
                    cnt--;
                }
                l++;
            }
            r++;
        }
        return sind == -1 ? "" : s.substring(sind, sind+minlen);
    }
}
