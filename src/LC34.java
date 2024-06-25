public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                for (int i = mid; i >= 0; i--) {
                    if (nums[i] != target) {
                        result[0] = i + 1;
                        break;
                    }
                }
                // 如果数组的第一个元素都等于target特殊处理
                if (nums[0] == target) {
                    result[0] = 0;
                }
                for (int i = mid; i < nums.length; i++) {
                    if (nums[i] != target) {
                        result[1] = i - 1;
                        break;
                    }
                }
                // 如果数组的最后一个元素都等于target特殊处理
                if (nums[nums.length - 1] == target) {
                    result[1] = nums.length - 1;
                }
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
