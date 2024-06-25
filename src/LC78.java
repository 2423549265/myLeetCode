import java.util.ArrayList;
import java.util.List;

public class LC78 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        search(nums, new ArrayList<>(), 0);
        return result;
    }

    public void search(int[] nums, List<Integer> list, int curIndex) {
        if (curIndex == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[curIndex]);
        search(nums, list, curIndex + 1);
        list.removeLast();
        search(nums, list, curIndex + 1);
    }
}
