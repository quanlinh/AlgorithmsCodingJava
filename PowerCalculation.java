import java.text.DecimalFormat;

public class PowerCalculation {
    public double myPow(double x,int n) {
        long loop = n;
        if (n < 0) {
            loop = -loop;
            x = 1 / x;
        }
        if (n == 0) return 1;
        else if (x == 1.0) return 1.0;
        else if (x == -1.0) {
            if (n % 2 == 0) return 1.0;
            else return -1.0;
        }
        if (x == 0.0) return 0.0;
        double res = x;
        while (--loop > 0) {
            if ((res >= 0 && res <= 0.00001) || (res <= 0 && res >= -0.00001)) {
                res = 0.0;
                break;
            }
            if (n < 0 && 1 / res <= 0.00001) return 0.0;
            res *= x;
        }
        if (n < 0) return 1 / res;
        else return res;
    }
}
