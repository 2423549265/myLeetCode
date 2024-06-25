import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right --;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left ++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left++]);
                    list.add(nums[right--]);
                    result.add(list);
                    while (left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > i && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LC15 lc15 = new LC15();
        List<List<Integer>> lists = lc15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
