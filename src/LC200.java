public class LC200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count ++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (grid[row][col] == '1') {
            grid[row][col] = '2';
        } else {
            return;
        }

        if (isLegal(row - 1, col, grid.length, grid[0].length)) {
            dfs(grid, row - 1, col);
        }
        if (isLegal(row + 1, col, grid.length, grid[0].length)) {
            dfs(grid, row + 1, col);
        }
        if (isLegal(row, col - 1, grid.length, grid[0].length)) {
            dfs(grid, row, col - 1);
        }
        if (isLegal(row, col + 1, grid.length, grid[0].length)) {
            dfs(grid, row, col + 1);
        }
    }

    private boolean isLegal(int row, int col, int rowLen, int colLen) {
        if (row >= 0 && row < rowLen && col >= 0 && col < colLen) {
            return true;
        }
        return false;
    }
}
