import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valueMapFreq = new HashMap<>();
        for (int value : nums) {
            valueMapFreq.put(value, valueMapFreq.getOrDefault(value, 0) + 1);
        }
       List<Integer>[] freqList = new List[nums.length+1];
        for(Integer val: valueMapFreq.keySet()) {
            Integer freq = valueMapFreq.get(val);
            if(freqList[freq] == null) {
                freqList[freq] = new ArrayList<>();
            }
            freqList[freq].add(val);
        }
        List<Integer> res = new ArrayList<>();
        for(int pos = freqList.length-1; pos >= 0 && res.size() < k; pos--) {
            if(freqList[pos] != null) res.addAll(freqList[pos]);
        }
        return res;

    }
}
