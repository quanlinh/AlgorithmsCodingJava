import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicateLettersTest {
    @Test
    void hardnessTestRemoveWithOrders() {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        assertEquals(removeDuplicateLetters.removeDuplicateLetters("bcabc"),"abc");
        assertEquals(removeDuplicateLetters.removeDuplicateLetters("cbacdcbc"),"acdb");
    }

}