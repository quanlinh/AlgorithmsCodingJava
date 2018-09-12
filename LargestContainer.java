public class LargestContainer {
    public int maxArea(int[] heightArray) {
        int maxAreaValue = 0;
        for (int h = 0; h < heightArray.length - 1; h++) {
            for (int w = h + 1; w < heightArray.length; w++) {
                int width = w - h;
                int height = Math.min(heightArray[h],heightArray[w]);
//                System.out.println(width + " width ");
//                System.out.println(height + " height");
                int area = width * height;
                if (area > maxAreaValue) maxAreaValue = area;
            }
        }
        return maxAreaValue;
    }

    public int maxAreaImprove(int[] heightArray) {
        int maxAreaValue = 0;
        int left = 0, right = heightArray.length - 1;
        while (left != right) {
            int width = right - left, height;
            if (heightArray[left] < heightArray[right]) height = heightArray[left++];
            else height = heightArray[right--];
            int area = width * height;
            if (area > maxAreaValue) maxAreaValue = area;
        }
        return maxAreaValue;
    }
}
