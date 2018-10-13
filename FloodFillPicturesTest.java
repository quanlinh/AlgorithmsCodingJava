import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloodFillPicturesTest {
    @Test
    void testSameColorNoNeedToFill() {
        FloodFillPictures floodFillPictures = new FloodFillPictures();
        int[][] olcColor = new int[][]{{0,0,0},{0,1,0}};
        assertArrayEquals(floodFillPictures.floodFill(olcColor,1,1,1),olcColor);
    }

}