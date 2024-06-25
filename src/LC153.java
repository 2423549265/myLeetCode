public class LC153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[0] <= nums[mid]) {
                // 说明最小值在mid右侧
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[0];
    }
}
