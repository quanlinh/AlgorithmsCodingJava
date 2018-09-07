import java.util.Random;

public class ShuffleArray {
        private int[] array;
        int[] nums;
        Random rand;

        public ShuffleArray(int[] nums) {
                this.nums = nums;
                rand = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
                return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
                if (nums == null) {
                        return null;
                }

                int[] arr = nums.clone();
                for (int j = 1; j < arr.length; j++) {
                        int i = rand.nextInt(j + 1);
                        if(i == j) continue;
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                }
                return arr;
        }
}

