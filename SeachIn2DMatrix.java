public class SeachIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return binarySearchMatrix(matrix, 0, matrix.length * matrix[0].length - 1, matrix[0].length, target);
    }

    private boolean binarySearchMatrix(int[][] matrix, int lo, int hi, int numCol, int target) {
        if (lo > hi) return false;
        int mid = (lo + hi) >>> 1;
        int valMid = matrix[mid / numCol][mid % numCol];

        if (target < valMid) return binarySearchMatrix(matrix, lo, mid - 1, numCol, target);
        else if (target > valMid)
            return binarySearchMatrix(matrix, mid + 1, hi, numCol, target);
        else return true;
    }

    private boolean binarySearchMatrixIterative(int[][] matrix, int lo, int hi, int numCol, int target) {
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int valMid = matrix[mid / numCol][mid % numCol];
            if (target < valMid)
                hi = mid - 1;
            else if (target > valMid) {
                lo = mid + 1;
            } else return true;
        }
        return false;
    }
}
