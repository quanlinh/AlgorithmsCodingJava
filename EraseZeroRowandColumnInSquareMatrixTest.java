import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EraseZeroRowandColumnInSquareMatrixTest {
    @Test
    void testZeroMatrix() {
        int[][] row2By2 = new int[2][2];
        row2By2[0][0] = 1;
        row2By2[0][1] = 0;
        row2By2[1][0] = 1;
        row2By2[1][1] = 1;
        EraseZeroRowandColumnInSquareMatrix er = new EraseZeroRowandColumnInSquareMatrix();
        er.eraseZeroRowAndColumn(row2By2);
        assertEquals(row2By2[0][0],0);
        assertEquals(row2By2[0][1],0);
        assertEquals(row2By2[1][0],1);
        assertEquals(row2By2[1][1],0);
        int[][] row2By3 = new int[2][3];
        er.eraseZeroRowAndColumn(row2By3);
        row2By3[0][0] = 1;
        row2By3[0][1] = 1;
        row2By3[0][2] = 1;
        row2By3[1][0] = 0;
        row2By3[1][1] = 0;
        row2By3[1][2] = 1;
        er.eraseZeroRowAndColumn(row2By3);
        assertEquals(row2By3[0][0],0);
        assertEquals(row2By3[0][1],0);
        assertEquals(row2By3[0][2],1);
        assertEquals(row2By3[1][0],0);
        assertEquals(row2By3[1][1],0);
        assertEquals(row2By3[1][2],0);
    }

    @Test
    void testTranpose() {
        EraseZeroRowandColumnInSquareMatrix erTranpose = new EraseZeroRowandColumnInSquareMatrix();
        int[][] fourBy4 = new int[4][4];
        fourBy4[0][0] = 1;
        fourBy4[0][1] = 2;
        fourBy4[0][2] = 0;
        fourBy4[0][3] = 4;
        fourBy4[1][0] = 3;
        fourBy4[1][1] = 7;
        fourBy4[1][2] = 2;
        fourBy4[1][3] = -1;
        fourBy4[2][0] = 8;
        fourBy4[2][1] = 6;
        fourBy4[2][2] = 11;
        fourBy4[2][3] = 14;
        fourBy4[3][0] = 20;
        fourBy4[3][1] = 18;
        fourBy4[3][2] = 27;
        fourBy4[3][3] = 26;
        erTranpose.tranposeInplaceSquareMatrix(fourBy4);
        assertEquals(fourBy4[0][0],1);
        assertEquals(fourBy4[0][1],3);
        assertEquals(fourBy4[0][2],8);
        assertEquals(fourBy4[0][3],20);
        assertEquals(fourBy4[1][0],2);
        assertEquals(fourBy4[1][1],7);
        assertEquals(fourBy4[1][2],6
        );
        assertEquals(fourBy4[1][3],18
        );
        assertEquals(fourBy4[2][0],0
        );
        assertEquals(fourBy4[2][1],2
        );
        assertEquals(fourBy4[2][2],11
        );
        assertEquals(fourBy4[2][3],27
        );
        assertEquals(fourBy4[3][0],4
        );
        assertEquals(fourBy4[3][1],-1
        );
        assertEquals(fourBy4[3][2],14
        );
        assertEquals(fourBy4[3][3],26
        );

    }

    @Test
    void testRotate() {
        EraseZeroRowandColumnInSquareMatrix er = new EraseZeroRowandColumnInSquareMatrix();
        int[][] fourBy4 = new int[4][4];
        fourBy4[0][0] = 5;
        fourBy4[0][1] = 1;
        fourBy4[0][2] = 9;
        fourBy4[0][3] = 11;
        fourBy4[1][0] = 2;
        fourBy4[1][1] = 4;
        fourBy4[1][2] = 8;
        fourBy4[1][3] = 10;
        fourBy4[2][0] = 13;
        fourBy4[2][1] = 3;
        fourBy4[2][2] = 6;
        fourBy4[2][3] = 7;
        fourBy4[3][0] = 15;
        fourBy4[3][1] = 14;
        fourBy4[3][2] = 12;
        fourBy4[3][3] = 16;
        er.rotate(fourBy4);
        int[][] fourBy4Expected = new int[4][4];
        fourBy4Expected[0][0] = 15;
        fourBy4Expected[0][1] = 13;
        fourBy4Expected[0][2] = 2;
        fourBy4Expected[0][3] = 5;
        fourBy4Expected[1][0] = 14;
        fourBy4Expected[1][1] = 3;
        fourBy4Expected[1][2] = 4;
        fourBy4Expected[1][3] = 1;
        fourBy4Expected[2][0] = 12;
        fourBy4Expected[2][1] = 6;
        fourBy4Expected[2][2] = 8;
        fourBy4Expected[2][3] = 9;
        fourBy4Expected[3][0] = 16;
        fourBy4Expected[3][1] = 7;
        fourBy4Expected[3][2] = 10;
        fourBy4Expected[3][3] = 11;
        assertArrayEquals(fourBy4Expected,fourBy4);
        int[][] fiveBy5 = new int[5][5];
        fiveBy5[0][0] = 1;
        fiveBy5[0][1] = 2;
        fiveBy5[0][2] = 3;
        fiveBy5[0][3] = 4;
        fiveBy5[0][4] = 5;
        fiveBy5[1][0] = 6;
        fiveBy5[1][1] = 7;
        fiveBy5[1][2] = 8;
        fiveBy5[1][3] = 9;
        fiveBy5[1][4] = 10;
        fiveBy5[2][0] = 11;
        fiveBy5[2][1] = 12;
        fiveBy5[2][2] = 13;
        fiveBy5[2][3] = 14;
        fiveBy5[2][4] = 15;
        fiveBy5[3][0] = 16;
        fiveBy5[3][1] = 17;
        fiveBy5[3][2] = 18;
        fiveBy5[3][3] = 19;
        fiveBy5[3][4] = 20;
        fiveBy5[4][0] = 21;
        fiveBy5[4][1] = 22;
        fiveBy5[4][2] = 23;
        fiveBy5[4][3] = 24;
        fiveBy5[4][4] = 25;
        er.rotate(fiveBy5);
        System.out.println(Arrays.toString(fiveBy5[0]));
        System.out.println(Arrays.toString(fiveBy5[1]));
        System.out.println(Arrays.toString(fiveBy5[2]));
        System.out.println(Arrays.toString(fiveBy5[3]));
        System.out.println(Arrays.toString(fiveBy5[4]));
        int[][] fiveBy5Expected = new int[5][5];
        fiveBy5Expected[0][0] = 21;
        fiveBy5Expected[0][1] = 16;
        fiveBy5Expected[0][2] = 11;
        fiveBy5Expected[0][3] = 6;
        fiveBy5Expected[0][4] = 1;
        fiveBy5Expected[1][0] = 22;
        fiveBy5Expected[1][1] = 17;
        fiveBy5Expected[1][2] = 12;
        fiveBy5Expected[1][3] = 7;
        fiveBy5Expected[1][4] = 2;
        fiveBy5Expected[2][0] = 23;
        fiveBy5Expected[2][1] = 18;
        fiveBy5Expected[2][2] = 13;
        fiveBy5Expected[2][3] = 8;
        fiveBy5Expected[2][4] = 3;
        fiveBy5Expected[3][0] = 24;
        fiveBy5Expected[3][1] = 19;
        fiveBy5Expected[3][2] = 14;
        fiveBy5Expected[3][3] = 9;
        fiveBy5Expected[3][4] = 4;
        fiveBy5Expected[4][0] = 25;
        fiveBy5Expected[4][1] = 20;
        fiveBy5Expected[4][2] = 15;
        fiveBy5Expected[4][3] = 10;
        fiveBy5Expected[4][4] = 5;
        assertArrayEquals(fiveBy5,fiveBy5Expected);

        int[][] threeBy3 = new int[3][3];
        er.rotate(threeBy3);
        threeBy3[0][0] = 1;
        threeBy3[0][1] = 2;
        threeBy3[0][2] = 3;
        threeBy3[1][0] = 4;
        threeBy3[1][1] = 5;
        threeBy3[1][2] = 6;
        threeBy3[2][0] = 7;
        threeBy3[2][1] = 8;
        threeBy3[2][2] = 9;
        int[][] threeBy3Expected = new int[3][3];
        threeBy3Expected[0][0] = 7;
        threeBy3Expected[0][1] = 4;
        threeBy3Expected[0][2] = 1;
        threeBy3Expected[1][0] = 8;
        threeBy3Expected[1][1] = 5;
        threeBy3Expected[1][2] = 2;
        threeBy3Expected[2][0] = 9;
        threeBy3Expected[2][1] = 6;
        threeBy3Expected[2][2] = 3;
        int[][] sixBy6 =  new int[6][6];
        sixBy6[0][0] = 2;
        sixBy6[0][1] = 29;
        sixBy6[0][2] = 20;
        sixBy6[0][3] = 26;
        sixBy6[0][4] = 16;
        sixBy6[0][5] = 28;
        sixBy6[1][0] = 12;
        sixBy6[1][1] = 27;
        sixBy6[1][2] = 9;
        sixBy6[1][3] = 25;
        sixBy6[1][4] = 13;
        sixBy6[1][5] = 21;
        sixBy6[2][0] = 32;
        sixBy6[2][1] = 33;
        sixBy6[2][2] = 32;
        sixBy6[2][3] = 2;
        sixBy6[2][4] = 28;
        sixBy6[2][5] = 14;
        sixBy6[3][0] = 13;
        sixBy6[3][1] = 14;
        sixBy6[3][2] = 32;
        sixBy6[3][3] = 27;
        sixBy6[3][4] = 22;
        sixBy6[3][5] = 26;
        sixBy6[4][0] = 33;
        sixBy6[4][1] = 1;
        sixBy6[4][2] = 20;
        sixBy6[4][3] = 7;
        sixBy6[4][4] = 21;
        sixBy6[4][5] = 7;
        sixBy6[5][0] = 4;
        sixBy6[5][1] = 24;
        sixBy6[5][2] = 1;
        sixBy6[5][3] = 6;
        sixBy6[5][4] = 32;
        sixBy6[5][5] = 34;
        er.rotate(sixBy6);
        System.out.println("six by 6 ");
        System.out.println(Arrays.toString(sixBy6[0]));
        System.out.println(Arrays.toString(sixBy6[1]));
        System.out.println(Arrays.toString(sixBy6[2]));
        System.out.println(Arrays.toString(sixBy6[3]));
        System.out.println(Arrays.toString(sixBy6[4]));
        System.out.println(Arrays.toString(sixBy6[5]));
        int[][] sixBy6Expected =  new int[6][6];
        sixBy6Expected[0][0] = 4;
        sixBy6Expected[0][1] = 33;
        sixBy6Expected[0][2] = 13;
        sixBy6Expected[0][3] = 32;
        sixBy6Expected[0][4] = 12;
        sixBy6Expected[0][5] = 2;
        sixBy6Expected[1][0] = 24;
        sixBy6Expected[1][1] = 1;
        sixBy6Expected[1][2] = 14;
        sixBy6Expected[1][3] = 33;
        sixBy6Expected[1][4] = 27;
        sixBy6Expected[1][5] = 29;
        sixBy6Expected[2][0] = 1;
        sixBy6Expected[2][1] = 20;
        sixBy6Expected[2][2] = 32;
        sixBy6Expected[2][3] = 32;
        sixBy6Expected[2][4] = 9;
        sixBy6Expected[2][5] = 20;
        sixBy6Expected[3][0] = 6;
        sixBy6Expected[3][1] = 7;
        sixBy6Expected[3][2] = 27;
        sixBy6Expected[3][3] = 2;
        sixBy6Expected[3][4] = 25;
        sixBy6Expected[3][5] = 26;
        sixBy6Expected[4][0] = 32;
        sixBy6Expected[4][1] = 21;
        sixBy6Expected[4][2] = 22;
        sixBy6Expected[4][3] = 28;
        sixBy6Expected[4][4] = 13;
        sixBy6Expected[4][5] = 16;
        sixBy6Expected[5][0] = 34;
        sixBy6Expected[5][1] = 7;
        sixBy6Expected[5][2] = 26;
        sixBy6Expected[5][3] = 14;
        sixBy6Expected[5][4] = 21;
        sixBy6Expected[5][5] = 28;
        assertArrayEquals(sixBy6Expected,sixBy6);

    }


}