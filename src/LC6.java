import java.util.ArrayList;
import java.util.List;

public class LC6 {
    /*
        输入：s = "PAYPALISHIRING", numRows = 4
        输出："PINALSIGYAHRPI"
        解释：
        P     I    N
        A   L S  I G
        Y A   H R
        P     I
     */
    public static void main(String[] args) {
        System.out.println(LC6.convert("PAYPALISHIRING", 3));
    }
    public static String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

    public static String convert1(String s, int numRows) {
        int gap1 = 2 * numRows - 2;
        int gap2 = 0;
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        while (gap1 >= 0) {
            int index = startIndex;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                if (gap1 != 0) {
                    index += gap1;
                    if (index < s.length()) {
                        sb.append(s.charAt(index));
                    } else {
                        break;
                    }
                }
                if (gap2 != 0) {
                    index += gap2;
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            gap1 -= 2;
            gap2 += 2;
            startIndex ++;
        }

        return sb.toString();
    }
}
