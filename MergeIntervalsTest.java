import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {
    @Test
    void testMergeInterval() {
        MergeIntervals mergeIntervals = new MergeIntervals();
        Interval interval =new Interval(1,3);
        Interval interval1 =new Interval(2,6);
        Interval interval2 =new Interval(8,10);
        Interval interval3 =new Interval(15,18);
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(interval);
        intervalList.add(interval1);
        intervalList.add(interval2);
        intervalList.add(interval3);
        List<Interval> intervalListResutl  = mergeIntervals.merge(intervalList);
    }

}