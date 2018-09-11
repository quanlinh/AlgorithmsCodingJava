import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterSortedTest {
    @Test
    void testFrequencyAppears() {
        CharacterSorted characterSorted = new CharacterSorted();
        assertEquals(characterSorted.frequencyString("tree"),"eert");
    }
}