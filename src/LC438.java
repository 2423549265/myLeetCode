import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        if (sLength < pLength) {
            return result;
        }
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for (int i = 0; i < pLength; i++) {
            pCnt[p.charAt(i) - 'a'] ++;
            sCnt[s.charAt(i) - 'a'] ++;
        }
        if (Arrays.equals(pCnt, sCnt)) {
            result.add(0);
        }

        for (int right = pLength; right < sLength; right++) {
            sCnt[s.charAt(right) - 'a'] ++;
            sCnt[s.charAt(right - pLength) - 'a'] --;
            if (Arrays.equals(pCnt, sCnt)) {
                result.add(right - pLength + 1);
            }
        }

        return result;
    }
}
