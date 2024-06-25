import java.util.ArrayDeque;
import java.util.Deque;

public class LC994 {
    public int orangesRotting(int[][] grid) {
        int res = 0;
        int cnt = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    cnt ++;
                }
            }
        }

        while (cnt > 0 && !deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] poll = deque.poll();
                if (isLegal(poll[0] - 1, poll[1], grid.length, grid[0].length) && grid[poll[0] - 1][poll[1]] == 1) {
                    grid[poll[0] - 1][poll[1]] = 2;
                    cnt --;
                    deque.offer(new int[]{poll[0] - 1, poll[1]});
                }
                if (isLegal(poll[0] + 1, poll[1], grid.length, grid[0].length) && grid[poll[0] + 1][poll[1]] == 1) {
                    grid[poll[0] + 1][poll[1]] = 2;
                    cnt --;
                    deque.offer(new int[]{poll[0] + 1, poll[1]});
                }
                if (isLegal(poll[0], poll[1] - 1, grid.length, grid[0].length) && grid[poll[0]][poll[1] - 1] == 1) {
                    grid[poll[0]][poll[1] - 1] = 2;
                    cnt --;
                    deque.offer(new int[]{poll[0], poll[1] - 1});
                }
                if (isLegal(poll[0], poll[1] + 1, grid.length, grid[0].length) && grid[poll[0]][poll[1] + 1] == 1) {
                    grid[poll[0]][poll[1] + 1] = 2;
                    cnt --;
                    deque.offer(new int[]{poll[0], poll[1] + 1});
                }
            }
            res ++;
        }

        return cnt > 0? -1 : res;
    }

    private boolean isLegal(int row, int col, int rowLen, int colLen) {
        if (row >= 0 && row < rowLen && col >= 0 && col < colLen) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LC994 lc994 = new LC994();
        lc994.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
    }
}
