import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {
    
    Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> result = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        search(digits, new StringBuilder(), 0);
        return result;
    }
    
    public void search(String digits, StringBuilder sb, int curIndex) {
        if (curIndex == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String s = phone.get(digits.charAt(curIndex));
        for(char c : s.toCharArray()) {
            sb.append(c);
            search(digits, sb, curIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
