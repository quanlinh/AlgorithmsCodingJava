public class OverLapRectangle {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int rec1X1 = rec1[0];
        int rec1Y1 = rec1[1];
        int rec1X2 = rec1[2];
        int rec1Y2 = rec1[3];

        int rec2X1 = rec1[0];
        int rec2Y1 = rec1[1];
        int rec2X2 = rec1[2];
        int rec2Y2 = rec1[3];

        // boolean firstPointInRec1 = ((rec2X1 > rec1X1 && rec2X1 < rec1X2 ) &&
        //         (rec2Y1 > rec1Y1 && rec2Y1 < rec1Y2));
        //  boolean firstPointInRec2 = ((rec2X2 > rec1X1 && rec2X2 < rec1X2 ) &&
        //         (rec2Y2 > rec1Y1 && rec2Y2 < rec1Y2));
        boolean overTopAndRight = rec2Y1 < rec1Y2 && rec2X1 < rec1X2;
        boolean downAndLeft = rec1Y1 < rec2Y2 && rec1X1 < rec2Y2;
        // boolean downAndLeft = rec2Y2 > rec1Y1 && rec2X2 > rec1X1;
        return overTopAndRight || downAndLeft;

    }
}
