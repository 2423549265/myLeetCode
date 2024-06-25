import java.util.HashMap;

public class LC560 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            result += preSumMap.getOrDefault(curSum - k, 0);
            Integer curCnt = preSumMap.getOrDefault(curSum, 0);
            preSumMap.put(curSum, ++curCnt);
        }

        return result;
    }
}
