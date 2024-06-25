import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class LC20 {

    HashMap<Character, Character> map = new HashMap<>() {{
        put('(', ')');
        put('[', ']');
        put('{', '}');
    }};

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!map.get(pop).equals(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
