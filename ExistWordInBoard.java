public class ExistWordInBoard {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        char[] wordChar = word.toCharArray();
        boolean[][] visited;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    visited = new boolean[board.length][board[0].length];
                    visited[row][col] = true;
                    if (wordInBoard(board, wordChar, row, col, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean wordInBoard(char[][] board, char[] wordChar, int row, int col, int index, boolean[][] visited) {
        if (index == wordChar.length - 1) return true;
        boolean left = false, right = false, up = false, down = false;
        if (row > 0 && wordChar[index + 1] == board[row - 1][col] && !visited[row - 1][col]) {
            visited[row - 1][col] = true;
            up = wordInBoard(board, wordChar, row - 1, col, index + 1, visited);
            if (!up) visited[row - 1][col] = false;
        }
        if (row < board.length - 1 && wordChar[index + 1] == board[row + 1][col] && !visited[row + 1][col]) {
            visited[row + 1][col] = true;
            down = wordInBoard(board, wordChar, row + 1, col, index + 1, visited);
            if (!down) visited[row + 1][col] = false;

        }
        if (col > 0 && wordChar[index + 1] == board[row][col - 1] && !visited[row][col - 1]) {
            visited[row][col - 1] = true;
            left = wordInBoard(board, wordChar, row, col - 1, index + 1, visited);
            if (!left) visited[row][col - 1] = false;
        }
        if (col < board[0].length - 1 && wordChar[index + 1] == board[row][col + 1] && !visited[row][col + 1]) {
            visited[row][col + 1] = true;
            right = wordInBoard(board, wordChar, row, col + 1, index + 1, visited);
            if (!right) visited[row][col + 1] = false;
        }
        return left || right || up || down;
    }

    public boolean existImprovement(char[][] board, String word) {
        if (word.length() == 0) return true;
        char[] wordChar = word.toCharArray();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (wordInBoardImprovement(board, wordChar, row, col, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean wordInBoardImprovement(char[][] board, char[] wordChar, int row, int col, int index) {
        if(index == wordChar.length) return true;
        if(row < 0 || row == board.length  || col < 0 || col == board[row].length) return false;
        if(board[row][col] != wordChar[index]) return false;
        board[row][col] ^= 256;
        boolean exist = wordInBoardImprovement(board,wordChar,row+1,col,index+1) ||
                wordInBoardImprovement(board,wordChar,row-1,col, index+1) ||
                wordInBoardImprovement(board,wordChar,row,col+1, index+1) ||
                wordInBoardImprovement(board,wordChar,row,col-1,index+1);
        board[row][col] ^= 256;
        return exist;

    }
}
