import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMatrixAlgorithmTest {

    @Test
    void test0() {
        SpiralMatrixAlgorithm spiralMatrixAlgorithm = new SpiralMatrixAlgorithm();
        List<Integer> res = spiralMatrixAlgorithm.spiralOrder(new int[][]{{7}, {9}, {6}});
        assertTrue(res.get(0) == 7);
        assertTrue(res.get(1) == 9);
        assertTrue(res.get(2) == 6);


    }

    @Test
    void test1() {
        SpiralMatrixAlgorithm spiralMatrixAlgorithm = new SpiralMatrixAlgorithm();
        List<Integer> res3 = spiralMatrixAlgorithm.spiralOrder(new int[][]{{1}});
        assertTrue(res3.get(0) == 1);
    }

    @Test
    void test2() {
        SpiralMatrixAlgorithm spiralMatrixAlgorithm = new SpiralMatrixAlgorithm();
        List<Integer> res1 = spiralMatrixAlgorithm.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8},
                {9, 10, 11, 12}, {13, 14, 15, 16}});
        int[] arrayexpect1 = new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        List<Integer> expRes1 = convertToList(arrayexpect1);
        for (int i = 0; i < expRes1.size(); i++)
            assertEquals(res1.get(i), expRes1.get(i));
    }

    @Test
    void test3() {
        SpiralMatrixAlgorithm spiralMatrixAlgorithm = new SpiralMatrixAlgorithm();
        List<Integer> res = spiralMatrixAlgorithm.spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
                , {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}});
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10,20,19,18,17,16,15,14,13,12,11};
        List<Integer> exp = convertToList(arr);
        for (int i = 0; i < exp.size(); i++)
            assertEquals(res.get(i), exp.get(i));

    }
    private List<Integer> convertToList(int[] arr) {
        List<Integer> expRes1 = new ArrayList<>();
        for (int val : arr) expRes1.add(val);
        return expRes1;
    }
}