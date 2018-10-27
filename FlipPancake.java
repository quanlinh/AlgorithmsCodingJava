public class FlipPancake {
    static int[] pancakeSort(int[] arr) {
        if (arr.length < 1) return arr;
        int element = arr.length - 1;
        while (element > 0) {
            int maxIndex = max(arr,element);
            flip(arr,maxIndex);
            flip(arr,element);
            element--;
        }
        return arr;

    }

    private static int max(int[] arr,int stop) {
        int maxValue = arr[0];
        int indexMax = 0;
        // assume duplicate
        for (int i = 1; i <= stop; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                indexMax = i;
            }
        }
        return indexMax;
    }
    // [3,1,2] => [2,1,3] => [1,2,3]
    static void flip(int[] arr,int k) {
        if (k < 1) return;
        int left = 0, right = k;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

    }
}
