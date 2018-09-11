public class CountingSortedColors {
    public void countingSortedColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int color : nums) {
            if (color == 0) zero++;
            else if (color == 1) one++;
            else two++;
        }
        for(int i = 0; i < zero;i++) {
            nums[i] = 0;
        }
        for(int i = zero; i < zero+one; i++) nums[i] = 1;
        for(int i = zero+one; i < nums.length; i++ ) nums[i] = 2;
    }
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int lt = 0, eq = 0, gt = nums.length-1;
        while(lt <= eq && eq <= gt && gt > -1) {
            if(nums[eq] > 1) {
                swap(nums,eq,gt);
                gt--;
            }
            else if(nums[eq] < 1 ) {
                swap(nums, eq,lt);
                eq++;
                lt++;
            }
            else        eq++;
        }

    }
    private void swap(int[] nums,int lt, int gt) {
        int temp = nums[gt];
        nums[gt] = nums[lt];
        nums[lt] = temp;
    }
}
