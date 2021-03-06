import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindNumberOfIslandTest {
    @Test
    void testSimple() {
        FindNumberOfIsland findNumberOfIsland = new FindNumberOfIsland();
        char[][] a = new char[4][5];
        a[0][0] = '1';
        a[0][1] = '1';
        a[0][2] = '1';
        a[0][3] = '1';
        a[0][4] = '0';

        a[1][0] = '1';
        a[1][1] = '1';
        a[1][2] = '0';
        a[1][3] = '1';
        a[1][4] = '0';

        a[2][0] = '1';
        a[2][1] = '1';
        a[2][2] = '0';
        a[2][3] = '0';
        a[2][4] = '0';

        a[3][0] = '0';
        a[3][1] = '0';
        a[3][2] = '0';
        a[3][3] = '0';
        a[3][4] = '0';
        assertEquals(findNumberOfIsland.numIslands(a),1);
        char[][] twentyByTwenty =     {
                {'1','0','0','1','1','1','0','1','1','0','0','0','0','0','0','0','0','0','0','0'},
                {'1','0','0','1','1','0','0','1','0','0','0','1','0','1','0','1','0','0','1','0'},
                {'0','0','0','1','1','1','1','0','1','0','1','1','0','0','0','0','1','0','1','0'},
                {'0','0','0','1','1','0','0','1','0','0','0','1','1','1','0','0','1','0','0','1'},
                {'0','0','0','0','0','0','0','1','1','1','0','0','0','0','0','0','0','0','0','0'},
                {'1','0','0','0','0','1','0','1','0','1','1','0','0','0','0','0','0','1','0','1'},
                {'0','0','0','1','0','0','0','1','0','1','0','1','0','1','0','1','0','1','0','1'},
                {'0','0','0','1','0','1','0','0','1','1','0','1','0','1','1','0','1','1','1','0'},
                {'0','0','0','0','1','0','0','1','1','0','0','0','0','1','0','0','0','1','0','1'},
                {'0','0','1','0','0','1','0','0','0','0','0','1','0','0','1','0','0','0','1','0'},
                {'1','0','0','1','0','0','0','0','0','0','0','1','0','0','1','0','1','0','1','0'},
                {'0','1','0','0','0','1','0','1','0','1','1','0','1','1','1','0','1','1','0','0'},
                {'1','1','0','1','0','0','0','0','1','0','0','0','0','0','0','1','0','0','0','1'},
                {'0','1','0','0','1','1','1','0','0','0','1','1','1','1','1','0','1','0','0','0'},
                {'0','0','1','1','1','0','0','0','1','1','0','0','0','1','0','1','0','0','0','0'},
                {'1','0','0','1','0','1','0','0','0','0','1','0','0','0','1','0','1','0','1','1'},
                {'1','0','1','0','0','0','0','0','0','1','0','0','0','1','0','1','0','0','0','0'},
                {'0','1','1','0','0','0','1','1','1','0','1','0','1','0','1','1','1','1','0','0'},
                {'0','1','0','0','0','0','1','1','0','0','1','0','1','0','0','1','0','0','1','1'},
                {'0','0','0','0','0','0','1','1','1','1','0','1','0','0','0','1','1','0','0','0'}
        };
        assertEquals(findNumberOfIsland.numIslands(twentyByTwenty),58);
    }


}