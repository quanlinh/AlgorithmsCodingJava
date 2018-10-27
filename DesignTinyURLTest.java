import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesignTinyURLTest {
    @Test
    void test1() {
        DesignTinyURL designTinyURL = new DesignTinyURL();
        System.out.println(designTinyURL.encode("234q234wajerla;klasjdkfl"));
    }
}