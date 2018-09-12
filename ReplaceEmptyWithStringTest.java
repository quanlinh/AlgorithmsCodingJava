import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceEmptyWithStringTest {
    @Test
    void test1() {
        ReplaceEmptyWithString replaceEmptyWithString = new ReplaceEmptyWithString();
        char[] mister = "Mr John Smith    ".toCharArray();
        replaceEmptyWithString.replaceEmptyWithStringUsingTwoPointer(mister,13);
        System.out.println(Arrays.toString(mister));

    }
}