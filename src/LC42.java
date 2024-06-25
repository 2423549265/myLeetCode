public class LC42 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                result += leftMax - height[left++];
            } else {
                result += rightMax - height[right--];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new LC42().trap2(height));
    }

    public int trap2(int[] height) {
        return trap2(height, 0);
    }

    public int trap2(int[] height, int leftPos) {
        while (leftPos + 1 < height.length && height[leftPos] <= height[leftPos + 1]) {
            leftPos++;
        }
        int rightPos = leftPos + 1;
        int maxRightPos = -1;
        while (rightPos < height.length && height[rightPos] < height[leftPos]) {
            if (height[rightPos - 1] < height[rightPos]) {
                if (maxRightPos == -1) {
                    maxRightPos = rightPos;
                }
                if (height[rightPos] > height[maxRightPos]) {
                    maxRightPos = rightPos;
                }
            }
            rightPos++;
        }
        if (maxRightPos != -1 || (rightPos < height.length && rightPos > leftPos)) {
            rightPos = Math.max(rightPos, maxRightPos);
            int value = 0;
            int minMax = Math.min(height[leftPos], height[rightPos]);
            for (int i = leftPos + 1; i < rightPos; i++) {
                value = value + (minMax - height[i]) + trap2(height, rightPos);
            }
            return value;
        } else {
            return 0;
        }
    }
}
