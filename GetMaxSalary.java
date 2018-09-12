import java.util.ArrayList;

public class GetMaxSalary {
    public String largestNumber(int[] nums) {
        ArrayList<Integer> diGits = new ArrayList<>(nums.length);
        int[] resChar = new int[nums.length];
        int n = 0;
        for (int i = 0; i < nums.length; i++) diGits.add(nums[i]);
        while (!diGits.isEmpty()) {
            int maxDigit = 0;
            int index = 0;
            for (int i = 0; i < diGits.size(); i++) {
                int digit = diGits.get(i);
                if (isGreater(digit,maxDigit)) {
                    maxDigit = digit;
                    index = i;
                }
            }
            resChar[n++] = maxDigit;
//                    sb.append(maxDigit);
            diGits.remove(index);
        }
        int k = 0;
        while (k < resChar.length && resChar[k] == 0) k++;
        // remove zero leading
        StringBuilder sb = new StringBuilder();
        while (k < resChar.length) {
            sb.append(resChar[k++]);
        }
        String maxSalary = sb.toString();
        if (maxSalary.equals("")) return "0";
        else return maxSalary;


    }

    private boolean isGreater(int digit,int maxDigit) {
        String a = digit + "", b = maxDigit + "";
        String ab = a + b, ba = b + a;
        return ab.compareTo(ba) >= 0;
    }
}
