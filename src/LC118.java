import java.util.ArrayList;
import java.util.List;

public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> integerList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    integerList.add(1);
                } else {
                    List<Integer> tmp = result.get(i - 1);
                    integerList.add(tmp.get(j - 1) + tmp.get(j));
                }
            }
            result.add(integerList);
        }
        return result;
    }
}
