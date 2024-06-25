import java.util.ArrayList;
import java.util.List;

public class LC46 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        search(nums, new ArrayList<>());

        return result;
    }

    public void search(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            search(nums, list);
            list.removeLast();
        }
    }
}
