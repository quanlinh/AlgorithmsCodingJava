import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationObjectsTest {
    @Test
    void testSimpleCases() {
        PermutationObjects permutationObjects = new PermutationObjects();
        List<List<Integer>> listPermute = permutationObjects.permute(new int[]{1,2,3});
        for(int i = 0; i < listPermute.size(); i++ ) {
//            System.out.println(listPermute.get(i).toString());
        }
//        permutationObjects.permutation1(new int[]{1,2,3},3);
    }

}