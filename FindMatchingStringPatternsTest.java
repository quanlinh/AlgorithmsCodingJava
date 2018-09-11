import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindMatchingStringPatternsTest {
    @Test
    void simpleTest() {
        FindMatchingStringPatterns findMatchingStringPatterns = new FindMatchingStringPatterns();
        String [] words1 = {"abc","deq","mee","aqq","dkd","ccc"};
        List<String> expect1 = new ArrayList<>();
        expect1.add("mee");
        expect1.add("aqq");
        List<String> real1 = findMatchingStringPatterns.findAndReplacePattern(words1,"abb");
        for(String s: real1) System.out.println(s);
        assertArrayEquals(findMatchingStringPatterns.findAndReplacePattern(words1,"abb").toArray(), expect1.toArray());
    }
    @Test
    void testTwo() {
        FindMatchingStringPatterns findMatchingStringPatterns = new FindMatchingStringPatterns();
        String str = "dog cat cat dog";
        String str2 = "dog dog dog dog";
//        findMatchingStringPatterns.wordPatternSuperOptimize("abba",str);
        findMatchingStringPatterns.wordPatternSuperOptimize("abba",str2);
    }

}