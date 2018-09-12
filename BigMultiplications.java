import java.math.BigInteger;

// The edge cases here is when it get we have un equal
// len when we divide, the multiplication get padding
// of zero wrong.
// To deal with karatsuba when divide n/2 = left/right
// such that left < right is to increase 1 more zero  when
// the left size is an odd numbers.
public final class BigMultiplications {
    // using the karasuba multiplication for big numbers and return
    // the results so that the user can print out

    /**
     * This function implement karasuba mutiplication
     * a = first half of first numbers, b = second half of first number
     * b = first half of second numbers, b = second half of second number
     *
     * @param firstNumber  fist number need to multiplied
     * @param secondNumber second number need to multiplied
     * @return a string of product of firstNumber * secondNumber
     * Why do I expect a list of integers but not a string ?
     * The things I am worry about is that the integer can not contains all the numbers
     * When I return back, the numbers that being multiplied is
     * two big integers
     * In the process of merging them together that multiplied by padding,
     * They will be overflow
     * The problems come from merged them together
     * So what should the recursive called return
     * It should return a string
     * The we can use those strings big integer
     */
    public String karatsubaMultiplication(String firstNumber,String secondNumber) {
        int lenFirstNumber = firstNumber.length();
        int lenSecondNumber = secondNumber.length();
        int lenlowerBound = Math.min(lenFirstNumber,lenSecondNumber);
        if (lenlowerBound  == 1) {
            BigInteger first = new BigInteger(firstNumber);
            BigInteger second = new BigInteger(secondNumber);
            BigInteger res = first.multiply(second);
            return res.toString();
        }
        int lenUpperBound = Math.max(lenFirstNumber,lenSecondNumber);
        // set the number to even numbers. (odd -> round up to even)
        int mid = (int) Math.ceil(lenUpperBound / 2.0);
        int mid1 = lenFirstNumber - mid;
        int mid2 = lenSecondNumber - mid;
        String a = firstNumber.substring(0,mid1);
        String b = firstNumber.substring(mid1,lenFirstNumber);
        String c = secondNumber.substring(0,mid2);
        String d = secondNumber.substring(mid2,lenSecondNumber);
        // if a or c is zero no need to call the recursive call to calculate
        // for ac, and also no need to multiplied the padding for ac
        if (a.length() == 0 || c.length() == 0) {
            BigInteger aBig;
            BigInteger cBig;
            if (a.length() == 0) {
                aBig = new BigInteger("0");
            } else {
                aBig = new BigInteger(a);
            }
            if (c.length() == 0) {
                cBig = new BigInteger("0");
            } else {
                cBig = new BigInteger(c);
            }
            BigInteger bBig = new BigInteger(b);
            BigInteger dBig = new BigInteger(d);
            String aPlusB = (aBig.add(bBig)).toString();
            String cPlusD = (cBig.add(dBig)).toString();
            String bd = karatsubaMultiplication(b,d);
            String aPlusBAndcPlusD = karatsubaMultiplication(aPlusB,cPlusD);
            BigInteger bdBig = new BigInteger(bd);
            BigInteger aPlusBAndCPlusDBig = new BigInteger(aPlusBAndcPlusD);
            // 3  - 2: no 1 (ac in this case)
            // There is no need to subtract ac
            BigInteger gaussTrick = aPlusBAndCPlusDBig.subtract(bdBig);
            BigInteger tenToTheNDivideBy2 = new BigInteger("10").pow(mid);
            BigInteger secondTerm = tenToTheNDivideBy2.multiply(gaussTrick);
            BigInteger res = secondTerm.add(bdBig);
            return res.toString();
        } else {
            BigInteger aBig = new BigInteger(a);
            BigInteger cBig = new BigInteger(c);
            BigInteger bBig = new BigInteger(b);
            BigInteger dBig = new BigInteger(d);
            String aPlusB = (aBig.add(bBig)).toString();
            String cPlusD = (cBig.add(dBig)).toString();
            String ac = karatsubaMultiplication(a,c);
            String bd = karatsubaMultiplication(b,d);
            String aPlusBAndcPlusD = karatsubaMultiplication(aPlusB,cPlusD);
            BigInteger acBig = new BigInteger(ac);
            BigInteger bdBig = new BigInteger(bd);
            BigInteger aPlusBAndCPlusDBig = new BigInteger(aPlusBAndcPlusD);
            // 3 - 1  - 2
            BigInteger gaussTrick = (aPlusBAndCPlusDBig.subtract(acBig)).subtract(bdBig);
            if (lenUpperBound % 2 != 0) lenUpperBound++;
            BigInteger tenToTheN = new BigInteger("10").pow(lenUpperBound);
            BigInteger tenToTheNDivideBy2 = new BigInteger("10").pow(mid);
            BigInteger firstTerm = tenToTheN.multiply(acBig);
            BigInteger secondTerm = tenToTheNDivideBy2.multiply(gaussTrick);
            BigInteger res = firstTerm.add(secondTerm).add(bdBig);
            return res.toString();
        }


    }
}
