import java.util.Stack;

public class LC150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    Integer i1 = stack.pop();
                    Integer i2 = stack.pop();
                    stack.push(i1 + i2);
                    break;
                case "-":
                    Integer i3 = stack.pop();
                    Integer i4 = stack.pop();
                    stack.push(i4 - i3);
                    break;
                case "*":
                    Integer i5 = stack.pop();
                    Integer i6 = stack.pop();
                    stack.push(i5 * i6);
                    break;
                case "/":
                    Integer i7 = stack.pop();
                    Integer i8 = stack.pop();
                    stack.push(i8 / i7);
                    break;
                default:
                    Integer i = Integer.valueOf(token);
                    stack.push(i);
            }
        }
        return stack.pop();
    }
}
