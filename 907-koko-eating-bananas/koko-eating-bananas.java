class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findmax(piles);
        while(low<=high){
            int mid = low+(high-low)/2;
            long tothours = calculatetothours(piles, mid);
            if(tothours <= h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public int findmax(int[] piles){
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }
    public long calculatetothours(int[] piles, int hourly){
        long tothours = 0;
        for(int i=0;i<piles.length;i++){
            tothours += Math.ceil((double)piles[i] / (double)hourly);
        }
        return tothours;
    }

}