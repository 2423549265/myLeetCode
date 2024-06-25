public class LC79 {
    boolean flag = false;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    search(board, word, 0, i, j);
                    visited[i][j] = false;
                }
            }
        }
        return flag;
    }

    private void search(char[][] board, String word, int curIndex, int row, int col) {
        if (board[row][col] != word.charAt(curIndex)) {
            return;
        } else if (curIndex == word.length() - 1) {
            flag = true;
            return;
        }

        if (row - 1 >= 0 && !visited[row - 1][col]) {
            visited[row - 1][col] = true;
            search(board, word, curIndex + 1, row - 1, col);
            visited[row - 1][col] = false;
        }
        if (row + 1 < board.length && !visited[row + 1][col]) {
            visited[row + 1][col] = true;
            search(board, word, curIndex + 1, row + 1, col);
            visited[row + 1][col] = false;
        }
        if (col - 1 >= 0 && !visited[row][col - 1]) {
            visited[row][col - 1] = true;
            search(board, word, curIndex + 1, row, col - 1);
            visited[row][col - 1] = false;
        }
        if (col + 1 < board[0].length && !visited[row][col + 1]) {
            visited[row][col + 1] = true;
            search(board, word, curIndex + 1, row, col + 1);
            visited[row][col + 1] = false;
        }
    }
}
