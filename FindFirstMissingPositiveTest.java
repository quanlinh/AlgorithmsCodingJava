import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstMissingPositiveTest {
    @Test
    void testSimpleCases() {
        FindFirstMissingPositive findFirstMissingPositive = new FindFirstMissingPositive();
        int[] val1 = {7,8,9,11,12};
        assertEquals(findFirstMissingPositive.segaratePositive(val1),0);
        System.out.println(Arrays.toString(val1));
        int[] val2 = {3,4,-1,1};
        assertEquals(findFirstMissingPositive.segaratePositive(val2),1);
        System.out.println(Arrays.toString(val2));
        int[] val3= {1,2,0};
        assertEquals(findFirstMissingPositive.segaratePositive(val3),1);
        System.out.println(Arrays.toString(val3));
        int[] val4 = {0,2,2,4,0,1,0,1,3};
        assertEquals(findFirstMissingPositive.segaratePositive(val4),3);
        System.out.println(Arrays.toString(val4));
        int[] val5 = {0,-1,3,1};
        assertEquals(findFirstMissingPositive.segaratePositive(val5),2);
        System.out.println(Arrays.toString(val5));


        assertEquals(findFirstMissingPositive.firstMissingPositive(val1),1);
        assertEquals(findFirstMissingPositive.firstMissingPositiveImprove(new int[]{-1,0,3,1}),2);
        assertEquals(findFirstMissingPositive.firstMissingPositiveImprove(new int[]{-1,2,3,1}),4);
        assertEquals(findFirstMissingPositive.firstMissingPositiveSuperGenious(new int[]{3,4,-1,1}),2);



    }

}