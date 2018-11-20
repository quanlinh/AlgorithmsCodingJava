import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCostToHireKWorkersTest {
    MinimumCostToHireKWorkers minimumCostToHireKWorkers  = new MinimumCostToHireKWorkers();
    @Test
    void test2OutOf3Workers() {
        assertEquals(minimumCostToHireKWorkers.mincostToHireWorkers(new int[] {10,20,5}, new int[]{70,50,30},2),105);
    }
}