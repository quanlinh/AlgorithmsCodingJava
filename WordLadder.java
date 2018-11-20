import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // finding the shortest path by breadthfirstSearch
        HashMap<String,Integer> map = new HashMap<>();
        map.put(beginWord,1);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int path = 0;
        boolean found = false;
        while(!queue.isEmpty())  {
            String word = queue.poll();
            path = Math.max(path, map.get(word));
            for(String s: wordList) {
                if(!map.containsKey(s) && transform(word,s)) {
                    int newPath = path+1;
                    if(found && s.equals(endWord))  {
                        newPath = Math.min(map.get(endWord),path+1);
                    }
                    map.put(s,newPath);
                    queue.add(s);
                    if(!found && s.equals(endWord)) {
                        found = true;
                    }
                }
            }
        }
        if(found) return map.get(endWord);
        else return 0;

    }

    private boolean transform(String s, String t) {
        int diff = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)){
                diff++;
            }
            if(diff > 1) return false;
        }
        return true;
    }
}
