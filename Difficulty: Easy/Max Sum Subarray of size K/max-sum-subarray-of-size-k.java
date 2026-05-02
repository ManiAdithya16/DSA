class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int sum =0;
        int max =0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            
            if(i >=k){
                sum -= arr[i-k];
            }
            if(i >= k-1){
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}