import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerCalculationTest {
    @Test
    void testPower() {
        PowerCalculation powerCalculation = new PowerCalculation();
        assertEquals(powerCalculation.myPow(2.00000,-2147483648),0.0);
        assertEquals(powerCalculation.myPow(2.00000,-2),0.25);
//        assertEquals(powerCalculation.myPow(-13.62608,3),-2529.95504);

//        System.out.println(-(long)(Integer.MIN_VALUE));
    }
}