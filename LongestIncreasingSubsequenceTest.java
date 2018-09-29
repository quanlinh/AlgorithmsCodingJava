import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceTest {
    @Test
    void testLongestDynamic()
    {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] empty = {};
        assertEquals(lis.findLongestIncreasingSubsequence(empty),0);
        int[] one = {1};
        assertEquals(lis.findLongestIncreasingSubsequence(one),1);
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        assertEquals(lis.findLongestIncreasingSubsequence(a),4);
        int[] two = {2, 2};
        assertEquals(lis.findLongestIncreasingSubsequence(two), 1);
        int[] twoDifferent = {-2, -1};
        assertEquals(lis.findLongestIncreasingSubsequence(twoDifferent) ,2);
        int [] b = {7, 2, 8, 1, 3, 4, 10, 6, 9, 5};
        int [] expected_b = {1, 3, 4, 6, 9};
        assertEquals(lis.findLongestIncreasingSubsequence(b), expected_b.length);

    }
    @Test
    void testLongestIncreasingSubsequenceBinarySearchPatienceSorted()
    {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] empty = {};
        assertEquals(lis.findLongestIncreasingSubSequencesByPatienceSorted(empty).size(),0);
        int[] one = {1};
        assertEquals(lis.findLongestIncreasingSubSequencesByPatienceSorted(one).size(),1);
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int [] b = {7, 2, 8, 1, 3, 4, 10, 6, 9, 5};
        int [] expected_b = {1, 3, 4, 6, 9};
        assertEquals(lis.findLongestIncreasingSubSequencesByPatienceSorted(b).size(), expected_b.length);
        int[] two = {2,2};
        assertEquals(lis.findLongestIncreasingSubSequencesByPatienceSorted(a).size(),4);
        assertEquals( lis.findLongestIncreasingSubSequencesByPatienceSorted(two).size(),1);
        int[] twoDifferent = {-2, -1};
        assertEquals(lis.findLongestIncreasingSubSequencesByPatienceSorted(twoDifferent).size(),2);
        int[] c = {18, 55, 66, 2, 3, 54};
        assertEquals(lis.findLongestIncreasingSubSequencesByPatienceSorted(c).size(), 3);
        int [] d = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        assertEquals(lis.findLongestIncreasingSubSequencesByPatienceSorted(d).size(), 6);
//        int[] expected_d = {1, 3, 6, 7, 9, 10};
    }
    @Test
    void testTheOptimalSpaceVersion() {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        longestIncreasingSubsequence.lenthOFLongestIncreasingSubsequenceOptimalSpace(new int[] {0,8,4,2,12});
    }

}