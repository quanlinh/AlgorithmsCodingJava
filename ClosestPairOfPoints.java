import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Comparator;


public class ClosestPairOfPoints {
    static class randomizedQuickSorted {
        /**
         * The comparator to compare the objects
         *
         * @param nums
         * @param comparator
         */
        public void quickSorted(Object[] nums, Comparator<? super Object> comparator) {
            if (nums.length < 2) return;
            threeWayQuickSorted(nums, 0, nums.length - 1, comparator);
        }


        /**
         * Sorted the object default with comparable
         *
         * @param nums
         */
        public void quickSorted(Object[] nums) {
            if (nums.length < 2) return;
            threeWayQuickSorted(nums, 0, nums.length - 1, null);
        }


        /**
         * @param nums
         * @param lo
         * @param hi
         * @param numberComparision
         * @param wayToPickPivot    default is first, 1 is pick last pivot
         * @return numbers of comparisons occurs while sorted the the input arrays
         */
        public long twoWayQuickSortedFirstPivot(Object[] nums, int lo, int hi, long numberComparision, int wayToPickPivot) {
            if (lo >= hi) return 0;
            if (wayToPickPivot == 1) swapByIndex(nums, lo, hi);
            else if (wayToPickPivot == 2) {
                int medianIndex = lo + (hi - lo) / 2;
                medianIndex = pickMedianOfTheThree(nums, lo, medianIndex, hi);
                if (medianIndex != lo) swapByIndex(nums, lo, medianIndex);

            }
            int pivot = twoWayQuickSortedPartitioningPickFirst(nums, lo, hi);
            long numberComparisionOnTheLeft = twoWayQuickSortedFirstPivot(nums, lo, pivot - 1, numberComparision, wayToPickPivot);
            long numberComparisionOnTheRight = twoWayQuickSortedFirstPivot(nums, pivot + 1, hi, numberComparision, wayToPickPivot);
            numberComparision += (hi - lo) + numberComparisionOnTheLeft + numberComparisionOnTheRight;
            return numberComparision;
        }

        private int pickMedianOfTheThree(Object[] nums, int lo, int mid, int hi) {
            Comparable<? super Object> loComparable = (Comparable<? super Object>) nums[lo];
            Comparable<? super Object> midComparable = (Comparable<? super Object>) nums[mid];
            boolean loLessThanHi = loComparable.compareTo(nums[hi]) < 0;
            boolean loGreaterThanHi = loComparable.compareTo(nums[hi]) > 0;
            boolean loGreaterThanMid = loComparable.compareTo(nums[mid]) > 0;
            boolean loLessThanMid = loComparable.compareTo(nums[mid]) < 0;
            boolean midLessThanHi = midComparable.compareTo(nums[hi]) < 0;
            boolean midGreaterThanHi = midComparable.compareTo(nums[hi]) > 0;
            if ((loGreaterThanHi && loLessThanMid) || (loGreaterThanMid && loLessThanHi))
                return lo;
            else if ((loLessThanMid && midLessThanHi) || (midGreaterThanHi && loGreaterThanMid))
                return mid;
            else return hi;
        }

        private void swapByIndex(Object[] nums, int firstIndex, int secondIndex) {
            Object temp = nums[firstIndex];
            nums[firstIndex] = nums[secondIndex];
            nums[secondIndex] = temp;
        }


        /**
         * The Invariant we need to maintain is to keep the lessThan < pivot < greaterThan
         *
         * @param nums
         * @param lo
         * @param hi
         * @return
         */
        // Assume the pivot is already swap on the left most array
        public int twoWayQuickSortedPartitioningPickFirst(Object[] nums, int lo, int hi) {
            Object pivotValue = nums[lo];
            Comparable<? super Object> pivotValueComparable = (Comparable<? super Object>) pivotValue;
            int lessThan = lo + 1;
            for (int greaterThan = lessThan; greaterThan <= hi; greaterThan++) {
                if (pivotValueComparable.compareTo(nums[greaterThan]) > 0) {
                    Object temp = nums[greaterThan];
                    nums[greaterThan] = nums[lessThan];
                    nums[lessThan] = temp;
                    lessThan++; // increase less than by one since one more less than element
                }
            }
            nums[lo] = nums[lessThan - 1];
            nums[lessThan - 1] = pivotValue;
            return lessThan - 1;
        }

        public void threeWayQuickSorted(Object[] nums, int lo, int hi, Comparator<? super Object> comparator) {
            if (lo >= hi) return;
            int pivot = ThreadLocalRandom.current().nextInt(lo, hi + 1);
            Object temp = nums[pivot];
            nums[pivot] = nums[lo];
            nums[lo] = temp;
            int[] twoIndex;
            if (comparator == null) {
                twoIndex = threeWayPartitioning(nums, lo, hi);
            } else {
                twoIndex = threeWayPartitioning(nums, lo, hi, comparator);
            }
            threeWayQuickSorted(nums, lo, twoIndex[0], comparator);
            threeWayQuickSorted(nums, twoIndex[1], hi, comparator);
        }

        // Assume the pivot is already swap on the left most array
        private int[] threeWayPartitioning(Object[] nums, int lo, int hi) {
            Object pivotValue = nums[lo];
            Comparable<? super Object> pivotValueComparable = (Comparable<? super Object>) pivotValue;
            int lessThanPivot = lo;
            int greaterThanPivot = hi;
            int equalToPivot = lo + 1;
            while (lessThanPivot <= equalToPivot && equalToPivot <= greaterThanPivot) {
                if (pivotValueComparable.compareTo(nums[equalToPivot]) > 0) {
                    Object temp = nums[lessThanPivot];
                    nums[lessThanPivot] = nums[equalToPivot];
                    nums[equalToPivot] = temp;
                    lessThanPivot++;
                    equalToPivot++;
                } else if (pivotValueComparable.compareTo(nums[equalToPivot]) < 0) {
                    Object temp = nums[greaterThanPivot];
                    nums[greaterThanPivot] = nums[equalToPivot];
                    nums[equalToPivot] = temp;
                    greaterThanPivot--;
                } else equalToPivot++;
            }
            return new int[]{lessThanPivot, equalToPivot};
        }

        private int[] threeWayPartitioning(Object[] nums, int lo, int hi, Comparator<? super Object> comparator) {

            Object pivotValue = nums[lo];
            int lessThanPivot = lo;
            int greaterThanPivot = hi;
            int equalToPivot = lo + 1;
            while (lessThanPivot <= equalToPivot && equalToPivot <= greaterThanPivot) {
                if (comparator.compare(pivotValue, nums[equalToPivot]) > 0) {
                    Object temp = nums[lessThanPivot];
                    nums[lessThanPivot] = nums[equalToPivot];
                    nums[equalToPivot] = temp;
                    lessThanPivot++;
                    equalToPivot++;
                } else if (comparator.compare(pivotValue, nums[equalToPivot]) < 0) {
                    Object temp = nums[greaterThanPivot];
                    nums[greaterThanPivot] = nums[equalToPivot];
                    nums[equalToPivot] = temp;
                    greaterThanPivot--;
                } else equalToPivot++;
            }
            return new int[]{lessThanPivot, equalToPivot};
        }
    }

    // static inner class is the class that only reference with the outerclass
    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static Point[] constructArraysOfPoint(int[] x, int[] y) {
        Point[] arrayOfPoints = new Point[x.length];
        for (int pointerCounter = 0; pointerCounter < arrayOfPoints.length; pointerCounter++) {
            Point newPoint = new Point(x[pointerCounter], y[pointerCounter]);
            arrayOfPoints[pointerCounter] = newPoint;
        }
        return arrayOfPoints;
    }

    static double bruteForceMinimalDistance(int[] x, int[] y) {
        // TODO make sure bruteForce is right
        Point[] arrayOfPoints = constructArraysOfPoint(x, y);
        double smallestDistance = Double.POSITIVE_INFINITY;
        for (int i = 0; i < arrayOfPoints.length; i++) {
            for (int j = i + 1; j < arrayOfPoints.length; j++) {
                if (euclideanDistance(arrayOfPoints[i], arrayOfPoints[j]) < smallestDistance) {
                    smallestDistance = euclideanDistance(arrayOfPoints[i], arrayOfPoints[j]);
                }
            }
        }

        return smallestDistance;
    }

    static double minimalDistance(int[] x, int[] y) {
        // TODO find a way to take advantage to make it better on Sorted Array
        Point[] arrayOfPoints = constructArraysOfPoint(x, y);
        if (arrayOfPoints.length < 2) throw new IllegalArgumentException("Cannot calculate Point less than 2");
        if (arrayOfPoints.length == 2) return euclideanDistance(arrayOfPoints[0], arrayOfPoints[1]);
        Point[] pointSortedByX = constructArraysOfPoint(x, y);
        Point[] pointSortedByY = constructArraysOfPoint(x, y);

        // sorted x and y takes O(nlogn) time
        randomizedQuickSorted randomizedQuickSorted = new randomizedQuickSorted();
        Comparator<? super ClosestPairOfPoints.Point> objectComparatorByX = (Comparator<Point>) (point1, point2) -> {
            if (point1.x < point2.x) return -1;
            else if (point1.x > point2.x) return 1;
            else { // tie on x, continue to compare y
                if (point1.y < point2.y) return -1;
                else if (point1.y > point2.y) return 1;
                else return 0;
            }
        };
        Comparator<? super ClosestPairOfPoints.Point> objectComparatorByY = (Comparator<Point>) (point1, point2) -> {
            if (point1.y < point2.y) return -1;
            else if (point1.y > point2.y) return 1;
            else { // tie on y, continue to compare x
                if (point1.x < point2.x) return -1;
                else if (point1.x > point2.x) return 1;
                else return 0;
            }
        };
        // using threeWayQuickSored since input allow duplicate
        randomizedQuickSorted.quickSorted(pointSortedByX, (Comparator<? super Object>) objectComparatorByX);
        // Looking for duplicate and return
        for (int i = 0, j = 1; j < pointSortedByX.length; j++, i++) {
            if (pointSortedByX[i].compareTo(pointSortedByX[j]) == 0) {
                return 0.0;
            }
        }
        randomizedQuickSorted.quickSorted(pointSortedByY, (Comparator<? super Object>) objectComparatorByY);
        // Taking Advantage of sorted and duplicate
        Point[] closestPair = closestPairOfPoints(pointSortedByX, pointSortedByY);
        // Sources on StackOverFlow: https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
        DecimalFormat decimalFormat = new DecimalFormat("#.######");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(decimalFormat.format(euclideanDistance(closestPair[0], closestPair[1])));
    }

    /**
     * Post condition: the x-coordinate and the y-coordinate had been sorted
     * Precondition: there at least 4 points
     *
     * @param pointSortedByX
     * @param pointSortedByY
     * @return closest pair of points
     */
    private static Point[] closestPairOfPoints(Point[] pointSortedByX, Point[] pointSortedByY) {
        int size = pointSortedByX.length;
        if (size < 4) {
            if (size == 2) return pointSortedByX;
            else {
                double distancePoint_0_AndPoint1 = euclideanDistance(pointSortedByX[0], pointSortedByX[1]);
                double distancePoint_0_AndPoint2 = euclideanDistance(pointSortedByX[0], pointSortedByX[2]);
                double distancePoint_1_AndPoint2 = euclideanDistance(pointSortedByX[1], pointSortedByX[2]);
                if (distancePoint_0_AndPoint1 < distancePoint_0_AndPoint2 && distancePoint_0_AndPoint1 < distancePoint_1_AndPoint2) {
                    return new Point[]{pointSortedByX[0], pointSortedByX[1]};
                } else if (distancePoint_0_AndPoint2 < distancePoint_1_AndPoint2) {
                    return new Point[]{pointSortedByX[0], pointSortedByX[2]};
                } else return new Point[]{pointSortedByX[1], pointSortedByX[2]};
            }

        }
        int mid = size / 2;
        Point[] leftHalfPointsSortedByX = new Point[mid];
        Point[] leftHalfPointsSortedByY = new Point[mid];
        Point[] rightHalfPointsSortedByX = new Point[size - mid];
        Point[] rightHalfPointsSortedByY = new Point[size - mid];
        // Construct four arrays left half and right half
        for (int i = 0; i < leftHalfPointsSortedByX.length; i++) {
            leftHalfPointsSortedByX[i] = pointSortedByX[i];
        }
        for (int i = 0, j = mid; i < rightHalfPointsSortedByX.length; j++, i++) {
            rightHalfPointsSortedByX[i] = pointSortedByX[j];
        }
        int leftPointerY = 0;
        int rightPointerY = 0;
        for (int i = 0; i < pointSortedByY.length; i++) {
            if (pointSortedByY[i].x < pointSortedByX[mid].x ||
                    (pointSortedByY[i].x == pointSortedByX[mid].x && pointSortedByY[i].y < pointSortedByX[mid].y)) {
                leftHalfPointsSortedByY[leftPointerY++] = pointSortedByY[i];
            } else {
                rightHalfPointsSortedByY[rightPointerY++] = pointSortedByY[i];
            }
        }

        Point[] pairLeft = closestPairOfPoints(leftHalfPointsSortedByX, leftHalfPointsSortedByY);
        Point[] pairRight = closestPairOfPoints(rightHalfPointsSortedByX, rightHalfPointsSortedByY);
        Point[] closestPairSofar = getSmallerPairOfPoints(pairLeft, pairRight);
        Point[] closestSplit = closestSplitPair(pointSortedByX, pointSortedByY, closestPairSofar);
        if (closestSplit == null || closestSplit[0] == null || closestSplit[1] == null) {
            return closestPairSofar;

        } else {
            return getSmallerPairOfPoints(closestPairSofar, closestSplit);
        }
    }

    static Point[] getSmallerPairOfPoints(Point[] pairLeft, Point[] pairRight) {
        if (euclideanDistance(pairLeft[0], pairLeft[1]) < euclideanDistance(pairRight[0], pairRight[1])) {
            return pairLeft;
        } else {
            return pairRight;
        }
    }

    static Point[] closestSplitPair(Point[] pointSortedByX, Point[] pointSortedByY,
                                    Point[] closestPairSofar) {
        // TODO test to see whether this correct for all cases
        Point midBar = pointSortedByX[pointSortedByX.length / 2];
        double theXBarCenter = midBar.x;
        double theSmallestDistance = euclideanDistance(closestPairSofar[0], closestPairSofar[1]);
        // TODO something wrong with the range that makes the bar exclude other points
        double lowerRangeFromXCoordinateCenter = theXBarCenter - theSmallestDistance;

        double higherRangeFromXCoordinateCenter = theXBarCenter + theSmallestDistance;
        ArrayList<Point> pointsClosedToTheMiddleX = new ArrayList<>();
        for (Point p : pointSortedByY) {

            if (lowerRangeFromXCoordinateCenter < p.x && p.x < higherRangeFromXCoordinateCenter) {
                pointsClosedToTheMiddleX.add(p);
            }

        }

        Point[] closestSplitPair = new Point[2];
        for (int i = 0; i < pointsClosedToTheMiddleX.size(); i++) {
            for (int j = 0; j < 7 && i + j < pointsClosedToTheMiddleX.size(); j++) {
                Point p = pointsClosedToTheMiddleX.get(i);
                Point q = pointsClosedToTheMiddleX.get(i + j);
                if (p.x == q.x && p.y == q.y) continue;
                if (euclideanDistance(p, q) < theSmallestDistance) {
                    theSmallestDistance = euclideanDistance(p, q);
                    closestSplitPair[0] = p;
                    closestSplitPair[1] = q;
                }
            }
        }
        return closestSplitPair;
    }


    /**
     * @param point1 point x,y
     * @param point2 point x,y
     * @return euclidean Distance of two points
     */
    private static double euclideanDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow((point1.x - point2.x), 2) + Math.pow(point1.y - point2.y, 2));
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {

            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

}

