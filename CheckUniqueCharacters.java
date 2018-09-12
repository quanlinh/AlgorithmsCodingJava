import java.util.Arrays;
import java.util.HashSet;

public class CheckUniqueCharacters {
    public boolean isUniqueCharacters(String string) {
        if (string.length() > 128) return false;
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < string.length(); i++) {
            char val = string.charAt(i);
            // Because we create a array of character of bool is 128
            // and they have a unique 128 values.
            // So they have value from 0 to 127 in term of indexing,
            // that is why we can set the value to it :)
            if (charSet[val]) return false;
            charSet[val] = true;
        }
        return true;
    }

    public boolean isUniqueCharactersSorted(String string) {
        char[] uniqueCharacter = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            uniqueCharacter[i] = string.charAt(i);
        }
        Arrays.sort(uniqueCharacter);
        for (int i = 0; i < uniqueCharacter.length - 1; i++) {
            if (uniqueCharacter[i] == uniqueCharacter[i + 1]) return false;
        }
        return true;
    }

    public boolean isUniqueCharacterUsingHashSet(String string) {
        HashSet<Character> uniqueSet = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            if(uniqueSet.contains(string.charAt(i))) return false;
            uniqueSet.add(string.charAt(i));
        }
        return true;
    }
}