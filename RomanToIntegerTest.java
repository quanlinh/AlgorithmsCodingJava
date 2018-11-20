import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {
    private RomanToInteger romanToInteger = new RomanToInteger();

    @Test
    void testDifferentDigit() {
        assertEquals(romanToInteger.romanToIntImprove("XV"), 15);
        assertEquals(romanToInteger.romanToIntImprove("XX"), 20);
        assertEquals(romanToInteger.romanToIntImprove("MV"), 1005);
    }

    @Test
    void testSubTraction() {
        assertEquals(romanToInteger.romanToIntImprove("IX"), 9);
        assertEquals(romanToInteger.romanToIntImprove("IM"), 999);
    }
    void testCombineSubTraction() {
        assertEquals(romanToInteger.romanToIntImprove("XIV"),19);
        assertEquals(romanToInteger.romanToIntImprove("XIX"),19);
    }

    @Test
    void testInvalid() {
//        Executable closureContaintingCodeToTest = () -> throw new IllegalArgumentException("wrong roman number");
//        assertThrows(IllegalArgumentException.class, closureContaintingCodeToTest, "wrong roman number");
//        assertEquals(romanToInteger.romanToIntImprove("VX"),14);
//        assertEquals(romanToInteger.romanToIntImprove("XXC"),14);

    }

    @Test
    void testSingleDigit() {
        assertEquals(romanToInteger.romanToIntImprove("I"),1);
    }
    @Test
    void testMultipleDigit() {
        assertEquals(romanToInteger.romanToIntImprove("II"),2);
        assertEquals(romanToInteger.romanToIntImprove("III"),3);
    }

}