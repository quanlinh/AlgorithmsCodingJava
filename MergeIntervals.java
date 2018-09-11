import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {


    private class IntevervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval a, Interval b) {
            if (a.end < b.start) return -1;
            else if (a.end > b.start) return 1;
            else return 0;
        }
    }

    public boolean intervalComparator(Interval a, Interval b) {
        if (a.end < b.start) return true;
        else return false;
    }

    public List<Interval> merge(List<Interval> intervalList) {
        Collections.sort(intervalList, new IntevervalComparator());
        ArrayList<Interval> list = new ArrayList<>();
        for (int i = 0; i < intervalList.size(); i++) {
            if(list.size() > 0 && list.get(list.size()-1).end >= intervalList.get(i).start) {
                list.get(list.size()-1).end = Math.max(list.get(list.size()-1).end,intervalList.get(i).end);
            }else {
                list.add(intervalList.get(i));
            }
        }
        return list;
    }
}
