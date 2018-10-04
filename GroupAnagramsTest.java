import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {
    @Test
    void test1() {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] a = {"tea","","eat","","tea",""};
        List<List<String>> listString = groupAnagrams.groupAnagrams(a);

    }
    @Test
    void test2() {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] a = {"yup","yup","eat","pup","tea",""};
        List<List<String>> listString = groupAnagrams.groupAnagrams(a);
    }

}