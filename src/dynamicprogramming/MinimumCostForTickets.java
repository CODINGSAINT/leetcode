package dynamicprogramming;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int noOfDays = days.length;
        int lastDay = days[noOfDays - 1];

        boolean shouldTravel[] = new boolean[lastDay + 1];

        int dp[] = new int[lastDay + 1];

        for (int i = 0; i < days.length; i++) {
            int day = days[i];

            shouldTravel[day] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            if (shouldTravel[i] == false)
                dp[i] = dp[i - 1];
            else {
                int first = dp[i - 1] + costs[0];
                int seven = dp[Integer.max(0, i - 7)] + costs[1];
                int thirty = dp[Integer.max(0, i - 30)] + costs[2];
                dp[i] = Integer.min(first, Integer.min(seven, thirty));

            }
        }


        return dp[lastDay];
    }
}
