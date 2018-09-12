import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {
    @Test
    void testSimple() {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] a = {1,2,3,4,7};
        int[] b = {0,5,6,9};
        assertEquals(medianOfTwoSortedArrays.findTheMedianOfTwoSortedArrays(a,b),4.0);
        int[] c = {1,3};
        int[] d = {2};
        int[] e = {1,2};
        int[] f = {3,4};
        assertEquals(medianOfTwoSortedArrays.findTheMedianOfTwoSortedArrays(e,f),2.5);
        assertEquals(medianOfTwoSortedArrays.findTheMedianOfTwoSortedArrays(new int[]{},new int[]{1}),1.0);
        assertEquals(medianOfTwoSortedArrays.findTheMedianOfTwoSortedArrays(new int[]{3},new int[]{-2,-1}),-1.0);
    }
}