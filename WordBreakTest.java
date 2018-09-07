import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class WordBreakTest {

    @Test
    void simpleTest() {
        WordBreak wordBreak = new WordBreak();
        String a = "leetcode";
        List<String> dicA = new ArrayList<>();
        dicA.add("leet");
        dicA.add("code");
        String b = "applepenapple";
        List<String> dicB = new ArrayList<>();
        dicB.add("apple");
        dicB.add("pen");
        String c = "catsandog";
        List<String> dicC = new ArrayList<>();
        dicB.add("cats");
        dicB.add("dog");
        dicB.add("sand");
        dicB.add("and");
        dicB.add("cat");

        assertTrue(wordBreak.wordBreak(a, dicA));
        assertTrue(wordBreak.wordBreak(b, dicB));
        assertFalse(wordBreak.wordBreak(c, dicC));


    }

    @Test
    void testAllPossiblePath() {
        WordBreak wordBreak = new WordBreak();
//        List<String> dictA = new ArrayList<>();
//        String[] a = {"cat", "cats", "and", "sand", "dog"};
//        dictA.addAll(Arrays.asList(a));
//        System.out.println(Arrays.toString(wordBreak.wordBreakAll("catsanddog", dictA).toArray()));
//
////        List<String> dictB = new ArrayList<>();
////        String[] b = {"apple", "pen", "applepen", "pine", "pineapple"};
////        dictB.addAll(Arrays.asList(b));
////        System.out.println(Arrays.toString(wordBreak.wordBreakAll("pineapplepenapple", dictB).toArray()));
//
//        List<String> dictC = new ArrayList<>();
//        String[] c = {"cats", "dog", "sand", "and", "cat"};
//        dictC.addAll(Arrays.asList(c));
//        System.out.println(Arrays.toString(wordBreak.wordBreakAll("catsandog", dictC).toArray()));
//
////        List<String> dictLongA = new ArrayList<>();
////        String[] longA = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
////        dictLongA.addAll(Arrays.asList(longA));
////        System.out.println(Arrays.toString(wordBreak.wordBreakAll("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
////                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
////                "aaaaaaaaaaaaa", dictLongA).toArray()));
//
//        List<String> dictLongA = new ArrayList<>();
//        String[] longA = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//        dictLongA.addAll(Arrays.asList(longA));
//        System.out.println(Arrays.toString(wordBreak.wordBreakOptimal("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaa", dictLongA).toArray()));

        List<String> dictB = new ArrayList<>();
        String[] b = {"apple", "pen", "applepen", "pine", "pineapple"};
        dictB.addAll(Arrays.asList(b));
        System.out.println(Arrays.toString(wordBreak.wordBreakOptimal("pineapplepenapple", dictB).toArray()));
    }


}