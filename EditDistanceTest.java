import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {
    @Test
    void testOneEditAway() {
        EditDistance editDistance = new EditDistance();
        assertTrue(editDistance.oneEditAway("pale","ple"));
        assertTrue(editDistance.oneEditAway("pales","pale"));
        assertTrue(editDistance.oneEditAway("pale","bale"));
        assertFalse(editDistance.oneEditAway("bake","pale"));
        assertTrue(editDistance.oneEditAway("pale","pale"));
        assertFalse(editDistance.oneEditAway("paleee","pale"));
        assertFalse(editDistance.oneEditAway("pa","pale"));
    }
    @Test
    void testMinimumEditDistance() {
        EditDistance editDistance = new EditDistance();
        assertEquals(editDistance.minimumEditDistance("horse","ros"),3);
        assertEquals(editDistance.minimumEditDistance("intention","execution"),5);
        assertEquals(editDistance.minimumEditDistance("ab","ab"),0);
//        assertEquals(editDistance.minimumEditDistance("horse","ros"),3);
    }
}