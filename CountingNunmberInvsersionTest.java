import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CountingNumberInversionTest {
    private final int[] testArray1 = {2, 3, 9, 2, 9 };
    private final int expectInversionsA1 = 2;
    private final int[] testArray2 = {1,3,5,2,4,6};
    private final int expectInversionsA2 = 3;
    private final int[] sortedArray = {1,2,3,4,5,6};
    private final int zero = 0;
    private final int[] emptyArray ={};
    private final CountingNumberInversion countingNumberInversion = new CountingNumberInversion();

    @Test
    void countInversion() {
        assertEquals(expectInversionsA1,countingNumberInversion.countInversion(testArray1));
//        countingNumberInversion.countInversion(testArray2);
        System.out.println(Arrays.toString(testArray2));

        assertEquals(expectInversionsA2,countingNumberInversion.countInversion(testArray2));
        assertEquals(zero,countingNumberInversion.countInversion(sortedArray));
        assertEquals(zero,countingNumberInversion.countInversion(emptyArray));
    }

    @Test
    void testMergeSorted()
    {
        countingNumberInversion.countInversion(testArray2);
        System.out.println(Arrays.toString(testArray2));
//        for(int i = 1; i < testArray2.length; i++) assertTrue(testArray2[i-1] <= testArray2[i]);
//        for(int i = 1; i < sortedArray.length; i++) assertTrue(sortedArray[i-1] <= sortedArray[i]);
        // Test array Even
        int[] evenArray = {5,3,2,1};
        countingNumberInversion.countInversion(evenArray);
        System.out.println("final " +
                Arrays.toString(evenArray));
        for(int i = 1; i < evenArray.length; i++) assertTrue(evenArray[i-1] <= evenArray[i]);

    }

}