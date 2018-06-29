import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    @Test
    void majorElement() {
        int[] array1  = {1,2,2,3,3,2,5,0};
        int[] array2  = {};
        int[] array3  = {2,3,9,2,2};
        int[] array4  = {1,2,3,4};
        int[] array5  = {1,2,3,1};
        int[] array6 = {1};
        int[] array7 = {1,1};
        int[] array8 = {512766168, 717383758, 5, 126144732, 5, 573799007, 5, 5, 5, 405079772  };
        assertTrue(MajorityElement.getMajorityElement(array1) == 0);
        assertTrue(MajorityElement.getMajorityElement(array2) == 0);
        assertTrue(MajorityElement.getMajorityElement(array3) == 1);
        assertTrue(MajorityElement.getMajorityElement(array4) == 0);
        assertTrue(MajorityElement.getMajorityElement(array5) == 0);
        assertTrue(MajorityElement.getMajorityElement(array6) == 1);
        assertTrue(MajorityElement.getMajorityElement(array7) == 1);
        assertTrue(MajorityElement.getMajorityElement(array8) == 0);
//        new test
        assertTrue(MajorityElement.getMajorityElementStreamAlgorithmBoyer_Moored(array1)==0);
        assertTrue(MajorityElement.getMajorityElementStreamAlgorithmBoyer_Moored(array2) == 0);
        assertTrue(MajorityElement.getMajorityElementStreamAlgorithmBoyer_Moored(array3) == 1);
        assertTrue(MajorityElement.getMajorityElementStreamAlgorithmBoyer_Moored(array4) == 0);
        assertTrue(MajorityElement.getMajorityElementStreamAlgorithmBoyer_Moored(array5) == 0);
        assertTrue(MajorityElement.getMajorityElementStreamAlgorithmBoyer_Moored(array6) == 1);
        assertTrue(MajorityElement.getMajorityElementStreamAlgorithmBoyer_Moored(array7) == 1);
        assertTrue(MajorityElement.getMajorityElementStreamAlgorithmBoyer_Moored(array8) == 0);

        // use sorting strategy
        assertTrue(MajorityElement.getMajorityElementBysorting(array1)==0);
        assertTrue(MajorityElement.getMajorityElementBysorting(array2) == 0);
        assertTrue(MajorityElement.getMajorityElementBysorting(array3) == 1);
        assertTrue(MajorityElement.getMajorityElementBysorting(array4) == 0);
        assertTrue(MajorityElement.getMajorityElementBysorting(array5) == 0);
        assertTrue(MajorityElement.getMajorityElementBysorting(array6) == 1);
        assertTrue(MajorityElement.getMajorityElementBysorting(array7) == 1);
        assertTrue(MajorityElement.getMajorityElementBysorting(array8) == 0);

        // use divide and conquer strategy
        assertTrue(MajorityElement.getMajorityElementAlgorithmDivideAndConquer(array1) == 0);
        assertTrue(MajorityElement.getMajorityElementAlgorithmDivideAndConquer(array2) == 0);
        assertTrue(MajorityElement.getMajorityElementAlgorithmDivideAndConquer(array3) == 1);
        assertTrue(MajorityElement.getMajorityElementAlgorithmDivideAndConquer(array4) == 0);
        assertTrue(MajorityElement.getMajorityElementAlgorithmDivideAndConquer(array5) == 0);
        assertTrue(MajorityElement.getMajorityElementAlgorithmDivideAndConquer(array6) == 1);
        assertTrue(MajorityElement.getMajorityElementAlgorithmDivideAndConquer(array7) == 1);
        assertTrue(MajorityElement.getMajorityElementAlgorithmDivideAndConquer(array8) == 0);


    }

}