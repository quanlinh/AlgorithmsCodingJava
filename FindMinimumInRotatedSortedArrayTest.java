import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimumInRotatedSortedArrayTest {
    FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
    @Test
    void test1() {
        assertEquals(findMinimumInRotatedSortedArray.findMin(new int[] {1}),1);
    }
    @Test
    void test2() {
        assertEquals(findMinimumInRotatedSortedArray.findMin(new int[] {2,1}),1);

    }@Test
    void test3() {
        assertEquals(findMinimumInRotatedSortedArray.findMin(new int[] {3,4,5,1,2}),1);

    }@Test
    void test4() {
        assertEquals(findMinimumInRotatedSortedArray.findMin(new int[] {3,1,2}),1);

    }@Test
    void test5() {
        assertEquals(findMinimumInRotatedSortedArray.findMin(new int[] {4,5,1,2,3}),1);

    }@Test
    void test6() {
        assertEquals(findMinimumInRotatedSortedArray.findMin(new int[] {1,2}),1);

    }
}