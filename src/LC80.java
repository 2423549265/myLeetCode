public class LC80 {
    public int removeDuplicates(int[] nums) {
        // cnt记录数字出现次数（只有1，2两个值），len记录当前位置
        int cnt = 1, len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 1) {
                if (nums[i] == nums[len]) {
                    cnt ++;
                }
                nums[++len] = nums[i];
            } else {
                if (nums[i] != nums[len]) {
                    nums[++len] = nums[i];
                    cnt = 1;
                }
            }
        }

        return len + 1;
    }
}
