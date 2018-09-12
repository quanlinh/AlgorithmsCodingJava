import java.util.ArrayList;

public class SetZeroInMaxtrix {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> rowM = new ArrayList<>();
        ArrayList<Integer> colM = new ArrayList<>();
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]==0) {
                    rowM.add(row);
                    colM.add(col);
                }
            }
        }
        for(int row: rowM) {
            for(int col  = 0; col <  matrix[row].length; col++) {
                matrix[row][col] = 0;
            }
        }
        for(int col: colM) {
            for(int row = 0; row  < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }
    }

}
