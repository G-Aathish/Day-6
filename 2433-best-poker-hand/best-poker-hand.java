import java.util.HashMap;
import java.util.Map;

class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        // Step 1: Check for Flush
        boolean isFlush = true;
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[0]) {
                isFlush = false;
                break;
            }
        }
        if (isFlush) {
            return "Flush";
        }

        // Step 2: Count frequencies of each card rank
        Map<Integer, Integer> rankCounts = new HashMap<>();
        int maxCount = 0;
        for (int rank : ranks) {
            int currentCount = rankCounts.getOrDefault(rank, 0) + 1;
            rankCounts.put(rank, currentCount);
            maxCount = Math.max(maxCount, currentCount);
        }

        // Step 3: Match counts to the best possible hand remaining
        if (maxCount >= 3) {
            return "Three of a Kind";
        } else if (maxCount == 2) {
            return "Pair";
        }

        return "High Card";
    }
}
