import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTrieTest {
    @Test
    void testSimpleTrie() {
        SimpleTrie simpleTrie = new SimpleTrie();
        simpleTrie.insert("apple");
        assertTrue(simpleTrie.search("apple"));
        assertTrue(simpleTrie.startsWith("app"));
        assertFalse(simpleTrie.search("app"));
        assertTrue(simpleTrie.search("apple"));
        simpleTrie.insert("app");
        assertTrue(simpleTrie.search("app"));


    }

    @Test
    void testSeachEmptyTrie() {
        SimpleTrie simpleTrie = new SimpleTrie();
        assertFalse(simpleTrie.search("app"));
        assertFalse(simpleTrie.startsWith("app"));
    }

}