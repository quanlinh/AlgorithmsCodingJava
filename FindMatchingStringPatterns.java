import java.util.*;

public class FindMatchingStringPatterns {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> matchList = new ArrayList<>();
        for(String str: words) {
            if(isMatched(str, pattern)) matchList.add(str);
        }
        return matchList;
    }

    private int countUnique(char[] chars) {
        int[] charIndex = new int[26];
        for (char c : chars)
            charIndex[c - 'a']++;

        int count = 0;
        for (int i : charIndex) count += i;
        return count;
    }

    /**
     * One may thinks that is check the input value (Contains value)
     * immediately, but
     * that cost O(n) strings each time so ti up to O(n^2)
     * it is not sufficient for map because it is supposed to check
     * constant time.
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] splitString = str.split(" ");
        char[] patternArray = pattern.toCharArray();
        if (splitString.length != patternArray.length) return false;
        for (int i = 0; i < splitString.length; i++) {
            if (map.containsKey(patternArray[i])) {
                if (!map.get(patternArray[i]).equals(splitString[i])) return false;
            } else {
                map.put(patternArray[i], splitString[i]);
            }

        }
        HashSet<String> duplicateSet = new HashSet<>();
        for (String s : splitString) {
            duplicateSet.add(s);
        }
        return duplicateSet.size() == map.size();

    }
    private boolean isMatched(String str, String pattern) {
        Map map = new HashMap();
        if(str.length() != pattern.length()) return false;
        for(Integer i = 0; i < str.length(); i++) {
            if(map.put(str.charAt(i),i) != map.put(pattern.charAt(i),i)) return false;
        }
        return true;
    }

    public boolean wordPatternSuperOptimize(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}
