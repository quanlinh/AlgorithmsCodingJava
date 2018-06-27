import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * It is very hard to implement merge Sorted
 * efficiently, to day 06/11/2018 I failed to reimplement it
 * The reasons I think because I did not a solid understand how
 * divide and conquer works. And I am not master recursion yet.
 * Study more, implement more than one language, until it makes sense.
 */
public class CountingNumberInversion {
    int[] processInputFile(String fileName, int fileSize)
    {
        int[] input = new int[fileSize];
        int i = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                input[i++] = Integer.parseInt(line);
            }
        }catch (IOException io){
            io.printStackTrace();
        }

        // TODO reading the file from .txt and convert to a long array
        return input;
    }
    public long countInversion(int[] array)
    {
        int [] tempArray = new int[array.length];
        return mergeSort(array, tempArray,0,array.length-1);
    }
    public long mergeSort(int[] array, int[] tempArray, int lo, int hi)
    {

        if ( hi <= lo) return 0;
        int mid = (lo + hi) / 2;
        long leftInversion  = mergeSort(array,tempArray,lo,mid);
        long rightInversion = mergeSort(array,tempArray,mid+1,hi);
        return leftInversion + rightInversion + merge(array,tempArray,lo,mid,hi);
    }
    private long merge(int[] array,int[] tempArray, int lo, int mid, int hi)
    {
//        assert(isSorted(array,lo,mid));
//        assert(isSorted(array,mid+1,hi));
        long inversions = 0;
        for (int i = lo; i <= hi; i++ ) tempArray[i] = array[i];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid)        array[k] = tempArray[j++];

            else if (j > hi)    array[k] = tempArray[i++];
            else if (tempArray[i] > tempArray[j])
            {
                                array[k] = tempArray[j++];
                                inversions += mid-i+1;
                // the left elements from the left array when copy from the right is the #inv
            }
            else               array[k] = tempArray[i++];

        }
//        assert(isSorted(array,lo,hi));
        return inversions;
    }
    private boolean isSorted(int[] array, int lo, int hi)
    {
        for(int i = lo + 1; i <= hi; i++)
        { if(array[i-1] > array[i]) return false; }
        return true;
    }
    public static void main(String args[]) {

//        String fileName = "E:\\PersonalProjectGitHub\\AlgorithmsCodingJava\\_bcb5c6658381416d19b01bfc1d3993b5_IntegerArray.txt";
//        CountingNumberInversion countingNumberInversion = new CountingNumberInversion();
//        int[] arrayInteger = countingNumberInversion.processInputFile(fileName,100000);
//        System.out.println(countingNumberInversion.countInversion(arrayInteger));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        CountingNumberInversion countingNumberInversion = new CountingNumberInversion();
        System.out.println(countingNumberInversion.countInversion(a));
    }
}
