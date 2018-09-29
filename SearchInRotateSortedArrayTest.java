import org.junit.jupiter.api.Test;

import javax.sql.rowset.serial.SerialArray;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotateSortedArrayTest {
    @Test
    void testEdgeCases() {
        SearchInRotateSortedArray searchInRotateSortedArray = new SearchInRotateSortedArray();
       assertTrue(searchInRotateSortedArray.search(new int[]{3,1},1)==1);
    }

}