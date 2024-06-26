import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15, 5, 1, 10, 3}, 10);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            System.out.print(",");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
