import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubsequenceTwoDistinctCharacterTest {
    private MaximumSubsequenceTwoDistinctCharacter mx = new MaximumSubsequenceTwoDistinctCharacter();
    @Test
    void test1() {
        assertEquals(mx.lengthOfLongestSubstringTwoDistinct("eceba"), 3);
        assertEquals(mx.lengthOfLongestSubstringTwoDistinct("ccaabbb"), 5);
    }

}