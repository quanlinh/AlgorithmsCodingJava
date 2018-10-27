public class StringMatchingAlgorithm {
    public boolean isSubString(String word,String pattern) {
        int wordLen = word.length();
        int patternLen = pattern.length();
        int unicode = 256;
        int[] jumpTable = new int[unicode];
        for (int i = 0; i < unicode; i++) {
            jumpTable[i] = -1;
        }
        for (int c = 0; c < patternLen; c++) {
            jumpTable[pattern.charAt(c)] = c;
        }
        int skip;
        for (int i = 0; i <= wordLen - patternLen; i += skip) {
            skip = 0;
            for (int j = patternLen - 1; j > -1; j--) {
                if (pattern.charAt(j) != word.charAt(i + j)) {
                    skip = Math.max(1,j - jumpTable[word.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) return true;
        }
        return false;

    }

}
