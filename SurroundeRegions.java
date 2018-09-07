public class SurroundeRegions {
/*
    New Ideas, new perception, thanks greekforgreek explanation
 */
    public void solve(char[][] grid) {
        if (grid.length == 0 || grid.length < 3 || grid[0].length < 3) return;
        int numRow = grid.length;
        int numCol = grid[0].length;
        for (int row = 0; row < numRow; row++) {
            for (int col = 0; col < numCol; col++) {
                if (grid[row][col] == 'O') {
                    DFSMarking(grid, row, col, numRow, numCol, '-', 'O');
                }
            }
        }
        // go 4 edges
        // first row
        int col = 0;
        while (col < numCol) {
            DFSMarking(grid, 0, col, numRow, numCol, 'O', '-');
            col++;
        }
        // last row
        col = 0;
        while (col < numCol) {
            DFSMarking(grid, numRow - 1, col, numRow, numCol, 'O', '-');
            col++;
        }
        int row = 0;
        while (row < numRow) {
            DFSMarking(grid, row, 0, numRow, numCol, 'O', '-');
            row++;
        }
        row = 0;
        while (row < numRow) {
            DFSMarking(grid, row, numCol - 1, numRow, numCol, 'O', '-');
            row++;
        }

        for (int newRow = 0; newRow < numRow; newRow++) {
            for (int newCol = 0; newCol < numCol; newCol++) {
                if (grid[newRow][newCol] == '-') {
                    grid[newRow][newCol] = 'X';
                }
            }
        }

    }


    private void DFSMarking(char[][] grid, int row, int col, int numRow, int numCol, char valuSet, char valuChage) {
        if (row < 0 || col < 0 || row >= numRow || col >= numCol || grid[row][col] != valuChage) return;
        grid[row][col] = valuSet;
        DFSMarking(grid, row + 1, col, numRow, numCol, valuSet, valuChage);
        DFSMarking(grid, row - 1, col, numRow, numCol, valuSet, valuChage);
        DFSMarking(grid, row, col + 1, numRow, numCol, valuSet, valuChage);
        DFSMarking(grid, row, col - 1, numRow, numCol, valuSet, valuChage);

    }
}
