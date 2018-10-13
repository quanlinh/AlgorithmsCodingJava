public class BusiestTimeInTheSmall {

    public int findBusiestPeriod(int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) return 0;
        int peakPeriod = 0;
        int peopleAtStore = 0;
        int peakPerioPeople = 0;
        for (int row = 0; row < data.length; row++) {
           int period = data[row][0];
           int people = data[row][1];
           int state = data[row][2];
           if(state == 0) peopleAtStore -= people;
           else           peopleAtStore += people;
           if((row < data.length-1 && period !=  data[row+1][0])  || row == data.length-1) {
               if(peakPerioPeople < peopleAtStore) {
                   peakPerioPeople = peopleAtStore;
                   peakPeriod = period;
               }
           }
        }
        return peakPeriod;
    }
}