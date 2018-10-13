import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SummaryRangesTest {
    @Test
    void test1() {
        SummaryRanges summaryRanges = new SummaryRanges();
        int[] arr1 = new int[]{0,1,2,4,5,7};
        ArrayList<String> resExpected = new ArrayList();
        resExpected.add("0->2");
        resExpected.add("4->5");
        resExpected.add("7");
        List<String> resReal = summaryRanges.summaryRanges(arr1);
        for(int i =0; i < resExpected.size(); i++) {
            assertTrue(resExpected.get(i).equals(resReal.get(i)));
        }
    }

}