class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();

        List<Character> list = new ArrayList<>();
        for(char ch : arr){
            if(isVowel(ch)){
                list.add(ch);
            }
        }
        Collections.sort(list);
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(isVowel(arr[i])){
                arr[i] = list.get(j);
                j++;
            }
        }
        return new String(arr);
    }
    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}