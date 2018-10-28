import java.util.Arrays;
/*
*  Should not use iterator to assign value :(
* */

public class SumOfPathsBoardGame {

    public int numOfPathsToDestDynamic(int n) {
        if(n == 1) return 1;
        int[]  prevRow = new int[n];
        for(int i = 0; i < n; i++) prevRow[i] = 1;
        int[] currRow = new int[n];
        for(int j = 1; j < n; j++) {
            for(int i = j; i < n; i++) {
                if(i == j) {
                    currRow[i] = prevRow[i];
                } else {
                    currRow[i] = prevRow[i] + currRow[i-1];
                }
            }
            prevRow = currRow;
        }
        return currRow[n-1];
    }

    public int uniquePaths(int m, int n) {
        if(m < 0 || n < 0) return 0;
        if(m == 1 || n == 1) return 1;
        int[] prevCol = new int[n];
        for(int i = 0; i < n; i++) {
            prevCol[i] = 1;
        }
        for(int row = 1; row < m; row++) {
            int firstRow = 1;
            for(int col = 1; col < n; col++) {
                firstRow =  firstRow +  prevCol[col];
                prevCol[col] = firstRow;
            }
        }
        return prevCol[n-1];
    }



    static int numOfPathsToDest(int n) {
        if (n == 0) return 0;
        int[][] memorize = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                memorize[row][col] = -1;
            }
        }
        return numOfPathsToDestHelper(n - 1, n - 1, memorize);
    }

    static int numOfPathsToDestHelper(int i, int j, int[][] memorizePath) {
        if (i < 0 || j < 0) return 0;
        else if (i < j) {
            memorizePath[i][j] = 0;
        } else if (memorizePath[i][j] != -1) {
            return memorizePath[i][j];
        } else if (i == 0 && j == 0) {
            memorizePath[i][j] = 1;

        } else {
            memorizePath[i][j] = numOfPathsToDestHelper(i - 1, j, memorizePath) +
                    numOfPathsToDestHelper(i, j - 1, memorizePath);
        }
        return memorizePath[i][j];
    }

    public static void main(String[] args) {
        System.out.println(numOfPathsToDest(1));
        System.out.println(numOfPathsToDest(2));
        System.out.println(numOfPathsToDest(3));
        System.out.println(numOfPathsToDest(4));
        System.out.println(numOfPathsToDest(5));
        System.out.println(numOfPathsToDest(7));
        System.out.println(numOfPathsToDest(10));
        System.out.println(numOfPathsToDest(20));
        SumOfPathsBoardGame sumOfPathsBoardGame  = new SumOfPathsBoardGame();
        System.out.println(sumOfPathsBoardGame.numOfPathsToDestDynamic(1));
        System.out.println(sumOfPathsBoardGame.numOfPathsToDestDynamic(2));
        System.out.println(sumOfPathsBoardGame.numOfPathsToDestDynamic(3));
        System.out.println(sumOfPathsBoardGame.numOfPathsToDestDynamic(4));
        System.out.println(sumOfPathsBoardGame.numOfPathsToDestDynamic(5));
        System.out.println(sumOfPathsBoardGame.numOfPathsToDestDynamic(6));
        System.out.println(sumOfPathsBoardGame.numOfPathsToDestDynamic(7));
        System.out.println(sumOfPathsBoardGame.numOfPathsToDestDynamic(10));
        System.out.println(sumOfPathsBoardGame.numOfPathsToDestDynamic(20));

    }
}
