import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitIntoBasketsTest {
    private FruitIntoBaskets fruitIntoBaskets  = new FruitIntoBaskets();
    @Test
    void test1() {
        assertEquals(fruitIntoBaskets.totalFruit(new int[]{1,2,1}),3);
        assertEquals(fruitIntoBaskets.totalFruit(new int[]{0,1,2,2}),3);
        assertEquals(fruitIntoBaskets.totalFruit(new int[]{1,2,3,2,2}),4);
        assertEquals(fruitIntoBaskets.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}),5);
    }

    @Test
    void testBig() {
        int[] bigArray = new int[30000];
        for(int i = 0; i < 30000; i++) {
            if(i%2 == 0) {
                bigArray[i] = 0;
            } else  {
                bigArray[i] = 1;
            }
        }
        assertEquals(fruitIntoBaskets.totalFruit(bigArray),bigArray.length);
    }
}