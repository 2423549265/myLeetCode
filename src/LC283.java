public class LC283 {
    public void moveZeroes(int[] nums) {
        int noneZeroPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[noneZeroPos++] = nums[i];
            }
        }
        while (noneZeroPos < nums.length) {
            nums[noneZeroPos++] = 0;
        }
    }
}
