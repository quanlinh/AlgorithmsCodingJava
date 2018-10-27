import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedStringMatchTest {
    @Test
    void test1() {
        RepeatedStringMatch repeatedStringMatch = new RepeatedStringMatch();
        // abcabcabc
        //   cabcabca
        assertEquals(repeatedStringMatch.repeatedStringMatch("abc","cabcabca"),4);
    }
}