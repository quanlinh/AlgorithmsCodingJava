import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertToTitleExcelTest {
    @Test
    void testSimple() {
        ConvertToTitleExcel convertToTitleExcel = new ConvertToTitleExcel();
        System.out.println(convertToTitleExcel.convertToTitle(26000));
        System.out.println((char)('B'+ 'a'-'A'));
        System.out.println('a'-'A');
    }

}