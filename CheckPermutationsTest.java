import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPermutationsTest {
    @Test
    void test1()
    {
        CheckPermutations checkPermutations = new CheckPermutations();
        assertTrue(checkPermutations.checkPermutationOfTwoString("abc", "acb"));
        assertTrue(checkPermutations.checkPermutationOfTwoString("abc", "bac"));
        assertTrue(checkPermutations.checkPermutationOfTwoString("abc", "bca"));
        assertTrue(checkPermutations.checkPermutationOfTwoString("abc", "cab"));
        assertTrue(checkPermutations.checkPermutationOfTwoString("abc", "cba"));
        assertFalse(checkPermutations.checkPermutationOfTwoString("abc", "caa"));
        assertFalse(checkPermutations.checkPermutationOfTwoString("abc", "cac"));
        assertFalse(checkPermutations.checkPermutationOfTwoString("abc", "cbb"));
        assertFalse(checkPermutations.checkPermutationOfTwoString("abc", "cbc"));
        assertFalse(checkPermutations.checkPermutationOfTwoString("abc", "aab"));
        // Test permutation by HashMap
        assertTrue(checkPermutations.checkPermutationOfTwoStringUsingHashMap("abc", "acb"));
        assertTrue(checkPermutations.checkPermutationOfTwoStringUsingHashMap("abc", "bac"));
        assertTrue(checkPermutations.checkPermutationOfTwoStringUsingHashMap("abc", "bca"));
        assertTrue(checkPermutations.checkPermutationOfTwoStringUsingHashMap("abc", "cab"));
        assertTrue(checkPermutations.checkPermutationOfTwoStringUsingHashMap("abc", "cba"));
        assertFalse(checkPermutations.checkPermutationOfTwoStringUsingHashMap("abc", "caa"));
        assertFalse(checkPermutations.checkPermutationOfTwoStringUsingHashMap("abc", "cac"));
        assertFalse(checkPermutations.checkPermutationOfTwoStringUsingHashMap("abc", "cbb"));
        assertFalse(checkPermutations.checkPermutationOfTwoStringUsingHashMap("abc", "cbc"));
        assertFalse(checkPermutations.checkPermutationOfTwoStringUsingHashMap("abc", "aab"));
        // Test check permutation using characters
        assertTrue(checkPermutations.checkPermutationUsingChar("abc", "acb"));
        assertTrue(checkPermutations.checkPermutationUsingChar("abc", "bac"));
        assertTrue(checkPermutations.checkPermutationUsingChar("abc", "bca"));
        assertTrue(checkPermutations.checkPermutationUsingChar("abc", "cab"));
        assertTrue(checkPermutations.checkPermutationUsingChar("abc", "cba"));
        assertFalse(checkPermutations.checkPermutationUsingChar("abc", "caa"));
        assertFalse(checkPermutations.checkPermutationUsingChar("abc", "cac"));
        assertFalse(checkPermutations.checkPermutationUsingChar("abc", "cbb"));
        assertFalse(checkPermutations.checkPermutationUsingChar("abc", "cbc"));
        assertFalse(checkPermutations.checkPermutationUsingChar("abc", "aab"));
    }

}