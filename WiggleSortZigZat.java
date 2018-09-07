public class WiggleSortZigZat {

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) swap(nums, i, i + 1);
                if (nums[i] == nums[i + 1]) {
                    int k = i + 2;
                    while (k < nums.length && nums[i] >= nums[k]) k++;
                    if (k <= nums.length - 1) { // found
                        swap(nums, i + 1, k);
                    } else {
                        k = i - 1;
                        while (k > -1 && nums[i] >= nums[k]) k--;
                        if(k < 0) k = 0;
                        swap(nums, i+1 , k); // must found
                        if(k == -1) i = k;
                        else i = k-1;
                    }

                }
            } else {
                if (nums[i] < nums[i + 1]) swap(nums, i, i + 1);
                if (nums[i] == nums[i + 1]) {
                    int k = i + 2;
                    while (k < nums.length && nums[i] <= nums[k]) k++;
                    if (k <= nums.length - 1) { // found
                        swap(nums, i + 1, k);
                    } else {
                        k = i - 1;
                        while (k > -1 && nums[i] <= nums[k]) k--;
                        if(k < 0) k = 0;
                        swap(nums, i+1 , k); // must found
                        if(k == -1) i = k;
                        else i = k-1; // restart sorted at index k that swap
                    }
                }
            }

        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }
}
