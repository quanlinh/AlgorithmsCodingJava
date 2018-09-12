import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckUniqueCharactersTest {
    @Test
    void setTest1() {
        CheckUniqueCharacters checkUniqueCharacters = new CheckUniqueCharacters();
        String test1 = "";
        assertTrue(checkUniqueCharacters.isUniqueCharacters(test1));
        assertTrue(checkUniqueCharacters.isUniqueCharacters("abc"));
        assertFalse(checkUniqueCharacters.isUniqueCharacters("aba"));
        // Test with the sorted way that O(nlogn)time
        assertTrue(checkUniqueCharacters.isUniqueCharactersSorted(test1));
        assertTrue(checkUniqueCharacters.isUniqueCharactersSorted("abc"));
        assertFalse(checkUniqueCharacters.isUniqueCharactersSorted("aba"));
        // Test with the HashSet versions
        assertTrue(checkUniqueCharacters.isUniqueCharacterUsingHashSet(test1));
        assertTrue(checkUniqueCharacters.isUniqueCharacterUsingHashSet("abc"));
        assertFalse(checkUniqueCharacters.isUniqueCharacterUsingHashSet("aba"));
    }


}