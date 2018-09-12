public class AddDigits {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return new int[]{};
        int size = digits.length;

        if (digits[size - 1] != 9) {
            int[] addOne = new int[size];
            for (int i = 0; i < size - 1; i++) {
                addOne[i] = digits[i];
            }
            addOne[digits.length - 1] = digits[digits.length - 1] + 1;
            return addOne;
        } else if (digits[0] == 9) {
            int[] addOne = new int[size + 1];
            int carry = 1;
            for (int i = size - 2; i > -1; i--) {
                int addValue = digits[i] + carry;
                int lastDigit = addValue % 10;
                carry = addValue / 10;
                addOne[i + 1] = lastDigit;
            }
            addOne[0] = carry;
            return addOne;

        } else {
            int[] addOne = new int[size];
            int carry = 1;
            for (int i = size - 2; i > -1; i--) {
                int addValue = digits[i] + carry;
                int lastDigit = addValue % 10;
                carry = addValue / 10;
                addOne[i] = lastDigit;
            }
            return addOne;
        }


    }
}
