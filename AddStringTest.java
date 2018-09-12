import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddStringTest {
    @Test
    void testAddTwoNumberWithString() {
        AddString addString = new AddString();
        System.out.println(addString.addStrings("99999999","11111111"));
        assertEquals(addString.addStrings("99999999","11111111"),Integer.toString(99999999 + 11111111));
    }

}