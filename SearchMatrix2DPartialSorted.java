public class SearchMatrix2DPartialSorted {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[row].length-1;
        while( col > -1 && row < matrix.length) {
            int val = matrix[row][col];
            if(val == target) {return true;}
            else if(target < val) {
                col--;
            } else {
                row++;
            }


            // care full of out of bound
            // if(row == matrix.length) break;
            // col = matrix[row].length-1;
        }
        return false;
    }
}
