import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagStringConversionTest {
    private ZigZagStringConversion zigZagStringConversion = new ZigZagStringConversion();
    @Test
    void testSimple() {
        assertEquals(zigZagStringConversion.convert("PAYPALISHIRING",3),"PAHNAPLSIIGYIR");
        assertEquals(zigZagStringConversion.convert("PAYPALISHIRING",4),"PINALSIGYAHRPI");
    }

}