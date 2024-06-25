import java.util.ArrayList;
import java.util.List;

public class LC22 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        search(n, new StringBuilder(), 0, 0);
        return result;
    }

    private void search(int n, StringBuilder sb, int left, int right) {
        if (left == right && n == left) {
            result.add(sb.toString());
            return;
        } else if (right > left || left > n) {
            return;
        }

        sb.append('(');
        search(n, sb, left + 1, right);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        search(n, sb, left, right + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
