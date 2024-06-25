import java.util.HashSet;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right ++;
            }
            res = Math.max(res, right - left);
            while (right < s.length() && set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left ++;
            }
        }

        return res;
    }
}
