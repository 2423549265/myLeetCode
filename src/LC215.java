import java.util.Random;

public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    private int quickSelect(int[] nums, int left, int right, int k) {
        int index = partition(nums, left, right);
        if (index == k) {
            return nums[k];
        } else if (index > k) {
            return quickSelect(nums, left, index - 1, k);
        } else {
            return quickSelect(nums, index + 1, right, k);
        }
    }
    private int partition(int[] nums, int left, int right) {
        int index = left + new Random().nextInt(right - left + 1);
        swap(nums, left, index);
        int le = left + 1, ge = right;
        while (true) {
            while (nums[le] < nums[left]) {
                le ++;
            }
            while (nums[ge] > nums[left]) {
                ge --;
            }
            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le ++;
            ge --;
        }
        swap(nums, left, ge);

        return ge;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
