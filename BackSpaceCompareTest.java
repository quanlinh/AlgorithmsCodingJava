import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackSpaceCompareTest {
    private BackSpaceCompare backSpaceCompare = new BackSpaceCompare();

    @Test
    void test1() {
        assertTrue(backSpaceCompare.backspaceCompare("ab#c", "ad#c"));
    }
    @Test
    void test2() {
        assertTrue(backSpaceCompare.backspaceCompare("ab##", "c#d#"));
    }
    @Test
    void test3() {
        assertTrue(backSpaceCompare.backspaceCompare("xywrrmp", "xywrrmu#p"));
    }
    @Test
    void test4() {
        assertTrue(backSpaceCompare.backspaceCompare("bxj##tw", "bxo#j##tw"));
    }

}