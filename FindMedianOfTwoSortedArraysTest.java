import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMedianOfTwoSortedArraysTest {
    @Test
    void simple()
    {
        FindMedianOfTwoSortedArrays findMedianOfTwoSortedArrays = new FindMedianOfTwoSortedArrays();
        int[] a = {1, 3};
        int[] b = {2};
        double median = findMedianOfTwoSortedArrays.findMedianSortedArrays(a, b);
    }

}