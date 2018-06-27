import java.lang.System;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class randomizedQuickSortedTest {

    @Test
    void quickSorted() {
        randomizedQuickSorted randomizedQuickSorted = new randomizedQuickSorted();
        int[] empty = {};
        randomizedQuickSorted.quickSorted(empty);
        assertEquals(empty.length, 0);
        int[] one = {1};
        randomizedQuickSorted.quickSorted(one);
        assertEquals(one.length, 1);
        assertEquals(one[0], 1);
        int[] twoOne = {2,2,2,2,2,2,1};
        randomizedQuickSorted.quickSorted(twoOne);
        int[] twoOneExpect = {1,2,2,2,2,2,2};
        for(int i = 0; i < twoOne.length; i ++)
        {
            assertEquals(twoOne[i],twoOneExpect[i]);
        }

        int[] tenThousands = new int[10000];

        for(int i = 0; i < tenThousands.length; i++)
        {
            tenThousands[i] = ThreadLocalRandom.current().nextInt(0,100000);
        }
        int[] copyTenThousands = new int[10000];
        System.arraycopy(tenThousands,0,copyTenThousands,0,10000);
        for (int i = 0; i < 10000; i++)
        {
            assertEquals(copyTenThousands[i],tenThousands[i]);
        }
        randomizedQuickSorted.quickSorted(tenThousands);
        for(int i = 0; i < tenThousands.length; i++)
        {
            System.out.println(tenThousands[i]);
        }
    }

    @Test
    void threeWayQuickSorted() {
    }

}