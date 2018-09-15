import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonotoneIncreasingDigitsTest {

    @Test
    void testMonotoneIncreasing() {
        MonotoneIncreasingDigits monotoneIncreasingDigits  = new MonotoneIncreasingDigits();
        assertEquals(299, monotoneIncreasingDigits.monotoneIncreasingDigitsBrutalForce(963856657));
        assertEquals(899999999, monotoneIncreasingDigits.monotoneIncreasingDigits(963856657));
        assertEquals(1234, monotoneIncreasingDigits.monotoneIncreasingDigits(1234));
        assertEquals(9, monotoneIncreasingDigits.monotoneIncreasingDigits(10));
    }

}