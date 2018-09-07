import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParentheseTest {
    @Test
    void simleTest() {
        GenerateParenthese generateParenthese  = new GenerateParenthese();
        List<String> allParentheses = generateParenthese.generateParenthesis(3);
        System.out.println(allParentheses.toString());
    }

}