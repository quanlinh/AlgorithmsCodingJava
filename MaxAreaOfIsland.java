public class MaxAreaOfIsland {
    /*
    * The tricky things about this problems is we count each of them as 1
    * And we have to set the value of that row and col to 0, so we don't count
    * it any more
    * If, we are not allow to change, we can still do it by increase the number
    * to 2. Then reset it afterwards.
    * The Space is O(row*col) of the matrix
    * The time is O(N) because we only visited the matrix once.
    * */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    maxArea = Math.max(maxArea,countArea(grid,row,col,0));
                }
            }
        }
        return maxArea;
    }

    private int countArea(int[][] grid,int row,int col,int count) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[row].length) return 0;
        grid[row][col] = 0;
        // up
        count += 1;
        if (row > 0 && grid[row - 1][col] == 1) {
            count += countArea(grid,row - 1,col,0);
        }
        // down
        if (row < grid.length - 1 && grid[row + 1][col] == 1) {
            count += countArea(grid,row + 1,col,0);
        }
        // left
        if (col > 0 && grid[row][col - 1] == 1) {
            count += countArea(grid,row,col - 1,0);
        }
        // right
        if (col < grid[row].length - 1 && grid[row][col + 1] == 1) {
            count += countArea(grid,row,col + 1,0);
        }
        return count;
    }
}
