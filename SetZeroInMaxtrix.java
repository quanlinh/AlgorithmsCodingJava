import java.util.ArrayList;

public class SetZeroInMaxtrix {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> rowM = new ArrayList<>();
        ArrayList<Integer> colM = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    rowM.add(row);
                    colM.add(col);
                }
            }
        }
        for (int row : rowM) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = 0;
            }
        }
        for (int col : colM) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }
    }

    public void setZeroesUpgrade(int[][] matrix) {
        boolean isFirstRowHasZero = false;
        boolean isFirstColHasZero = false;
        // check the first row has Zero
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                isFirstRowHasZero = true;
                break;
            }
        }
        // check if the firs col has zero
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                isFirstColHasZero = true;
                break;
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        // set row zero
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < matrix[row].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // set col zero
        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        if (isFirstColHasZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
        if (isFirstRowHasZero) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
    }
}