import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateAMaximumNumberTest {
    @Test
    void simpleTestCreateMaxIndex() {
        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();
//        assertArrayEquals(createMaximumNumber.maxNumberCorrect(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5),
//                new int[]{9, 8, 6, 5, 3});
//        assertArrayEquals(createMaximumNumber.maxNumberCorrect(new int[]{3, 9}, new int[]{8, 9}, 3), new int[]{9, 8, 9});
//        assertArrayEquals(createMaximumNumber.maxNumberCorrect(new int[]{6, 7}, new int[]{6, 0, 4}, 5), new int[]{6,7,6,0,4});
////        assertArrayEquals(createMaximumNumber.maxNumberCorrect(
////                new int[]{8,0,4,4,1,7,3,6,5,9,3,6,6,0,2,5,1,7,7,7,8,7,1,4,4,5,4,8,7,6,2,2,9,4,7,5,6,2,2,8,4,6,0,4,7,8,9,1,7,0},
////                new int[]{6,9,8,1,1,5,7,3,1,3,3,4,9,2,8,0,6,9,3,3,7,8,3,4,2,4,7,4,5,7,7,2,5,6,3,6,7,0,3,5,3,2,8,1,6,6,1,0,8,4}, 50),
////                new int[]{6,9,8,1,1,5,7,3,1,3,3,4,9,2,8,0,6,9,3,3,7,8,3,4,2,4,7,4,5,7,7,2,5,6,3,6,7,0,3,5,3,2,8,1,6,6,1,0,8,4});
//        assertArrayEquals(createMaximumNumber.maxNumberCorrect(new int[]{6, 8,9}, new int[]{1,7,5}, 3), new int[]{9,7,5});
//        assertArrayEquals(createMaximumNumber.maxNumberCorrect(new int[]{1,7,5}, new int[]{8,6,9}, 3), new int[]{9,7,5});
        assertArrayEquals(createMaximumNumber.maxNumberCorrect(new int[]{6,7,5}, new int[]{4,8,1}, 3), new int[]{8,7,5});

    }

}