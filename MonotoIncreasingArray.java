public class MonotoIncreasingArray {
    public boolean isMonotonic(int[] A) {
        if(A.length < 2) return true;
        int i = 1;
        while(i < A.length && A[i-1] == A[i]) i++;
        if(i == A.length) return true;
        if(A[i-1] > A[i]) {
            for(int j = i; j < A.length; j++)
                if(A[j-1] < A[j]) return false;
            return true;
        }
        else {
            for(int j = i; j < A.length; j++)
                if(A[j-1] > A[j]) return false;

            return true;
        }
    }
}
