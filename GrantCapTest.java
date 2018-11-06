import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrantCapTest {
    private GrantCap grantCap = new GrantCap();
    @Test
    void test1() {
        assertEquals(grantCap.findGrantsCap(new double[]{2,4},3),1.5);
    }
    @Test
    void test2() {
        assertEquals(grantCap.findGrantsCap(new double[]{2,4,6},3),1);

    }
    @Test
    void test3() {
        assertEquals(grantCap.findGrantsCap(new double[]{2,100,50,120,167},400.0),128);

    }
    @Test
    void test4() {
        assertEquals(grantCap.findGrantsCap(new double[]{2,100,50,120,1000},190),47.0);

    }
    @Test
    void test5() {
        assertEquals(grantCap.findGrantsCap(new double[]{21,100,50,120,130,110},140),23.8);

    }
    @Test
    void test6() {
        assertEquals(grantCap.findGrantsCap(new double[]{210,200,150,193,130,110,209,342,117},1530),211);

    }
}