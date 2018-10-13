public class PoorPigDimention {
    public int poorPigs(int buckets,int minutesToDie,int minutesToTest) {
        int pigs = 0;
        double dieTestRatio = minutesToTest / minutesToDie;
        while (Math.pow((dieTestRatio + 1),pigs+1) < buckets) {
            pigs++;
        }
        return pigs;
    }

}
