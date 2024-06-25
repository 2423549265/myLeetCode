public class LC45 {
    public int jump(int[] nums) {
        int result = 0;
        // 某次起跳范围的最远位置
        int farPosition = 0;
        // 某次起跳范围的开始位置
        int curPositon = 0;
        while (farPosition < nums.length - 1){
            // 记录这次起跳范围内的最远跳跃位置
            int tmp = 0;
            for (int i = curPositon; i <= farPosition; i++) {
                tmp = Math.max(tmp, i + nums[i]);
            }
            // 更新下次起跳的范围
            curPositon = farPosition + 1;
            farPosition = tmp;
            result ++;
        }

        return result;
    }
}
