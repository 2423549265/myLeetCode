import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        int wordNum = words.length;
        int wordLen = words[0].length();
        // 将单词数组构建成哈希表
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 这里只需遍历0~wordLen即可，因为滑动窗口都是按照wordLen的倍数进行滑动的
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            // 滑动窗口
            int left = i, right = i, hit = 0;
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (map.containsKey(word)) {
                    int num = tmp.getOrDefault(word, 0) + 1;
                    tmp.put(word, num);
                    hit++;
                    // 出现情况三，遇到了符合的单词，但是次数超了
                    if (map.get(word) < num) {
                        // 一直移除单词，直到次数符合
                        while (map.get(word) < tmp.get(word)) {
                            String deleteWord = s.substring(left, left + wordLen);
                            tmp.put(deleteWord, tmp.get(deleteWord) - 1);
                            left += wordLen;
                            hit--;
                        }
                    }
                } else {
                    // 出现情况二，遇到了不匹配的单词，直接将 left 移动到该单词的后边
                    tmp.clear();
                    hit = 0;
                    left = right;
                }
                if (hit == wordNum) {
                    res.add(left);
                    // 出现情况一，子串完全匹配，我们将上一个子串的第一个单词从tmp中移除，窗口后移wordLen
                    String firstWord = s.substring(left, left + wordLen);
                    tmp.put(firstWord, tmp.get(firstWord) - 1);
                    hit--;
                    left = left + wordLen;
                }
            }
        }
        return res;
    }
}
