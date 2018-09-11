import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratePascalTrianglesTest {
    @Test
    void simpleTest() {
        GeneratePascalTriangles generatePascalTriangles = new GeneratePascalTriangles();
//        generatePascalTriangles.generate(3);
        generatePascalTriangles.generate(4);
    }


}