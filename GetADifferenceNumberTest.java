import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetADifferenceNumberTest {
    GetADifferenceNumber getADifferenceNumber = new GetADifferenceNumber();
    @Test
    void test1() {
        assertEquals(getADifferenceNumber.getIndexOfSmallestNumber(new int[]{100000}),0);
    }

}