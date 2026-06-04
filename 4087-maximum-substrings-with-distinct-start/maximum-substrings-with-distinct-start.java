class Solution {
    public int maxDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }
        return map.size();
    }
}