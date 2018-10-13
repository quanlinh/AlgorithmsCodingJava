import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusiestTimeInTheSmallTest {
    BusiestTimeInTheSmall busiestTimeInTheSmall = new BusiestTimeInTheSmall();

    @Test
    void testCase1() {
        int[][] time = {{1487799426,21,1}};
        assertTrue(busiestTimeInTheSmall.findBusiestPeriod(time) == 1487799426);
    }

    @Test
    void testCase2() {
        int[][] time = {{1487799425,21,0},{1487799427,22,1},{1487901318,7,0}};
        assertTrue(busiestTimeInTheSmall.findBusiestPeriod(time) == 1487799427);
    }

    @Test
    void testCase3() {
        int[][] time = {{1487799425,21,1},{1487799425,4,0},{1487901318,7,0}};
        assertTrue(busiestTimeInTheSmall.findBusiestPeriod(time) == 1487799425);

    }

    @Test
    void testCase4() {

        int[][] time = {
                {1487799425,14,1},
                {1487799425,4,0},
                {1487799425,2,0},
                {1487800378,10,1},
                {1487801478,18,0},
                {1487801478,18,1},
                {1487901013,1,0},
                {1487901211,7,1},
                {1487901211,7,0}};
        assertEquals(busiestTimeInTheSmall.findBusiestPeriod(time), 1487800378);

    }


    @Test
    void testCase5() {
        int[][] time = {
                {1487799425,14,1}, // increase 14
                {1487799425,4,1}, // 18
                {1487799425,2,1}, // 20

                {1487800378,10,1}, // increase 30

                {1487801478,18,1}, // 48

                {1487901013,1,1}, // 41

                {1487901211,7,1}, // 48
                {1487901211,7,1}}; // 57
        assertEquals(busiestTimeInTheSmall.findBusiestPeriod(time), 1487901211);
    }

    @Test
    void testCase6() {
        int[][] time = {
                {1487799425,14,1}, // 14
                {1487799425,4,0}, // -4
                {1487799425,2,0}, // -2

                {1487800378,10,1},

                {1487801478,18,0},
                {1487801478,19,1},
                {1487801478,1,0},
                {1487801478,1,1},

                {1487901013,1,0},

                {1487901211,7,1},
                {1487901211,8,0}
        };
        assertTrue(busiestTimeInTheSmall.findBusiestPeriod(time) == 1487801478);
    }
}