import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class IsophomicStringsTest {
    IsophomicStrings isophomicStrings = new IsophomicStrings();

    @Test
    void testEdgeCase() {
        assertFalse(isophomicStrings.isIsomorphic("abba","abab"));
    }
}