import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoundNumberNotInPairTest {

    @Test
    void testFoundNumberNotInPair() {
        FoundNumberNotInPair foundNumberNotInPair = new FoundNumberNotInPair();
        assertTrue(foundNumberNotInPair.foundNumberNotInPair(new int[] {1,1,2})==2);
        assertTrue(foundNumberNotInPair.foundNumberNotInPair(new int[] {1,1,2,3,3})==2);
        assertTrue(foundNumberNotInPair.foundNumberNotInPair(new int[] {1,1,2,2,3,4,4})==3);
        assertTrue(foundNumberNotInPair.foundNumberNotInPair(new int[] {1,1,2,2,3,3,4,4,5})==5);
        assertTrue(foundNumberNotInPair.foundNumberNotInPair(new int[] {1,2,2})==1);
        assertTrue(foundNumberNotInPair.foundNumberNotInPair(new int[] {1})==1);
    }
}