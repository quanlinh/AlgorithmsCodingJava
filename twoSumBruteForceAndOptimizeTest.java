import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class twoSumBruteForceAndOptimizeTest {
    twoSumBruteForceAndOptimize twoSumBruteForceAndOptimize = new twoSumBruteForceAndOptimize();
    int[] case1 = {2, 7, 11, 15};
    int key1 = 9;
    int[] expectValue1 = {0,1};
    int[] empty = {};
    int[] case2  = {-2,8,1,0};
    int key2 = 3;
    int[] expectValue2 = {};
    int[] case3 = {3,2,4};
    int key3 = 6;
    @Test
    void twoSum() {
        int[] case1 = {2, 7, 11, 15};
        int[] value1 = twoSumBruteForceAndOptimize.twoSum(case1,key1);
        assertTrue(value1[0] == 0 && value1[1] == 1);
        int[] emptySum = twoSumBruteForceAndOptimize.twoSum(empty,1);
        assertTrue(emptySum.length == 0);
        int[] value2 = twoSumBruteForceAndOptimize.twoSum(case2,key2);
        System.out.println(Arrays.toString(value2));
        assertTrue(value2.length == 0);

    }

}