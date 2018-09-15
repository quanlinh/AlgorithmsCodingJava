import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindLuckyDatesTest {
    @Test
    void testSimple() {
        FindLuckyDates findLuckyDates = new FindLuckyDates();
        assertTrue(findLuckyDates.findPrimeDates(2,8,2015,4,9,2025)==5);
    }


}