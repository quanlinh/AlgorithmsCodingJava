public class MonotoneIncreasingDigits {
    // It very intersting the String.valueOf very good at remove 0 leading digits
    public int monotoneIncreasingDigits(int N) {
        char[] digits = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < digits.length && digits[i-1] <= digits[i]) i++;
        while (0 < i && i < digits.length && digits[i] < digits[i-1]) digits[--i]--;
        for(i = i+1; i < digits.length; i++) digits[i] = '9';
        return Integer.parseInt(String.valueOf(digits));
    }
    public int monotoneIncreasingDigitsBrutalForce(int N) {
        char[] digits = String.valueOf(N).toCharArray();
        int i = digits.length-1;
        while(!monotone(digits)) {
            N--;
            digits = String.valueOf(N).toCharArray();
        }
        return N;

    }
    private boolean monotone(char[] digits) {
        for(int i = digits.length-1; i > 0; i--) {
            if(digits[i] < digits[i-1]) return false;
        }
        return true;
    }
}
