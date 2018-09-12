import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomeSortedStringsTest {
    @Test
    void testSimpleCustomSortedStrings() {
        CustomeSortedStrings customeSortedStrings = new CustomeSortedStrings();
        assertEquals(customeSortedStrings.customSortString("cba", "abcd"),"cbad");
    }

}