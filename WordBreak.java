import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] match = new boolean[s.length() + 1];
        match[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            if (!match[i]) {
                for (String word : wordDict) {
                    if (word.length() <= i && match[i - word.length()] && s.substring(i - word.length(), i).equals(word))
                        match[i] = true;
                }

            }
        }
        return match[s.length()];

    }

    // This solution got time out since it not remember the words correctly
    public List<String> wordBreakAll(String s, List<String> wordDict) {
        List<String> possibleWords = new ArrayList<>();
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                int j = 0;
                while (j < word.length()) j++;
                // as we find the valid word; we need to check the rest of sentence can make a valid words or not
                if (s.substring(0, i + 1).equals(word)) {
                    stringStack.push(s.substring(0, i + 1));
                    String res = wordBreakHelper(possibleWords, s.substring(0, i + 1), stringStack, s.substring(i + 1), wordDict);
                    if (res == null && !stringStack.isEmpty())
                        stringStack.pop();
                }

            }
        }
        return possibleWords;
    }

    private String wordBreakHelper(List<String> possibleWords, String res, Stack<String> stringStack, String s, List<String> wordDict) {
        if (s.length() == 0) {
            possibleWords.add(res);
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                int j = 0;
                while (j < word.length()) j++;
                // as we find the valid word; we need to check the rest of sentence can make a valid words or not
                if (s.substring(0, i + 1).equals(word)) {
                    stringStack.push(s.substring(0, i + 1));
                    // It is stop at the first pine
                    wordBreakHelper(possibleWords, res + " " + s.substring(0, i + 1), stringStack, s.substring(i + 1), wordDict);
                }

            }
        }
        stringStack.pop();
        return null;
    }

    public List<String> wordBreakOptimal(String s, List<String> wordDict) {
        return wordBreakOptimalHelper(s, wordDict, new HashMap<String, ArrayList<String>>());
    }

    private List<String> wordBreakOptimalHelper(String s, List<String> wordDict, HashMap<String, ArrayList<String>> memoize) {
        if (memoize.containsKey(s)) return memoize.get(s);
        ArrayList<String> listWord = new ArrayList<>();
        if (s.length() == 0) {
            listWord.add("");
            return listWord;
        }
        for (String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> subList = wordBreakOptimalHelper(s.substring(word.length()),wordDict,memoize);
                for(String sub: subList)
                    listWord.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        memoize.put(s,listWord);
        return listWord;
    }
}
