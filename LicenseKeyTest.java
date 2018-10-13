import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicenseKeyTest {
    @Test
    void test1() {
        LicenseKey licenseKey = new LicenseKey();
        System.out.println(licenseKey.licenseKeyFormatting("2-4A0r7-4k",4));
    }
}