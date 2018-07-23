import java.lang.System;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class randomizedQuickSortedTest {

    @Test
    void quickSorted() {
        randomizedQuickSorted randomizedQuickSorted = new randomizedQuickSorted();
        int[] empty = {};
        randomizedQuickSorted.quickSorted(new int[][]{empty});
        assertEquals(empty.length, 0);
        int[] one = {1};
        randomizedQuickSorted.quickSorted(new int[][]{one});
        assertEquals(one.length, 1);
        assertEquals(one[0], 1);
        int[] twoOne = {2, 2, 2, 2, 2, 2, 1};
        randomizedQuickSorted.quickSorted(new int[][]{twoOne});
        int[] twoOneExpect = {1, 2, 2, 2, 2, 2, 2};
        for (int i = 0; i < twoOne.length; i++) {
            assertEquals(twoOne[i], twoOneExpect[i]);
        }

        int[] tenThousands = new int[10000];

        for (int i = 0; i < tenThousands.length; i++) {
            tenThousands[i] = ThreadLocalRandom.current().nextInt(0, 100000);
        }
        int[] copyTenThousands = new int[10000];
        System.arraycopy(tenThousands, 0, copyTenThousands, 0, 10000);
        for (int i = 0; i < 10000; i++) {
            assertEquals(copyTenThousands[i], tenThousands[i]);
        }
        randomizedQuickSorted.quickSorted(new int[][]{tenThousands});
        for (int i = 0; i < tenThousands.length; i++) {
            System.out.println(tenThousands[i]);
        }
    }

    @Test
    void threeWayQuickSorted() {

    }

    @Test
        // Pick up pivots of first element, last element, and the median of medians
    void twoWayQuickSorted() {
        randomizedQuickSorted randomQS = new randomizedQuickSorted();
        String fileName = "/home/qtran/IdeaProjects/AlgorithmsCodingJava/AlgorithmStanford1000IntegersQuickSorted.txt";
        ProcessInputFile processInputFile = new ProcessInputFile(fileName, 10000);
        Integer[] randomArray = processInputFile.getInteger();
        long m = randomQS.twoWayQuickSortedFirstPivot(randomArray, 0, randomArray.length - 1, 0, 0);
        assertEquals(m,162085);
        Integer[] randomArray2 = processInputFile.getInteger();

        long numberOfCompareLastPivotMoveToFist = randomQS.twoWayQuickSortedFirstPivot(randomArray2, 0, randomArray2.length - 1, 0, 1);
        assertEquals(numberOfCompareLastPivotMoveToFist,164123);
        Integer[] randomArray3 = processInputFile.getInteger();
        long numberOfCompareMedianOfThreePivot = randomQS.twoWayQuickSortedFirstPivot(randomArray3, 0, randomArray3.length - 1, 0, 2);
        assertEquals(numberOfCompareMedianOfThreePivot,138382);
        Integer[] smallArray = {2, 20, 1, 15, 3, 11, 13, 6, 16, 10, 19, 5, 4, 9, 8, 14, 18, 17, 7, 12};
        long numberOfCampareMedianOfThreePivot2 = randomQS.twoWayQuickSortedFirstPivot(smallArray, 0, smallArray.length - 1, 0, 2);
        assertEquals(numberOfCampareMedianOfThreePivot2,55);

    }
}