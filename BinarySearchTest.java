import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    BinarySearch binarySearchObject = new BinarySearch();
    int[] case1 = { 1, 5, 8, 12, 13  };
    int[] expectCase1 = {2, 0, -1, 0, -1 };
    int[] searchKeyCase1 = { 8, 1, 23, 1, 11 };
    int[] case2 = {1,2,3,4,5};
    int[] expectCase2 = {0,1,2,3,4};
    int[] duplicateArray = {0, 2, 3, 6, 7, 10, 10, 11, 12, 17, 17, 17, 18};
//    int[] getDuplicateArray2 = {0 3 3 4 4 6 7 7 8 9 9 16 16 18 19 19 20 21 22 24 27 28 29 31 32 33 34 35 37 38
// 38 39 40 40 42 42 44 46 46 46 47 48 48 49 50 51 57 58 59 59 61 62 64 65 65 65 67 68 68 69 70 71 71 71 72 73 74 74
// 74 75 76 76 76 76 76 79 80 80 80 81 85 87 87 88 88 90 90 90 91 92 93 94 95 95 96 96 98 98 99 99 103};
    int[] duplicateArray3 = {0, 2, 2, 4 ,5, 5 ,5 ,6 ,6 ,8 ,8 ,10 ,10, 10,
        14 ,14, 14, 16, 17, 18 ,21, 21, 27 ,27, 27, 27 ,28, 29, 30, 30 ,31, 31,
        33, 33, 34, 37, 38, 38, 38, 38, 39, 39, 40, 40, 40, 42, 43 ,44 ,45, 46, 47, 47 ,48 ,49 ,
        50, 51, 51, 51, 52, 52, 53, 53, 54, 56, 56, 56, 57, 60, 60};
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void binarySearch() {
        for(int i = 0; i < case2.length; i++)
        {
//           assert (binarySearchObject.binarySearch(case2,i+1) == expectCase2[i]);
//           assert (binarySearchObject.binarySearch(case1,searchKeyCase1[i]) == expectCase1[i]);

        }
//        assert(binarySearchObject.binarySearch(duplicateArray,17) == 9);
//        System.out.println(binarySearchObject.binarySearch(duplicateArray3,8));
        System.out.println(duplicateArray3[34] + " " + duplicateArray3[16] +
                " " + duplicateArray3[7] +  " " + duplicateArray3[11]);
        assert(binarySearchObject.binarySearch(duplicateArray3,8) == 9);


    }

    @org.junit.jupiter.api.Test
    void binarySearchStressTest()
    {
        //constrain  1 ≤ n,k ≤ 10^4
        int[] randomArray  = new int[10000];
        Random random = new Random();
        for(int i = 0; i < 10000; i++) randomArray[i] = random.nextInt(10000);
        Arrays.sort(randomArray);

        for(int i = 0; i < 10000; i++) {
            int indexBinarySearch = binarySearchObject.binarySearch(randomArray,randomArray[i]);
//            int indexLinearSearch = binarySearchObject.binarySearchRecursive(randomArray,randomArray[i]);
            int binarySearchImprovement = binarySearchObject.binarySearchImprovement(randomArray,randomArray[i]);

            if(indexBinarySearch != binarySearchImprovement ) {
//                System.out.print(i +  " ");
//                for(int j = 0; j < 10000; j++) { System.out.print(randomArray[j]+" ");}
                System.out.print(indexBinarySearch + "B ");
                System.out.print(binarySearchImprovement + "L ");
                System.out.print(" // ");
            }
        }
    }


}