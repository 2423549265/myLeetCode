public class LC407 {
    public int trapRainWater(int[][] heightMap) {
        int[][] maxMap = new int[heightMap.length][heightMap[0].length];
        for (int i = 1; i < heightMap.length - 1; i++) {
            int left = 0, right = heightMap[0].length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(heightMap[i][left], leftMax);
                rightMax = Math.max(heightMap[i][right], rightMax);
                if (leftMax < rightMax) {
                    maxMap[i][left++] = leftMax;
                } else {
                    maxMap[i][right--] = rightMax;
                }
            }
        }
        for (int j = 1; j < heightMap[0].length - 1; j++) {
            int front = 0, back = heightMap.length - 1;
            int frontMax = 0, backMax = 0;
            while (front < back) {
                frontMax = Math.max(heightMap[front][j], frontMax);
                backMax = Math.max(heightMap[back][j], backMax);
                if (frontMax < backMax) {
                    maxMap[front++][j] = Math.min(frontMax, maxMap[front++][j]);
                } else {
                    maxMap[back--][j] = Math.min(backMax, maxMap[back--][j]);
                }
            }
        }
        int result = 0;
        for (int i = 1; i < heightMap.length - 1; i++) {
            for (int j = 1; j < heightMap[0].length - 1; j++) {
                result += maxMap[i][j] - heightMap[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new LC407().trapRainWater(new int[][]{{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}});
    }
}
