public class MedianOfTwoSortedArrays {
    public double findTheMedianOfTwoSortedArrays(int[] A,int[] B) {
        if (A.length > B.length) return findTheMedianOfTwoSortedArrays(B,A);
        int lenA = A.length, lenB = B.length;
        int minA = 0, maxA = lenA;
        int midPoint = (lenA + lenB + 1) / 2;
        while (minA <= maxA) {
            int middleA = (minA + maxA) / 2;
            int middleB = midPoint - middleA;
            if (middleA > minA && A[middleA - 1] > B[middleB]) {
                // means pointerMidPointOfA is too big, reduces
                maxA = middleA - 1;
            } else if ( middleA < maxA && B[middleB - 1] > A[middleA]) {
                minA = middleA + 1;
            } else {
                int maxLeft;
                if (middleA == 0) maxLeft = B[middleB - 1];
                else if (middleB == 0) maxLeft = A[middleA - 1];
                else maxLeft = Math.max(A[middleA - 1],B[middleB - 1]);
                if ((A.length + B.length) % 2 == 1) return maxLeft;
                int minRight;
                if (middleA == lenA) minRight = B[middleB];
                else if (middleB == lenB) minRight = A[middleA];
                else minRight = Math.min(A[middleA],B[middleB]);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
