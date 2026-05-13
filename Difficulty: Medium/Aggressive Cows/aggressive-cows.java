class Solution {

    public static int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlace(stalls, mid, k)) {

                ans = mid;
                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean canPlace(int[] stalls, int dist, int cows) {

        int countCows = 1;
        int lastPlaced = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPlaced >= dist) {

                countCows++;
                lastPlaced = stalls[i];
            }
        }

        return countCows >= cows;
    }
}