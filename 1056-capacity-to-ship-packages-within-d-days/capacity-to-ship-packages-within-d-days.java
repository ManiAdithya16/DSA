class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = max(weights);
        int high = sum(weights);
        while(low<=high){
            int mid= low + (high-low)/2;
            int reqdays = func(weights, mid);
            if(reqdays <= days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public int func(int[] weights, int cap){
        int days = 1;
        int load= 0;
        for(int i=0;i<weights.length;i++){
            if(load + weights[i] > cap){
                days++;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }
    public int max(int[] weights){
        int max =0;
        for(int i=0;i<weights.length;i++){
            max = Math.max(max, weights[i]);
        }
        return max;
    }
    public int sum(int[] weights){
        int sum =0;
        for(int i=0;i<weights.length;i++){
            sum += weights[i];
        }
        return sum;
    }
}