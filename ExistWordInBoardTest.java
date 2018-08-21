import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExistWordInBoardTest {
    @Test
    void testSimple() {
        char[][] a = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        ExistWordInBoard existWordInBoard = new ExistWordInBoard();
        assertTrue(existWordInBoard.exist(a, "SEE"));
        assertTrue(existWordInBoard.exist(a, "ABCCED"));
        assertFalse(existWordInBoard.exist(a, "ABCB"));
        char[][] b = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        assertTrue(existWordInBoard.exist(b, "AAB"));

        char[][] c = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        assertTrue(existWordInBoard.exist(c,"ABCESEEEFS"));

    }


}