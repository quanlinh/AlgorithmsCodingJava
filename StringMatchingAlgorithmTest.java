import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMatchingAlgorithmTest {
    @Test
    void testStringMatchingBoyerMoore() {
        StringMatchingAlgorithm anagramDictionary = new StringMatchingAlgorithm();
        assertTrue(anagramDictionary.isSubString("findinhaystackneedle","needle"));
        assertFalse(anagramDictionary.isSubString("nonstop","post"));
        assertTrue(anagramDictionary.isSubString("poster","post"));
        assertTrue(anagramDictionary.isSubString("lamp post","post"));
        assertFalse(anagramDictionary.isSubString("spots","post"));
        assertTrue(anagramDictionary.isSubString("apostrophe","post"));
        for (int c = 97; c <= 122; c++) {
            System.out.println(Character.toLowerCase((char)c));
        }    }


}