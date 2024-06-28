import java.util.ArrayDeque;
import java.util.Deque;

public class LC71 {
    public static void main(String[] args) {
        new LC71().simplifyPath("/home//foo/");
    }
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String str : path.split("/")) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (str.equals(".")) {
                ;
            } else if (str.equals("")) {
                ;
            } else {
                stack.push(str);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append("/").append(stack.getLast());
                stack.removeLast();
            }
            return sb.toString();
        }
    }
}
