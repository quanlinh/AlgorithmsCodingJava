import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class insertIntoPositionTest {
    insertIntoPosition insertIntoPosition = new insertIntoPosition();
    int[] input = {1,3,5,6};
    int key1 = 5;
    int expect1 = 2;
    int key2 = 2;
    int expect2 = 1;
    int key3 = 7;
    int expect3 = 4;
    int key4 = 0;
    int expect4 = 0;
    int[] input2 = {1,3};
    int key5 = 2;
    int expect5 = 1;
    @Test
    void testInsertPosition()
    {
//        System.out.println(insertIntoPosition.searchInsert(input,key1) + " " + expect1);
        assert (insertIntoPosition.searchInsert(input,key1)==expect1);
        assert (insertIntoPosition.searchInsert(input,key2)==expect2);
        assert (insertIntoPosition.searchInsert(input,key3)==expect3);
        assert (insertIntoPosition.searchInsert(input,key4)==expect4);
        assert (insertIntoPosition.searchInsert(input2,key5)==expect5);

    }

}