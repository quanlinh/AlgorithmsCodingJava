import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateSubsetsTest {
    @Test
    void testGenerateSubsetsBit(){
        GenerateSubsets generateSubsets = new GenerateSubsets();
        generateSubsets.subsets(new int[]{1,2,3});
    }

}