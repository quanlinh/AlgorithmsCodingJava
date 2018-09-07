public class ReverseInteger {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == 0) return 0;
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        while (x % 10 == 0 && x > 9) {
            x /= 10;
        }
        int len = (x + "").length();
        StringBuilder sb = new StringBuilder();
        int positionDigit = 0;
        while (positionDigit++ < len) {

            sb.append(x % 10);
            x /= 10;
        }
        int res;
        try {
            res = Integer.parseInt(sb.toString());
            return negative ? -res : res;

        } catch (Exception e) {
            return 0;
        }
    }

    public int reverseOptimize(int x) {
        if (x == Integer.MIN_VALUE || x == 0) return 0;
        int reverse = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            reverse = reverse*10 + digit;
        }
        return reverse;
    }
}
