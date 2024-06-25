import java.util.HashSet;
import java.util.Set;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int cnt = 1, curNum = num + 1;
                while (set.contains(curNum)) {
                    cnt ++;
                    curNum ++;
                }
                max = Math.max(cnt, max);
            }
        }

        return max;
    }
}
