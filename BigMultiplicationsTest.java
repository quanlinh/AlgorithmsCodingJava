import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigMultiplicationsTest {
    @Test
    void karasubaMultiplicationOddcase() {
        BigMultiplications bigMultiplications = new BigMultiplications();
        String res1 = Integer.toString(1234*567);
        assert (bigMultiplications.karatsubaMultiplication("1234","567").equals(res1));
        String res2 = Integer.toString(1274*132);
        assert(bigMultiplications.karatsubaMultiplication("1274","132").equals(res2));
        assertEquals(Integer.toString(12345*678),bigMultiplications.karatsubaMultiplication("12345","678"));
        assertEquals(Integer.toString(357*678),bigMultiplications.karatsubaMultiplication("357","678"));
    }
    @Test
    void testKaratSubaEven()
    {
        BigMultiplications bigMultiplications = new BigMultiplications();
        String res1 = Integer.toString(1234*4567);
        assertTrue(bigMultiplications.karatsubaMultiplication("1234","4567").equals(res1));
    }
    @Test
    void testBigNumber()
    {
        BigMultiplications bigMultiplications = new BigMultiplications();
        String res1 = bigMultiplications.karatsubaMultiplication("31415926535897932384626433" +
                        "83279502884197169399375105820974944592"
                ,"2718281828459045235360287471352662497757247093699959574966967627");
        assertTrue(res1.equals("85397342226735670654635508695465744950348885357651149618796011270677430" +
                "44893204848617875072216249073013374895871952806582723184"));
    }
}