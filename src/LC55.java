public class LC55 {
    public boolean canJump(int[] nums) {
        // 能跳跃到的最远距离
        int farPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farPosition) {
                return false;
            }
            farPosition = Math.max(farPosition, nums[i] + i);
        }

        return true;
    }
}
