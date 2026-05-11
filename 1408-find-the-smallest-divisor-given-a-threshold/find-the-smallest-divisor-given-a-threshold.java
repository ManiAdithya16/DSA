class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low =1;
        int high = findmax(nums);
        while(low<=high){
            int mid = low +(high-low)/2;
            int tot = count(nums, mid);
            if(tot <= threshold){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public int count(int[] nums, int div){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum += Math.ceil((double) nums[i] / (double)div);
        }
        return sum;
    }
    public int findmax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}