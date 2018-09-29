public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) return nums;
        int[][] newShape = new int[r][c];
        int newRow = 0, newCol = 0;
        for (int row = 0; row < nums.length; row++) {
            for (int col = 0; col < nums[row].length; col++) {
                if (newCol == c) {
                    newRow++;
                    newCol = 0;
                }
                newShape[newRow][newCol++] = nums[row][col];
            }
        }
        return newShape;
    }
}
