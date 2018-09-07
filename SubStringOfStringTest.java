import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubStringOfStringTest {
    @Test
    void simpleTestCase() {
        SubStringOfString subStringOfString = new SubStringOfString();
        assertEquals(subStringOfString.strStr("mississippi","issip"),4);
        assertEquals(subStringOfString.strStr("mississippi","a"),-1);
        assertEquals(subStringOfString.strStr("mississippi","issi"),-1);
        "asdfsaf".indexOf("a");
    }

}