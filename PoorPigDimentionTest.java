import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoorPigDimentionTest {
    @Test
    void testSimple() {
        PoorPigDimention poorPigDimention = new PoorPigDimention();
       assertEquals( poorPigDimention.poorPigs(1000,15,60),5);
    }
    @Test
    void testEdgeCases() {
        PoorPigDimention poorPigDimention = new PoorPigDimention();
        assertEquals( poorPigDimention.poorPigs(1,1,1),0);
    }

}