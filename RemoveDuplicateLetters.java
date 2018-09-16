import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) return s;
        Map<Character, Integer> lastPosMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastPosMap.put(s.charAt(i), i);
        }
        char[] result = new char[lastPosMap.size()];
        int begin = 0, end = findMinLastPos(lastPosMap);
        for (int i = 0; i < result.length; i++) {
            char minChar = 'z' + 1;
            for (int k = begin; k <= end; k++) {
                if (lastPosMap.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    begin = k + 1;
                }
            }
            result[i] = minChar;
            if (i == result.length - 1) break;
            lastPosMap.remove(minChar);
            if (s.charAt(end) == minChar) end = findMinLastPos(lastPosMap);
        }
        return new String(result);
    }

    private int findMinLastPos(Map<Character, Integer> lastPosMap) {
        if (lastPosMap == null || lastPosMap.isEmpty()) return -1;
        int minLastPost = Integer.MAX_VALUE;
        for (int lasPost : lastPosMap.values()) {
            minLastPost = Math.min(minLastPost, lasPost);
        }
        return minLastPost;
    }

    // time: O(n)
    // space: O(n)
    // scan from left to right, use a stack and visited set to record those already in stack. if an incoming unvisited
    // char is less than the top of stack && there is the same top-of-stack char left in the future scanning
    // (it means we can have a smaller lsxi order string but also include all the letters.),
    // pop the stack and push this incoming char.
    public String removeDuplicateLettersUsingGreedyStack(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // build a map to record how many of what character we need to delete
        int[] mapDuplicate = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            mapDuplicate[c - 'a']++;
        }
        // visited used to record those already exist in our half-baked string template
        boolean[] visited = new boolean[26];
        // stack used to compare incoming char with those this incoming
        // char could replace for a smaller lexi order string
        char[] stack = new char[s.length()];
        int top = 0;
        for (char c : chars) {
            mapDuplicate[c - 'a']--;
            // if this char already in our template ,skip it
            if (visited[c - 'a']) {
                continue;
            }
            // if this incoming char is less than top of stack, we could replace top of stack char only if
            // there is the same top-of-stack char left in the future scanning.
            while (top > 0 && c < stack[top - 1] && mapDuplicate[stack[top - 1] - 'a'] > 0) {
                visited[stack[top - 1] - 'a'] = false;
                top--;
            }
            stack[top++] = c;
            visited[c - 'a'] = true;
        }
        // from bottom of stack, assemble a string.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < top; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }
}
