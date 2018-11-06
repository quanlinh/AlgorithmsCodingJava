import java.util.Arrays;

public class GrantCap {
    static double findGrantsCap(double[] grantsArray, double newBudget) {
        double sum = 0;
        for(double num: grantsArray) {
            sum += num;
        }
        //1 2 50 100 120 1000   // 10000
        //                ^
        //1 2 50 50 50 50 < newBudget //204
        // 2 4 : 3
        // sum = 6
        // effGran = 0
        //

        Arrays.sort(grantsArray);
        int len =  grantsArray.length-1;
        int effGrant = 0;
        for(int i = len; i > -1; i--) {
            if((sum + grantsArray[i]*effGrant ) <= newBudget) {
                return (double) (newBudget-sum) / effGrant;

            }
            effGrant++;
            sum -= grantsArray[i];
        }
        return newBudget/grantsArray.length;
    }
}
