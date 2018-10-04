import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // using an char set to check an anagram of once
        // if it is anagram in the list, we put into the list
        // else we create a new list with new anagramed
        List<List<String>> listString = new ArrayList<>();
        for (String s : strs) {
            putAnagram(listString, s);
        }
        return listString;
    }

    public List<List<String>> groupAnagramsSortingVersion(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> groupAnagrams = new HashMap<>();
        for (String s : strs) {
            char[] charS = s.toCharArray();
            Arrays.sort(charS);
            String key = String.valueOf(charS);
            if (!groupAnagrams.containsKey(key)) groupAnagrams.put(key, new ArrayList());
            groupAnagrams.get(key).add(s);

        }
        return new ArrayList(groupAnagrams.values());
    }

    private void putAnagram(List<List<String>> listString, String s) {
        if (listString == null || listString.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(s);
            listString.add(list);
        } else {
            for (int i = 0; i < listString.size(); i++) {
                List<String> listS = listString.get(i);
                if (anagram(listS.get(0), s)) {
                    listS.add(s);
                    listString.set(i, listS);
                    return;
                }
            }

            // exausted search
            List<String> list = new ArrayList<>();
            list.add(s);
            listString.add(list);
        }
    }

    private boolean anagram(String a, String b) {
        if (a.equals("") || b.equals("")) {
            return a.equals(b);
        }
        if (a.length() != b.length()) return false;
        int[] mapChar1 = new int[26];
        int[] mapChar2 = new int[26];
        for (char c1 : a.toCharArray()) mapChar1[c1 - 'a']++;
        for (char c2 : a.toCharArray()) {
            if (mapChar1[c2 - 'a'] != mapChar2[c2 - 'a']) return false;
        }
        return true;
    }

    private boolean anagramImprove(String a, String b) {
        if (a.equals("") || b.equals("")) {
            return a.equals(b);
        }
        if (a.length() != b.length()) return false;
        HashSet<Character> mapChar1 = new HashSet<>();
        for (char c1 : a.toCharArray()) {
            mapChar1.add(c1);
        }
        for (char c1 : a.toCharArray()) {
            mapChar1.add(c1);
        }

        return true;
    }
}
