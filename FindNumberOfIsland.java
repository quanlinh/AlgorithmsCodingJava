import java.util.Stack;

public class FindNumberOfIsland {
    // TODO find out how to make the map shrink
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int numIsland = 0;
        int numRow = grid.length;
        int numCol = grid[0].length;
        int[][] visited = new int[numRow][numCol];
        for (int row = 0; row < numRow; row++) {
            for (int col = 0; col < numCol; col++) {
                if ((grid[row][col] == '1') && (visited[row][col] != 1)) {
                    searchIsland(grid,row,col,visited,numRow,numCol);
                    numIsland++;
                }
            }
        }
        return numIsland;

    }

    private void searchIsland(char[][] grid,int row,int col,int[][] visited,int numRow, int numCol) {
        Integer[][] visitedLand = new Integer[1][2];
        visitedLand[0][0] = row;
        visitedLand[0][1] = col;
        Stack<Integer[][]> stackVisited = new Stack<>();
        stackVisited.push(visitedLand);
        while (!stackVisited.isEmpty()) {
            Integer[][] rowColInt = stackVisited.pop();
            int rowInside = rowColInt[0][0];
            int colInside = rowColInt[0][1];
            if (visited[rowInside][colInside] == 1) continue;
            visited[rowInside][colInside] = 1;
            int upRow = rowInside - 1, downRow = rowInside + 1, leftCol = colInside - 1, rightCol = colInside + 1;
            if (downRow < numRow && grid[downRow][colInside] == '1') {
                if (visited[downRow][colInside] != 1) {
                    Integer[][] visitedLand1 = new Integer[1][2];
                    visitedLand1[0][0] = downRow;
                    visitedLand1[0][1] = colInside;
                    stackVisited.push(visitedLand1);
                }
            }
            if (upRow >= 0 && grid[upRow][colInside] == '1') {
                if (visited[upRow][colInside] != 1) {
                    Integer[][] visitedLand2 = new Integer[1][2];
                    visitedLand2[0][0] = upRow;
                    visitedLand2[0][1] = colInside;
                    stackVisited.push(visitedLand2);
                }
            }

            if (leftCol >= 0 && grid[rowInside][leftCol] == '1') {
                if (visited[rowInside][leftCol] != 1) {
                    Integer[][] visitedLand3 = new Integer[1][2];
                    visitedLand3[0][0] = rowInside;
                    visitedLand3[0][1] = leftCol;
                    stackVisited.push(visitedLand3);
                }
            }

            if (rightCol < numCol && grid[rowInside][rightCol] == '1') {
                if (visited[rowInside][rightCol] != 1) {
                    Integer[][] visitedLand4 = new Integer[1][2];
                    visitedLand4[0][0] = rowInside;
                    visitedLand4[0][1] = rightCol;
                    stackVisited.push(visitedLand4);
                }
            }
        }

    }
}
