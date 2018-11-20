import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateEquationsTest {
    @Test
    void testEndGraphNotExist() {
        String[][] equatiosn = new String[][]{{"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"}};
        double[] value = {3.0,4.0,5.0,6.0};
        String[][] queries = {{"x1","x5"},{"x5","x2"},{"x2","x4"},{"x2","x2"},{"x2","x9"},{"x9","x9"}};

    }

}