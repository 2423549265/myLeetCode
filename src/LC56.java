import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.getLast();
            if (last[1] >= intervals[i][0]) {
                if (last[1] < intervals[i][1]) {
                    last[1] = intervals[i][1];
                    result.removeLast();
                    result.add(last);
                }
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}
