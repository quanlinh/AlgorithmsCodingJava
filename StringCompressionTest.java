import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {
    @Test
    void testCompressString() {
        StringCompression stringCompression = new StringCompression();
        assertEquals(stringCompression.stringCompresssion("ab"),"ab");
        assertEquals(stringCompression.stringCompresssion("abc"),"abc");
        assertEquals(stringCompression.stringCompresssion("aa"),"a2");
        assertEquals(stringCompression.stringCompresssion("abb"),"a1b2");
    }

}