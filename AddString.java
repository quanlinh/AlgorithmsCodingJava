import java.util.ArrayList;
import java.util.Stack;

public class AddString {
    public String addStrings(String num1,String num2) {
        int size1 = num1.length(), size2 = num2.length();
        if (size1 > size2) {
            return processAdd(num1,num2,size1 - size2);
        } else if (size1 < size2) {
            return processAdd(num2,num1,size2 - size1);
        } else {
            return processAdd(num1,num2,0);
        }
    }

    private String processAdd(String greater,String lesser,int dif) {
        Stack<Integer> sumDigits = new Stack<>();
        int carry = 0, i = greater.length() - 1;
        while (i - dif > -1) {
//            System.out.println((greater.charAt(i)));
//            System.out.println(lesser.charAt(i));
            int sum = Character.getNumericValue(greater.charAt(i)) + Character.getNumericValue(lesser.charAt(i - dif)) + carry;
//            System.out.println(sum + " sum");
            int lastDigit = sum % 10;
            carry = sum / 10;
            sumDigits.push(lastDigit);
            i--;
        }
        while (i > -1) {
            int sum = Character.getNumericValue(greater.charAt(i)) + carry;
            int lastDigit = sum % 10;
            carry = sum / 10;
            sumDigits.push(lastDigit);
            i--;
        }
        if (carry != 0) sumDigits.push(carry);
            StringBuilder sB = new StringBuilder();
        int valueChar = sumDigits.pop();
        boolean firstIsZero = false;
        if (valueChar == 0) firstIsZero = true;
        else sB.append(valueChar);
        while (!sumDigits.empty()) {
            valueChar = sumDigits.pop();
            if (firstIsZero) {
                if (valueChar != 0) {
                    sB.append(valueChar);
                    firstIsZero = false;
                }
            } else {
                sB.append(valueChar);
            }
        }
        String res =  sB.toString();
        if(res.isEmpty()) return "0";
        else return res;
    }
}
