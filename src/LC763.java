import java.util.ArrayList;
import java.util.List;

public class LC763 {
    public List<Integer> partitionLabels(String s) {
        // 记录每个字母最后一次出现的位置
        int[] positionArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            positionArray[c - 'a'] = i;
        }

        int start = -1, end = -1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int newEnd = positionArray[s.charAt(i) - 'a'];
            if (newEnd > end) {
                end = newEnd;
            }
            if (i == end) {
                result.add(end - start);
                start = i;
                end = -1;
            }
        }
        return result;
    }
}
