import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixAlgorithm {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while ((left <= right) && (up <= down)) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            if (up == down) break;
            up++;
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (left == right) break;
            right--;
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
