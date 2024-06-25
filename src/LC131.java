import java.util.ArrayList;
import java.util.List;

public class LC131 {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        search(s, new ArrayList<>(), 0);
        return result;
    }

    private void search(String s, List<String> curList, int curIndex) {
        if (curIndex == s.length()) {
            result.add(new ArrayList<>(curList));
            return;
        }

        for (int i = curIndex + 1; i < s.length() + 1; i++) {
            String substring = s.substring(curIndex, i);
            if (isPalindrome(substring)) {
                curList.add(substring);
                search(s, curList, i);
                curList.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        if(s.length() == 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
