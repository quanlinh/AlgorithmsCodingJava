import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SurroundeRegionsTest {
    @Test
    void simpleTestSurroundedRegion() {
//        char[][] a = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        SurroundeRegions surroundeRegions = new SurroundeRegions();
//        surroundeRegions.solve(a);
//        System.out.println(Arrays.toString(a[0]));
//        System.out.println(Arrays.toString(a[1]));
//        System.out.println(Arrays.toString(a[2]));
//        char[][] b = {{'O'}};
//        surroundeRegions.solve(b);
//        System.out.println(Arrays.toString(b[0]));
        char[][] c = {{'O', 'X', 'O'}, {'X', 'O', 'X'}, {'O', 'X', 'O'}};
        surroundeRegions.solve(c);
        System.out.println(Arrays.toString(c[0]));
        System.out.println(Arrays.toString(c[1]));
        System.out.println(Arrays.toString(c[2]));


    }

}