class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long flowersneeded = (long)m *k;
        if(flowersneeded > bloomDay.length){
            return -1;
        }
        int low = findmin(bloomDay);
        int high = findmax(bloomDay);

        while(low<=high){
            int mid = low+ (high-low)/2;
            int bouquets = countboq(bloomDay, mid, k);
            if(bouquets >= m){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public int countboq(int[] bloomDay, int day, int k){
        int count =0;
        int boq = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i] <= day){
                count++;
            if(count == k){
                boq++;
                count =0;
            }
        }else{
            count =0;
        }
    }
    return boq;
}
public int findmin(int[] bloomDay) {

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            mini = Math.min(mini, bloomDay[i]);
        }

        return mini;
    }

    public int findmax(int[] bloomDay) {

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            maxi = Math.max(maxi, bloomDay[i]);
        }

        return maxi;
    }
}
            