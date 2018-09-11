import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {
    @Test
    void testIt() {
        HappyNumber happyNumber = new HappyNumber();
        assertTrue(happyNumber.isHappy(19));
        assertTrue(happyNumber.isHappyOptimize(19));
//        int n = 1;
        for(int n = 1; n < 1000; n++)       {
            System.out.println((n<<1)-1 == (int)(Math.pow(2,n)-1));
            System.out.println((n<<1)-1);
            System.out.println((int)(Math.pow(2,n)-1));
        }
    }

}