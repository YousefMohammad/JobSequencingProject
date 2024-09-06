import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class Helper {
    public static int maximumProfit(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        int length = jobs.length;
        int[] solutionArray = new int[length];

        solutionArray[0] = jobs[0][2];

        for (int i = 1; i < length; i++) {
            int profit = jobs[i][2];
            int prevJobIndex = binarySearch(jobs, i);

            if (prevJobIndex != -1) {
                profit += solutionArray[prevJobIndex];
            }
            solutionArray[i] = Math.max(solutionArray[i-1], profit);
        }

        return solutionArray[length-1];
    }
}