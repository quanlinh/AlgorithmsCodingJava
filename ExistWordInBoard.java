public class ExistWordInBoard {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        boolean[][] visited;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    visited = new boolean[board.length][board[0].length];
                    visited[row][col] = true;
                    if (wordInBoard(board, word, row, col, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean wordInBoard(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length() - 1) return true;
        boolean left = false, right = false, up = false, down = false;
        if (row > 0 && word.charAt(index + 1) == board[row - 1][col] && !visited[row - 1][col]) {
            visited[row - 1][col] = true;
            up = wordInBoard(board, word, row - 1, col, index + 1, visited);
            if (!up) visited[row - 1][col] = false;
        }
        if (row < board.length - 1 && word.charAt(index + 1) == board[row + 1][col] && !visited[row + 1][col]) {
            visited[row + 1][col] = true;
            down = wordInBoard(board, word, row + 1, col, index + 1, visited);
            if (!down) visited[row + 1][col] = false;

        }
        if (col > 0 && word.charAt(index + 1) == board[row][col - 1] && !visited[row][col - 1]) {
            visited[row][col - 1] = true;
            left = wordInBoard(board, word, row, col - 1, index + 1, visited);
            if(!left) visited[row][col-1] = false;
        }
        if (col < board[0].length - 1 && word.charAt(index + 1) == board[row][col + 1] && !visited[row][col + 1]) {
            visited[row][col + 1] = true;
            right = wordInBoard(board, word, row, col + 1, index + 1, visited);
            if(!right) visited[row][col+1] = false;
        }
        return left || right || up || down;
    }
}
