import java.util.ArrayList;
import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        char[] nDigit = String.valueOf(n).toCharArray();
        int sum = 0;
        HashSet<Integer> value = new HashSet<>();
        while (sum != 1) {
            sum = 0;
            for (Character c : nDigit) {
                sum += Math.pow(c - '0', 2);
            }
            if (value.contains(sum)) return false;
            else value.add(sum);
            nDigit = String.valueOf(sum).toCharArray();

        }
        return true;
    }

    public boolean isHappyOptimize(int n) {
        HashSet<Integer> setSum = new HashSet<>();
        int sumSquares, digitSquare;
        while (setSum.add(n)) {
            sumSquares = 0;
            while (n != 0) {
                digitSquare = n % 10;
                sumSquares += digitSquare * digitSquare;
                n /= 10;
            }
            if (sumSquares == 1) return true;
            else n = sumSquares;
        }
        return false;
    }
}
