class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[][] sortedQueries = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            int queryVal = sortedQueries[i][0];
            int queryIdx = sortedQueries[i][1];

            while (j < intervals.length && intervals[j][0] <= queryVal) {
                int left = intervals[j][0];
                int right = intervals[j][1];
                pq.offer(new int[]{right - left + 1, right});
                j++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < queryVal) {
                pq.poll();
            }

            result[queryIdx] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return result;
    }
}