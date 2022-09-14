package Week5;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static boolean canCross(int[] stones) {
        Map<Integer, Map<Integer, Boolean>> DP = new HashMap<>();
        for (int stone : stones) {
            DP.put(stone, new HashMap<Integer, Boolean>());
        }
        return checkCross(DP, 0, 1, stones[stones.length-1]);
    }

    static boolean checkCross(Map<Integer, Map<Integer, Boolean>> DP, int currentStone, int jump, int targetStone) {
        if (currentStone == targetStone) {
            return true;
        } else if (!DP.containsKey(currentStone) || jump == 0) {
            return false;
        } else if (DP.containsKey(currentStone) && DP.get(currentStone).containsKey(jump)) {
            return DP.get(currentStone).get(jump);
        } else {
            boolean ans1 = checkCross(DP, currentStone + jump, jump - 1, targetStone);
            boolean ans2 = checkCross(DP, currentStone + jump, jump, targetStone);
            boolean ans3 = checkCross(DP, currentStone + jump, jump + 1, targetStone);
            DP.get(currentStone).put(jump, (ans1 || ans2 || ans3));
            return DP.get(currentStone).get(jump);
        }
    }

    public static void main(String[] args) {
        var a = new Solution();
        int[] task = {0,1,3,5,6,8,12,17};
        System.out.println(Solution.canCross(task));
    }
}