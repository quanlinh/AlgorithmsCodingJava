import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WiggleSortZigZatTest {
    @Test
    void testSimple() {
        int[] a = {4,5,5,6};
        int[] b = {2,1,1,2,1,3,3,3,1,3,1,3,2};
        int[] c = {2,3,3,2,2,2,1,1};
        WiggleSortZigZat wiggleSortZigZat = new WiggleSortZigZat();
        wiggleSortZigZat.wiggleSort(a);
        System.out.println(Arrays.toString(a));
        wiggleSortZigZat.wiggleSort(b);
        System.out.println(Arrays.toString(b));
        wiggleSortZigZat.wiggleSort(c);
        System.out.println(Arrays.toString(c));


    }

}