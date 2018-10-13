import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OverLapRectangleTest {
    @Test
    void testOverTopAndRight() {
        OverLapRectangle overLapRectangle = new OverLapRectangle();
        assertFalse(overLapRectangle.isRectangleOverlap(new int[]{0,0,1,1},new int[]{1,0,2,1}));
    }
    @Test
    void testDownAndLeft() {

    }
}