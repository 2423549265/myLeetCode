public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLow = 0, rowHigh = matrix.length - 1;
        int colLow = 0, colHigh = matrix[0].length - 1;

        while (rowLow <= rowHigh) {
            int mid = (rowLow + rowHigh) / 2;
            if (matrix[mid][colHigh] == target) {
                return true;
            } else if (matrix[mid][colHigh] > target) {
                rowHigh = mid - 1;
            } else {
                rowLow = mid + 1;
            }
        }

        if (rowLow == matrix.length) {
            return false;
        }

        while (colLow <= colHigh) {
            int mid = (colLow + colHigh) / 2;
            if (matrix[rowLow][mid] == target) {
                return true;
            } else if (matrix[rowLow][mid] > target) {
                colHigh = mid - 1;
            } else {
                colLow = mid + 1;
            }
        }

        return false;
    }
}
