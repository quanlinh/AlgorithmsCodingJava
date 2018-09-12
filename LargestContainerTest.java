import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestContainerTest {
    @Test
    void testSimple() {
        LargestContainer largestContainer = new LargestContainer();
        assertEquals(largestContainer.maxArea(new int[]{1,8,6,2,5,4,8,3,7}),49);
        assertEquals(largestContainer.maxAreaImprove(new int[]{1,8,6,2,5,4,8,3,7}),49);
    }

}