import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetMaxSalaryTest {
    @Test
    void simpleTestCase() {
        GetMaxSalary getMaxSalary = new GetMaxSalary();
        assertEquals(getMaxSalary.largestNumber(new int[]{3,30,34,5,9}),"9534330");
        assertEquals(getMaxSalary.largestNumber(new int[]{10,2}),"210");
        assertEquals(getMaxSalary.largestNumber(new int[]{0,0}),"0");
    }
}