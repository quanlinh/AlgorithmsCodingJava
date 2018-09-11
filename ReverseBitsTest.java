import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseBitsTest {
    @Test
    void testSimple() {
        ReverseBits reverseBits = new ReverseBits();
        reverseBits.reverseBits(43261596);
    }

}