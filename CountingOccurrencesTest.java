import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

class CountingOccurrencesTest {
    private CountingOccurrences countingOccurrences = new CountingOccurrences();
    private int[] array1;
    private int expectLeftIndex2;
    private int expectRightIndex2;
    private int expectNumberOccurrences2;
    private int expectLeftIndex3;
    private int expectRightIndex3;
    private int expectNumberOccurrences3;
    private int expectLeftIndex1;
    private int expectRightIndex1;
    private int expectNumberOccurrences1;
    private int expectLeftIndex4;
    private int expectRightIndex4;
    private int expectNumberOccurrences4;
    private int expectLeftIndex5;
    private int expectRightIndex5;
    private int expectNumberOccurrences5;
    private int[] array2;
    private int outOfRange2;
    private int[] expectRange2And6;
    private int[] oneElement;
    private int[] expectOneElement;
    private int oneElementTarget;

    @BeforeEach
    void setUp() {
        expectLeftIndex2 = 0;
        expectRightIndex2 = 4;
        expectNumberOccurrences2 = 3;
        expectLeftIndex3 = 3;
        expectRightIndex3 = 8;
        expectNumberOccurrences3 = 4;
        expectLeftIndex1 = -1;
        expectRightIndex1 = 1;
        expectNumberOccurrences1 = 1;
        expectLeftIndex4 = 7;
        array1 = new int[]{1,2,2,2,3,3,3,3,4,5};
        expectRightIndex4 = 9;
        expectNumberOccurrences4 = 1;
        expectLeftIndex5 = 8;
        expectRightIndex5 = 10;
        expectNumberOccurrences5 = 1;
        array2 = new int[]{5,7,7,8,8,10};
        outOfRange2 = 6;
        expectRange2And6 = new int[]{-1,-1};
        oneElement = new int[]{1};
        expectOneElement = new int[]{0,0};
        oneElementTarget = 1;
    }

    @Test
    void testOccurrences() {
        assert (expectNumberOccurrences1 == countingOccurrences.numberOfOccurrences(array1,1));
        assert (expectNumberOccurrences2 == countingOccurrences.numberOfOccurrences(array1,2));
        assert (expectNumberOccurrences3 == countingOccurrences.numberOfOccurrences(array1,3));
        assert (expectNumberOccurrences4 == countingOccurrences.numberOfOccurrences(array1,4));
        assert (expectNumberOccurrences5 == countingOccurrences.numberOfOccurrences(array1,5));


    }

    @Test
    void testRightIndex() {
        assert (expectRightIndex1 == countingOccurrences.searchRightIndex(array1,1,0,array1.length - 1));
        assert (expectRightIndex2 == countingOccurrences.searchRightIndex(array1,2,0,array1.length - 1));
        assert (expectRightIndex3 == countingOccurrences.searchRightIndex(array1,3,0,array1.length - 1));
        assert (expectRightIndex4 == countingOccurrences.searchRightIndex(array1,4,0,array1.length - 1));
        assert (expectRightIndex5 == countingOccurrences.searchRightIndex(array1,5,0,array1.length - 1));


    }

    @Test
    void testLeftIndex() {
        assert (expectLeftIndex1 == countingOccurrences.searchLeftIndex(array1,1,0,array1.length - 1));
        assert (expectLeftIndex2 == countingOccurrences.searchLeftIndex(array1,2,0,array1.length - 1));
        assert (expectLeftIndex3 == countingOccurrences.searchLeftIndex(array1,3,0,array1.length - 1));
        assert (expectLeftIndex4 == countingOccurrences.searchLeftIndex(array1,4,0,array1.length - 1));
        assert (expectLeftIndex5 == countingOccurrences.searchLeftIndex(array1,5,0,array1.length - 1));
    }

    @Test
    void testRangeIndexOccurrences()
    {
        int[] rs1 = countingOccurrences.rangeSearch(array2,outOfRange2);
        assert (rs1[0] == expectRange2And6[0]);
        assert (rs1[1] == expectRange2And6[1]);
        int[] rs2 = countingOccurrences.rangeSearch(oneElement,oneElementTarget);
        assert (rs2[0] == expectOneElement[0]);
        assert (rs2[1] == expectOneElement[1]);

    }
}