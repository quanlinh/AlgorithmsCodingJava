public class SimpleTrie {
    private static class Node {
        private Object value;
        private Node[] next = new Node[26];
    }

    private Node root = new Node();


    public SimpleTrie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node runner = root;
        for(char c: word.toCharArray()) {
            if (runner.next[c-'a'] == null) runner.next[c-'a'] = new Node();
            runner = runner.next[c-'a'];
        }
        runner.value = word;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return get(word) != null;
    }

    private Object get(String word) {
        Node runner = root; // if use root, we will lose track of root :(
        for (char c : word.toCharArray()) {
            if (runner.next[c - 'a'] == null) return null;
            runner = runner.next[c - 'a'];
        }
        return runner.value;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node runner = root; // if use root, we will lose track of root :(
        for (char c : prefix.toCharArray()) {
            if (runner.next[c - 'a'] == null) return false;
            runner = runner.next[c - 'a'];
        }
        return true;
    }
}
