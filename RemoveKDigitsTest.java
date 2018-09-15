import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveKDigitsTest {
    @Test
    void simpleTest() {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        assertEquals(removeKDigits.removeKDigits("1432219", 3), "1219");
        assertEquals(removeKDigits.removeKDigits("10200", 1), "200");
        assertEquals(removeKDigits.removeKDigits("10", 2), "0");
        assertEquals(removeKDigits.removeKDigits("10", 1), "0");



    }
    @Test
    void simpleTestImprove() {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        assertEquals(removeKDigits.buildTheLowestNumber("1432219", 3), "1219");
        assertEquals(removeKDigits.buildTheLowestNumber("10200", 1), "200");
        assertEquals(removeKDigits.buildTheLowestNumber("10", 2), "0");
        assertEquals(removeKDigits.buildTheLowestNumber("10", 1), "0");



    }


}