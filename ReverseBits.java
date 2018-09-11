public class ReverseBits {
    public int reverseBits(int n) {
        int zero = 0;
        for (int i = 0; i < 32; i++) {
//             lastBit = (n >> i) & 1;
            zero <<= 1;
            if (((n >> i) & 1) == 1) zero = zero ^ 1;
            System.out.print(Integer.toBinaryString((n >> i) & 1));
//            lastBit = 1 << (lastBit  & (n >> i) & 1);
        }
        System.out.println();
        System.out.println(Integer.toBinaryString(zero));

        return zero;
    }


    /*
     * IN this bits problems there are two way to solved it.
     * One is by brutefoce and count each bit at a time by shifting 0 to 31 bit
     *  and & with zero to extract the last bit. O(n^2)
     *  Other is use dynamic programming to keep track of the already use bit
     *  set. We find the formmula of what patterns can be reuse. The period reset
     *  itself when the bits position of two is always 1.
     * */

    public int[] countBits(int num) {
        int[] valueOne = new int[num + 1];
        int powerOfTwoReset = 1;
        for (int index = 1; index < num + 1; index++) {
            if (powerOfTwoReset * 2 == index) powerOfTwoReset *= 2;
            valueOne[index] = valueOne[index - powerOfTwoReset] + 1;
        }
        return valueOne;

    }
}
