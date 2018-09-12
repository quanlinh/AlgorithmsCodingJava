public class EraseZeroRowandColumnInSquareMatrix {
    public void eraseZeroRowAndColumn(int[][] squareMatrix) {
        int numRow = squareMatrix.length;
        int numCol = squareMatrix[0].length;
        System.out.println(numCol + " col");
        System.out.println(numRow + " row");
        boolean[] rowB = new boolean[numRow];
        boolean[] colB = new boolean[numCol];
        for (int row = 0; row < numRow; row++) {
            for (int col = 0; col < numCol; col++) {
                if (squareMatrix[row][col] == 0) {
                    rowB[row] = true;
                    colB[col] = true;
                }
            }
        }
        for (int row = 0; row < numRow; row++) {
            if (rowB[row]) {
                setZeroRow(squareMatrix,row);
            }
        }
        for (int col = 0; col < numCol; col++) {
            if (colB[col]) {
                setZeroCol(squareMatrix,col);

            }
        }
    }

    private void setZeroCol(int[][] squareMatrix,int col) {
        for (int i = 0; i < squareMatrix.length; i++) {
            squareMatrix[i][col] = 0;
        }
    }

    private void setZeroRow(int[][] squareMatrix,int row) {
        for (int i = 0; i < squareMatrix[0].length; i++) {
            squareMatrix[row][i] = 0;
        }
    }

    // tranpose a matrix
    public int[][] tranposeNotInplace(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] B = new int[row][col];
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int colIndex = 0; colIndex < col; colIndex++) {
                B[colIndex][rowIndex] = A[rowIndex][colIndex];
            }
        }
        return B;
    }

    public void tranposeInplaceSquareMatrix(int[][] squareMatrix) {
        int N = squareMatrix.length;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (col <= row) continue;
                int temp = squareMatrix[row][col];
                squareMatrix[row][col] = squareMatrix[col][row];
                squareMatrix[col][row] = temp;
            }
        }
    }

    public void rotate(int[][] matrix) {
        int lastCol = matrix.length - 1, lastRow = matrix.length - 1, firstRow = 0, firstCol = 0, i = 0;
        while (firstRow < lastRow && firstCol < lastCol ) {
            int temp = matrix[firstRow][firstCol + i];
            matrix[firstRow][firstCol + i] = matrix[lastRow - i][firstCol];
            matrix[lastRow - i][firstCol] = matrix[lastRow][lastCol - i];
            matrix[lastRow][lastCol - i] = matrix[firstRow + i][lastCol];
            matrix[firstRow + i][lastCol] = temp;
            i++;
            if (firstRow + i == lastRow) {
                firstRow++;
                lastRow--;
                firstCol++;
                lastCol--;
                i = 0;
            }
        }

    }
}
