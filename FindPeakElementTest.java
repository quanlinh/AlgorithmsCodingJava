import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPeakElementTest {
    @Test
    void testFindPeakElement() {
        FindPeakElement findPeakElement  = new FindPeakElement();
        assertEquals(findPeakElement.findPeakElement(new int[]{1}),0);
        assertEquals(findPeakElement.findPeakElement(new int[]{1,2}),1);
        assertEquals(findPeakElement.findPeakElement(new int[]{1,2,3}),2);
        assertEquals(findPeakElement.findPeakElement(new int[]{1,2,3,1}),2);
        assertEquals(findPeakElement.findPeakElement(new int[]{1,0,2,3}),(0 ));
    }

}