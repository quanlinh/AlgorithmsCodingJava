import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddDigitsTest {
    @Test
    void testPlusOneDigits() {
        AddDigits addDigits = new AddDigits();
        int[] nine = {9};
        int[] nineExpected = {1,0};
        int[] nineReal = addDigits.plusOne(nine);
        assertArrayEquals(nineExpected,nineReal);
        int[] eight9 = {8,9,9,9,9,9};
        int[] eight9Expected = {9,0,0,0,0};
        int[] eight9Real = addDigits.plusOne(eight9);
        assertArrayEquals(eight9Expected, eight9Real);
    }

}