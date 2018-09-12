public class CustomeSortedStrings {
    public String customSortString(String S, String T) {
        int[] characterMap = new int[26];
        for (char c : T.toCharArray()) characterMap[c - 'a']++;
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            int time = characterMap[c - 'a'];
            while (time > 0) {
                sb.append(c);
                time--;
            }
            characterMap[c - 'a'] = 0;
        }

        for (int i = 0; i < 26; i++) {
            int time = characterMap[i];
            while (time > 0) {
                sb.append((char) (i + 'a'));
                time--;
            }
        }
        return sb.toString();
    }
}
