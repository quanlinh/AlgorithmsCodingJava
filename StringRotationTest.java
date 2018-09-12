import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringRotationTest {
    @Test
    void testStringRotation() {
        StringRotation stringRotation = new StringRotation();
        assertTrue(stringRotation.rotateString("abcde","cdeab"));
        assertTrue(stringRotation.rotateString("gcmbf","fgcmb"));
        assertFalse(stringRotation.rotateString("ohbrwzxvxe","uornhegseo"));
        assertFalse(stringRotation.rotateString("abcde","abced"));
        assertTrue(stringRotation.rotateString("bqqutquvbtgouklsayfvzewpnrbwfcdmwctusunasdbpbmhnvy",
                                               "wpnrbwfcdmwctusunasdbpbmhnvybqqutquvbtgouklsayfvze"));
        assertFalse(stringRotation.rotateString("\"wehicbpaalwdythrncmlwcywbmcgrfbpbosgpccawsdlgleaerengnvbndzhctxhscnxemsxmpyaaulqquyotwpbtfeyqckoknrl\"",
                "\"wehicbpaalwdythrncmlwcywbmcgrfbpbosgpccawsdlgleaerengnvbndzhctxhscnxemsxmpyaaulqquyotwpbtfeyqckoknrl\"\n" +
                        "\"ulaozdidvhyyehimvjflvwmimdytfowrzynrywcyfltcwfuqkvfkhxmwqkzoagdsxtzkpigltkhaqkfcxviflqbnmcilxlgizefm\""));

    }
}