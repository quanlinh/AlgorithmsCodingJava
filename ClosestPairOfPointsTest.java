import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPairOfPointsTest {
    @Test
    void testSmallCases() {
        ClosestPairOfPoints closestPairOfPoints = new ClosestPairOfPoints();
        int[] twoPointsX = {0, 3};
        int[] twoPointsY = {0, 4};
        assertEquals(closestPairOfPoints.minimalDistance(twoPointsX, twoPointsY), 5.0);
        int[] fourPointsDuplicateX = {7, 1, 4, 7};
        int[] fourPointsDuplicateY = {7, 100, 8, 7};
        assertEquals(closestPairOfPoints.minimalDistance(fourPointsDuplicateX, fourPointsDuplicateY), 0.0);
        int[] elevenPointsX = {4, -2, -3, -1, 2, -4, 1, -1, 3, -4, -2};
        int[] elevenPointsY = {4, -2, -4, 3, 3, 0, 1, -1, -1, 2, 4};
        int[] fourPointsX = {7, 1, 4, 6};
        int[] fourPointsY = {7, 100, 8, 6};
        assertEquals(closestPairOfPoints.minimalDistance(fourPointsX, fourPointsY), 1.414214);
        assertEquals(closestPairOfPoints.minimalDistance(elevenPointsX, elevenPointsY), 1.414214);

        int[] elevenPointsDuplicateX = {2, 4, 4, 6, 6, 7, 7, 8, 9, 9};
        int[] elevenPointsDuplicateY = {3, 3, 9, 6, 8, 6, 9, 7, 4, 4};
        assertEquals(closestPairOfPoints.minimalDistance(elevenPointsDuplicateX, elevenPointsDuplicateY), 0.00);
        int[] tenBigPointsX = {399904, -447859, -682571, 104036, -984927, -973033, 1678, -962608
                , 453666, 359399};
        int[] tenBigPointsY = {685161, 25498550, -663548965, -715295606, -70328650, 120974486, -941022178, 761924037,
                911608369, -307362223};
//        System.out.println(closestPairOfPoints.minimalDistance(tenBigPointsX,tenBigPointsY)-191672482.5609);
        assertEquals((int)closestPairOfPoints.minimalDistance(tenBigPointsX, tenBigPointsY), (int)closestPairOfPoints.bruteForceMinimalDistance(tenBigPointsX,tenBigPointsY));
        RandomArray randomArray = new RandomArray(1000);
        int[] x = randomArray.randomInteger();
        int[] y = randomArray.randomInteger();
        for (int i = 0; i < x.length; i++) {
            System.out.print(", " + x[i]);
        }
        System.out.println();
        for (int i = 0; i < x.length; i++) {
            System.out.print(", " + y[i]);
        }
//        System.out.println(closestPairOfPoints.minimalDistance(x, y));
        assertEquals((int) closestPairOfPoints.minimalDistance(x, y), (int) closestPairOfPoints.bruteForceMinimalDistance(x, y));


        int[] tenRandomX = {41333, 73225, 94829, 20960, 4343, 42655, 28353, 73301, 94457, 84876};
        int[] tenRandomY = {49423, 20397, 61209, 18118, 44466, 53710, 66407, 92718, 3301, 84781};
//        System.out.println("\nresult 10 random");
//        System.out.println(closestPairOfPoints.minimalDistance(tenRandomX, tenRandomY));
//        System.out.println("\nend of minimal\n");

//        System.out.println(closestPairOfPoints.bruteForceMinimalDistance(tenRandomX, tenRandomY));
        assertEquals((int) closestPairOfPoints.minimalDistance(tenRandomX, tenRandomY), (int) closestPairOfPoints.bruteForceMinimalDistance(tenRandomX, tenRandomY));


        int[] x1 = {94162, 1817, 40563, 47224, 74510, 1952, 57252, 78843, 90027, 70620, 9364, 43228, 87053, 40154,
                43108, 8526, 78761, 97996, 99425, 12128, 7872, 17761, 9942, 39976, 1993, 90848, 23386, 66475, 74733,
                43681, 55177, 38091, 95020, 60488, 57585, 93773, 56349, 32670, 76003, 78150, 42802, 10926, 16233,
                73091, 27898, 10649, 16247, 97617, 23424, 50167, 80378, 85679, 69680, 5995, 38093, 63086, 31994,
                10081, 26122, 32033, 23951, 27270, 44061, 92199, 8840, 64772, 70004, 37619, 75847, 50489, 43667,
                99636, 2677, 12147, 98053, 46950, 49130, 77706, 11820, 87636, 74122, 43674, 32409, 83975, 36269,
                44443, 90967, 46800, 74231, 83198, 35650, 93934, 88742, 56231, 95861, 92733, 27307, 57954, 30977,
                3163
        };
        int[] y1 = {98630, 52728, 14944, 50244, 93289, 6228, 59083, 94586, 24455, 36092, 41784, 27803, 35611,
                138, 51064, 20661, 9814, 25085, 10998, 97370, 13259, 28101, 77877, 81824, 67015, 34632, 91670,
                38097, 45694, 7471, 20182, 30096, 88288, 28369, 46996, 57129, 19371, 96889, 47504, 60403, 21018,
                82774, 26671, 44582, 86331, 71583, 99675, 23763, 67551, 24193, 1256, 79268, 34826, 98278, 25809,
                74160, 86538, 57220, 97504, 99835, 26820, 66527, 1836, 71560, 31049, 21276, 22269, 4220, 3880,
                34307, 83691, 30513, 90302, 29135, 72580, 31027, 55208, 44438, 35725, 85306, 3641, 83088, 48512,
                58597, 31367, 32582, 80243, 7727, 75455, 13048, 9689, 93489, 1017, 34602, 88802, 8756, 63110, 97356,
                92990, 72657
        };
        double actual = 603.0406288136812;
        assertEquals((int) closestPairOfPoints.minimalDistance(x1, y1), (int)
                closestPairOfPoints.bruteForceMinimalDistance(x1, y1));
        int[] ten2X = {8016, 64248, 15378, 1797, 16384, 18171, 95691, 32912, 68339, 8206};
        int[] ten2Y = {29702, 78071, 34755, 80739, 68882, 90872, 64788, 17573, 297, 85136};
        assertEquals((int) closestPairOfPoints.minimalDistance(ten2X, ten2Y), (int)
                closestPairOfPoints.bruteForceMinimalDistance(ten2X, ten2Y));
        int[] ten3X = {65127, 477, 11018, 48325, 64399, 26800, 17667, 1714, 1121, 28036};
        int[] ten3Y = {86174, 77828, 35045, 82592, 68443, 60363, 46577, 85360, 45761, 25598};
        assertEquals((int) closestPairOfPoints.minimalDistance(ten3X, ten3Y), (int)
                closestPairOfPoints.bruteForceMinimalDistance(ten3X, ten3Y));

        int[] oneHundredX = {67843, 33276, 31161, 3782, 4802, 84572, 78042, 73504, 39290, 96005, 82364, 10725, 63940, 77675, 56754, 71105, 82475, 53292, 75892, 19037, 46687, 6522, 82563, 16312, 94242, 17158, 22409, 99489, 49312, 12458, 14879, 45006, 89213, 60786, 70056, 78940, 68646, 93640, 17467, 2116, 89097, 94876, 95710, 27734, 73536, 48972, 98957, 80117, 55304, 44757, 83898, 57647, 36464, 75830, 335, 70263, 53613, 69502, 80975, 72320, 45770, 51218, 68986, 77784, 78749, 27484, 25455, 55326, 74453, 26802, 67179, 16354, 81295, 95298, 8208, 28632, 6600, 84696, 27938, 50137, 91149, 20492, 25514, 73782, 16526, 33995, 76829, 49721, 16881, 70528, 29271, 78330, 37858, 36606, 74177, 13946, 40, 2925, 67634, 60384
        };
        int[] oneHundredY = {62133, 50477, 64680, 42408, 79200, 30921, 68668, 39536, 20876, 17742, 18651, 36520, 54917, 87256, 42527, 16668, 83612, 33583, 90183, 5555, 50394, 40748, 24252, 50301, 50561, 34421, 43390, 47240, 34587, 78340, 98761, 85906, 24194, 56870, 27082, 53465, 74603, 60671, 1368, 40462, 54992, 62826, 52881, 81512, 83480, 6846, 60402, 53813, 59620, 28045, 8402, 32715, 6937, 50086, 35323, 1213, 90182, 53562, 93638, 54377, 51889, 72444, 499, 63758, 41858, 57601, 10850, 70139, 95211, 37830, 15025, 85634, 43218, 9105, 45522, 78667, 11261, 62320, 97223, 58949, 40249, 52702, 1117, 16663, 84455, 54564, 40899, 66485, 65028, 76316, 35557, 47182, 92979, 86256, 82985, 40386, 82889, 53569, 42917, 6472140
        };

        assertEquals((int) closestPairOfPoints.minimalDistance(oneHundredX, oneHundredY), (int)
                closestPairOfPoints.bruteForceMinimalDistance(oneHundredX, oneHundredY));

    }
}