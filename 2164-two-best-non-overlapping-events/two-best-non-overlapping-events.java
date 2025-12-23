import java.util.Arrays;

class Solution {
    public int maxTwoEvents(int[][] events) {
       
        Arrays.sort(events, (a, b) -> a[1] - b[1]); // Sort by endTime

        // Precompute max values up to each event
        int n = events.length;
        int[] maxValueUntil = new int[n];
        maxValueUntil[0] = events[0][2]; // The value of the first event

        for (int i = 1; i < n; i++) {
            maxValueUntil[i] = Math.max(maxValueUntil[i - 1], events[i][2]);
        }

        int maxSum = 0;

        //  Iterate through each event and consider it as the second event
        for (int i = 0; i < n; i++) {
            int value2 = events[i][2];

            // Use binary search to find the latest event that doesn't overlap
            int l = 0, r = i - 1, bestIndex = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (events[mid][1] < events[i][0]) { // No overlap
                    bestIndex = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            int value1 = bestIndex != -1 ? maxValueUntil[bestIndex] : 0;

            maxSum = Math.max(maxSum, value1 + value2);
        }

        return maxSum;
    }
}
