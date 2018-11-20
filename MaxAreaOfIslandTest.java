import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxAreaOfIslandTest {
    MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
    @Test
    void testMax3() {
        assertEquals(3,maxAreaOfIsland.maxAreaOfIsland(new int[][]{
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}}));
    }
}