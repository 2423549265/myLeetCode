public class LC274 {
    public int hIndex(int[] citations) {
        // 记录引用次数所对应的文章数
        int[] cnt = new int[citations.length + 1];

        for (int citation : citations) {
            if (citation > citations.length) {
                cnt[citations.length] ++;
            } else {
                cnt[citation] ++;
            }
        }

        // 累加引用次数大于i的文章数量
        int num = 0;
        // 倒着遍历
        for (int i = citations.length; i >= 0; i--) {
            num += cnt[i];
            if (num >= i) {
                return i;
            }
        }

        return 0;
    }
}
