public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] revive = new int[board.length][board[0].length]; // nxm cell
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col ++) {
                int count = countLive(board,row, col);
                if(board[row][col] == 1) {
                    if(count == 2 || count == 3) {
                        revive[row][col] = 1;
                    }
                } else {
                    if(count == 3) {
                        revive[row][col] = 1;
                    }
                }
            }
        }
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                board[row][col] = revive[row][col];
            }
        }
    }

    private int countLive(int[][] board, int row,int col) {
        int count = 0;
        if(row - 1 > -1) {
            count+= board[row-1][col];
            if(col-1 > -1)  count+= board[row-1][col-1];
            if(col+1 < board[row].length)  count+= board[row-1][col+1];
        }
        if(row + 1 < board.length) {
            count += board[row+1][col] ; // 0
            if(col-1 > -1) count+= board[row+1][col-1] ;
            if(col+1 < board[row].length) count+= board[row+1][col+1]; // 0

        }
        if(col-1 > -1 ) count+= board[row][col-1] ;
        if(col+1 < board[row].length) count+= board[row][col+1]; // 1


        return count;
    }

}
