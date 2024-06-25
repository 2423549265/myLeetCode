public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[10][10], col = new boolean[10][10], area = new boolean[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                int u = c - '0';
                int index = i / 3 * 3 + j / 3;
                if (row[i][u] || col[j][u] || area[index][u])
                    return false;
                row[i][u] = col[j][u] = area[index][u] = true;
            }
        }
        return true;
    }
}
