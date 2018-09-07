import java.util.ArrayList;
import java.util.List;

public class SpellCheckingWordOnBoard {
    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> wordsOnBoard = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                wordsTrieOnBoard(board, root, row, col, wordsOnBoard);
            }
        }
        return wordsOnBoard;
    }

    private void wordsTrieOnBoard(char[][] board, TrieNode root, int row, int col, ArrayList<String> wordsOnBoard) {
        char c = board[row][col];
        if (root.next[c - 'a'] == null || c == '#') return;
        root = root.next[c - 'a'];
        if (root.word != null) {
            wordsOnBoard.add(root.word);
            root.word = null; // delete duplicate on Trie
        }
        board[row][col] = '#';
        if (row > 0) wordsTrieOnBoard(board, root, row - 1, col, wordsOnBoard);
        if (row < board.length) wordsTrieOnBoard(board, root, row + 1, col, wordsOnBoard);
        if (col > 0) wordsTrieOnBoard(board, root, row, col - 1, wordsOnBoard);
        if (col < board[row].length) wordsTrieOnBoard(board, root, row, col + 1, wordsOnBoard);
        board[row][col] = c;

    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode branch = root;
            for (char c : w.toCharArray()) {
                int shiftIndex = c - 'a';
                if (branch.next[shiftIndex] == null) branch.next[shiftIndex] = new TrieNode();
            }
            branch.word = w;
        }
        return root;
    }
}
