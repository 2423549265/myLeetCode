import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Huawei1 {
    // 一个整数可以由连续的自然数之和来表示，给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式
    // 输入：9
    // 输出：9=9
    //      9=4+5
    //      9=2+3+4
    //      Result:3
    //
    // 整数 9 有三种表示方法，第1个表达式只有1个自然数，最先输出，第2个表达式有2个自然数，第2次序输出，第3个表达式有3个自然数，最后输出。每个表达式中的自然数都是按递增次序输出的。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> result = new ArrayList<>();
        int left = 1, right = 2, sum = 3;

        while (left <= n / 2) {
            if (sum == n) {
                // 找到一组解
                List<Integer> tmp = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    tmp.add(i);
                }
                result.add(tmp);
                sum -= left;
                left ++;
            } else if (sum < n) {
                right ++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }

        List<Integer> tmp = new ArrayList<>();
        tmp.add(n);
        result.add(tmp);

        result.sort((o1, o2) -> o1.size() - o2.size());

        for (List<Integer> seq : result) {
            System.out.print(n + "=");
            for (int i = 0; i < seq.size(); i++) {
                System.out.print(seq.get(i));
                if (i != seq.size() - 1) {
                    System.out.print("+");
                }
            }
            System.out.println();
        }

        System.out.println("Result:" + result.size());
    }
}
