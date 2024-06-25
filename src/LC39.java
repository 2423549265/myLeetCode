import java.util.ArrayList;
import java.util.List;

public class LC39 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        search(candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    private void search(int[] candidates, int target, List<Integer> list, int curSum, int curIndex) {
        if (curSum == target) {
            result.add(new ArrayList<>(list));
            return;
        } else if (curSum > target) {
            return;
        }

        for (int i = curIndex; i < candidates.length; i++) {
            list.add(candidates[i]);
            search(candidates, target, list, curSum + candidates[i], i);
            list.removeLast();
        }
    }
}
