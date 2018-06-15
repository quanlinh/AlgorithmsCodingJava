import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Compile error. javac BinarySearch BinarySearch.java
 * error: Class names, 'BinarySearch', are only accepted if
 * annotation processing is explicitly requested 1 error
 * Using wrong compile syntax
 * Correct:
 * javac -cp BinarySearch BinarySearch.java
 * To run
 * java BinarySearch
 */

/**
 * There are many things that makes binary Search is hard.
 * First, what do you do if the arrays have duplicate value?
 * -> Take the left most, the right most, or the first one that it encounter
 * What to do with an empty array?
 * -> Should return -1 since is there nothing is found in empty array
 * How to update the middle value correctly? Calculate the right index
 * careful is one key to make it correct.
 */
public class BinarySearch {
    /**
     * @param searchArray
     * @param searchElement
     * @return the index of the the searchElement, -1 if not found
     */
    public static int binarySearchRecursive(int[] searchArray,int searchElement) {
        int sizeArray = searchArray.length;
        if(searchArray == null) return -1;

        int low = 0;
        int hi = sizeArray - 1;
        // if odd; divide / will give less than one miss
        // (0 + 10)/2 = 5  = 5: 0 1 2 3 4 5 6 7 8 9 10
        // if even; (0 + 9)/2 = 4: 0 1 2 3 4 5 6 7 8 9
        int mid = (low + hi) / 2 + 1; // solved for two element array
        // only one element
        if (low == hi) {
            if (searchArray[low] == searchElement) {
                return low;
            } else {
                return -1;
            }
        }
        // Go to left
        if (searchElement < searchArray[mid]) {
            return binarySearchRecursive(searchArray,searchElement,low,mid - 1);
            // Go to right
        } else if (searchElement > searchArray[mid]) {
            return binarySearchRecursive(searchArray,searchElement,mid,hi);
        } else {
            if (mid > 0) {
                if (searchArray[mid - 1] == searchElement) {
                    return binarySearchRecursive(searchArray,searchElement,low,mid - 1);
                }
            }
            return mid;

        }
    }

    /**
     * helper method to help binary Search
     *
     * @param searchArray
     * @param searchElement
     * @param low
     * @param hi
     */
    private static int binarySearchRecursive(int[] searchArray,int searchElement,int low,int hi) {
        // The last element to consider
        // only one element
        if (low == hi) {
            if (searchArray[low] == searchElement) {
                return low;
            } else {
                return -1;
            }
        }
        int mid = (low + hi) / 2 + 1;

        if (searchElement < searchArray[mid]) {
            return binarySearchRecursive(searchArray,searchElement,low,mid - 1);
        } else if (searchElement > searchArray[mid]) {
            return binarySearchRecursive(searchArray,searchElement,mid,hi);
        } else {
            if (mid > 0) {
                if (searchArray[mid - 1] == searchElement) {
                    return binarySearchRecursive(searchArray,searchElement,low,mid - 1);
                }
            }
            return mid;
        }
    }
    // binary search only works with sorted array
    public static int  binarySearchImprovement(int[] sortedArray, int target)
    {
        int lo = 0, hi = sortedArray.length-1;
        return binarySearchImprovement(sortedArray,target,lo,hi);
    }
    private static int binarySearchImprovement(int[] searchArray, int target, int lo, int hi)
    {
        if (lo > hi)                        return (-1);
        int mid = (lo + hi) / 2;
        int valueAtMid = searchArray[mid];

        if(target == valueAtMid )
        {
            while (mid > 0 && searchArray[mid] == searchArray[mid-1]) mid--;
            return mid;
        }
        else if(target > valueAtMid)        return binarySearchImprovement(searchArray,target,mid+1,hi);
        else                                return binarySearchImprovement(searchArray,target,lo,mid-1);
    }

    public static int binarySearch(int[] sortedArray,int target) {
        int n = sortedArray.length;
        int lo = 0;
        int hi = n - 1;
        int mid = (lo + hi) / 2;
        while (mid <= hi && mid >= lo) {
            int midValue = sortedArray[mid];
            if (midValue == target)
            {
                // TODO improve this left terminate, it is not fast.
                // assume to take the left most index like linear Search
                while (mid > 0 && sortedArray[mid - 1] == sortedArray[mid]) mid--;
                return mid;
            }
            if (target < midValue) {
                hi = mid - 1;
                if (hi < lo) return -1;
                else mid = (lo + hi) / 2;
            } else { // (target > midValue)
                lo = mid + 1;
                if (lo > hi) return -1;
                else mid = (lo + hi) / 2;
            }
        }
        return -1;
    }

    public static int linearSearch(int[] sortedArray,int value) {
        for (int i = 0; i < sortedArray.length; i++)
            if (sortedArray[i] == value) return i;
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = scanner.nextInt();
        for (int i = 0; i < m; i++) System.out.print(binarySearch(a,b[i]) + " ");



    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }
}