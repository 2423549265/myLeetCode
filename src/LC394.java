import java.util.ArrayDeque;
import java.util.Deque;

public class LC394 {
    public String decodeString(String s) {
        Deque<String> stringStack = new ArrayDeque<>();
        Deque<Integer> integerStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int pow = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stringStack.push(sb.toString());
                integerStack.push(pow);
                sb = new StringBuilder();
                pow = 0;
            } else if (c == ']') {
                String prefix = stringStack.pop();
                int num = integerStack.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(prefix + tmp);
            } else if (c >= '0' && c <= '9') {
                pow = pow * 10 + c - '0';
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
