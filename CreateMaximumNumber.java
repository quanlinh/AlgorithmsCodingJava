public class CreateMaximumNumber {
    public int[] maxNumber(int[] A, int[] B, int k) {
        int total = A.length + B.length;
        int aIndex = 0, bIndex = 0;
        int[] numMax = new int[k];
        if (total == k) {
            boolean pickA = false;
            for (int i = 0; i < A.length && i < B.length; i++) {
                if (A[i] > B[i]) {
                    pickA = true;
                    break;
                }
            }
            if (pickA) {
                for (int i = 0; i < A.length; i++) {
                    numMax[i] = A[i];
                }
                for (int i = 0, j = A.length; j < k; j++, i++) {
                    numMax[j] = B[i];
                }
            }
            return numMax;
        }
        while (k > 0) {
            if (aIndex < A.length & bIndex < B.length) {
                int aMaxIndex = pickMax(A, total, aIndex, bIndex);
                int bMaxIndex = pickMax(B, total, bIndex, aIndex);
                boolean pickA = false;
                if (A[aMaxIndex] == B[bMaxIndex]) {
                    int i = aMaxIndex, j = bMaxIndex;
                    while (i >= aIndex && j >= bIndex) {
                        if (A[i--] < B[j--]) {
                            pickA = true;
                            break;
                        }
                    }
                }
                if (pickA || A[aMaxIndex] > B[bMaxIndex]) {
                    numMax[numMax.length - k] = A[aMaxIndex];
                    aIndex = aMaxIndex + 1;
                    k--;
                } else {
                    numMax[numMax.length - k] = B[bMaxIndex];
                    bIndex = bMaxIndex + 1;
                    k--;
                }
            } else if (bIndex >= B.length) {
                int max = pickMax(A, A.length, aIndex, B.length - 1);
                numMax[numMax.length - k] = A[max];
                aIndex = max + 1;
                k--;
            } else {
                int max = pickMax(B, B.length, bIndex, A.length - 1);
                numMax[numMax.length - k] = B[max];
                bIndex = max + 1;
                k--;
            }

        }

        return numMax;
    }

    private int pickMax(int[] num, int total, int runIndex, int otherIndex) {
        int resultIndex = runIndex;
        for (int i = runIndex + 1; i < num.length && i < (total - (i + otherIndex)); i++) {
            if (num[resultIndex] < num[i]) resultIndex = i;
        }
        return resultIndex;
    }


    public int[] maxNumberCorrect(int[] A, int[] B, int k) {
        int aIndex = 0, bIndex = 0;
        int[] numMax = new int[k];
        int total = A.length + B.length;
        int aMaxIndex = aIndex, bMaxIndex = bIndex;
        while ((total - (aIndex + bIndex) > k && k > 0)) {
            // memorize the index already find
            if (aMaxIndex == aIndex) aMaxIndex = pickMax2(A, total, aIndex, bIndex, k);
            if (bMaxIndex == bIndex) bMaxIndex = pickMax2(B, total, bIndex, aIndex, k);
            boolean pickA = false;
            if (aMaxIndex < A.length && bMaxIndex < B.length && A[aMaxIndex] == B[bMaxIndex]) {
                int i = aMaxIndex, j = bMaxIndex;
                while (i >= aIndex && j >= bIndex) {
                    if (A[i--] < B[j--]) {
                        pickA = true;
                        break;
                    }
                }
            }

            if (pickA || aMaxIndex < A.length && bMaxIndex < B.length &&  A[aMaxIndex] > B[bMaxIndex]) {
                numMax[numMax.length - k] = A[aMaxIndex];
                aIndex = aMaxIndex = aMaxIndex + 1;
                k--;
            } else if( !pickA && bMaxIndex < B.length){
                numMax[numMax.length - k] = B[bMaxIndex];
                bIndex = bMaxIndex = bMaxIndex + 1;
                k--;
            } else if(aMaxIndex < A.length && bMaxIndex >= B.length) {
                numMax[numMax.length - k] = A[aMaxIndex];
                aIndex = aMaxIndex = aMaxIndex + 1;
                k--;
            } else if(bMaxIndex < B.length && aMaxIndex >= A.length) {
                numMax[numMax.length - k] = B[bMaxIndex];
                bIndex = bMaxIndex = bMaxIndex + 1;
                k--;
            } else break;
        }
        if (total - (aIndex + bIndex) == k) {
            boolean pickA = false;
            for (int i = aIndex, j = bIndex; i < A.length && j < B.length; i++, j++) {
                if (A[i] > B[j]) {
                    pickA = true;
                    break;
                }
            }
            if (pickA) {
               copyFromTwoArray(aIndex,bIndex,A,B,k,numMax);
            } else {
               copyFromTwoArray(bIndex,aIndex,B,A,k,numMax);
            }
        }
        return numMax;
    }
    private void copyFromTwoArray(int aIndex, int bIndex, int[] A, int[] B, int k, int[] numMax) {
        for (int i = aIndex; i < A.length; i++) {
            numMax[numMax.length-k] = A[i];
            k--;
        }
        for (int j = bIndex; j < B.length; j++) {
            numMax[numMax.length-k] = B[j];
            k--;
        }
    }

    private int pickMax2(int[] num, int total, int runIndex, int otherIndex, int k) {
        int resultIndex = runIndex;
        while (runIndex < num.length && total - (runIndex + otherIndex) >= k) {
            if (num[resultIndex] < num[runIndex]) resultIndex = runIndex;
            runIndex++;
        }
        return resultIndex;
    }

}
