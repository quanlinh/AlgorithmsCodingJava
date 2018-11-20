import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {
    WordLadder wordLadder = new WordLadder();
    @Test
    void testLastLetterDifferentThanEndWords() {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        assertEquals(2,wordLadder.ladderLength("hot","dot",list));
    }

    @Test
    void testLastLetterIsTheLastWord() {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        assertEquals(5,wordLadder.ladderLength("hit","cog",list));
    }
    @Test
    void testLastLetterIsNotInTheList() {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        assertEquals(0,wordLadder.ladderLength("hit","cog",list));
    }
}