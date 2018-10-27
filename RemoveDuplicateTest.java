import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicateTest {
    @Test
    void test1() {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        assertEquals(removeDuplicate.removeDuplicates(new int[]{1,1,1,2,2,3}),5);
    }
}