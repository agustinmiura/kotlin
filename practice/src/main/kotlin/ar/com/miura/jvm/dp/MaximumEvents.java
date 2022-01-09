package ar.com.miura.jvm.dp;


/**
 * https://leetcode.com/contest/biweekly-contest-45/problems/maximum-number-of-events-that-can-be-attended-ii/
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/discuss/1055652/Java-DP-solution-using-MapTreeMap
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/discuss/1052448/Java-Bottom-Up-DP-Solution
 * https://www.youtube.com/watch?v=sm1SAp_lj80
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/
 * https://www.youtube.com/channel/UCl3tJFKsFrw2p_Wxf1YDSow
 */
public class MaximumEvents {

    private int[][] dp;

    public static void main(String[] args) {
        int[][] ints = new int[3][];
        ints[0] = new int[]{1,2,4};
        ints[1] = new int[]{3,4,3};
        ints[2] = new int[]{2,3,1};
        int maxValue = (new MaximumEvents().maxValue(ints, 2));
        String stop = "stop";
    }

    /**
     * @param events Events
     * @param k      Quantity of steps
     * @return
     */
    public int maxValue(int[][] events, int k) {

        /**
         * Sort event array according to the start time and then ending time
         */
        java.util.Arrays.sort(events, (firstEvent, secondEvent) -> {
            if (Integer.compare(firstEvent[0], secondEvent[0])==0) {
                return Integer.compare(firstEvent[1], secondEvent[1]);
            } else {
                return Integer.compare(firstEvent[0], secondEvent[0]);
            }
        });

        int eventQty = events.length;
        dp = new int[eventQty+1][k+1];
        return processDp(events, 0, k);
    }

    private int processDp(int[][] events, int eventId, int stepsRemaing) {
        /**
         * Cut recursion here
         */
        if (eventId==events.length || stepsRemaing ==0) {
            return 0;
        }

        if (dp[eventId][stepsRemaing]!=0) {
            return dp[eventId][stepsRemaing];
        } else {

            int low = eventId+1;
            int high = events.length-1;
            int nextEventId = high + 1;
            while(low<=high){
                int mid = (low+high)/2;
                if(events[mid][0]>events[eventId][1]){
                    nextEventId = mid;
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }

            int maxEvents = 0;
            int durationProcessingEvent = events[eventId][2]+processDp(events, nextEventId, stepsRemaing-1);
            int durationWithoutProcessing = processDp(events, eventId+1, stepsRemaing);
            maxEvents = Math.max(durationProcessingEvent, durationWithoutProcessing);
            return maxEvents;
        }
    }
}
