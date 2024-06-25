public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = nums1.length - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                swap(nums1, m - 1, cur);
                m --;
            } else {
                nums1[cur] = nums2[n - 1];
                n --;
            }
            cur --;
        }
        if (m == 0) {
            while (n > 0) {
                nums1[cur--] = nums2[n-1];
                n --;
            }
        }
    }
    public void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
}
