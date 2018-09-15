import java.util.*;

public class AnalyticalDatatbases {
    // TODO find out how to do this one in Java
    class ExtendComparator {
        private String key;
        private String direction;
        ExtendComparator(String key, String direction) {
            this.key = key;
            this.direction = direction;
        }
        class  KeyComparator implements  Comparator {
            public int compare(Map<String,Integer> map1, Map<String, Integer> map2 ) {
                if(direction.equals("asc")) {
                    if(map1.get(key)< map2.get(key)) return -1;
                    else if(map1.get(key) > map2.get(key)) return 1;
                    else return 0;
                }else {
                    if(map1.get(key)< map2.get(key)) return 1;
                    else if(map1.get(key) > map2.get(key)) return -1;
                    else return 0;
                }
            }

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        }
    }

    public static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records) {
        return firstByKey(key, "asc", records);
    }

    public static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records) {
        if (records == null || records.size() == 0) return new HashMap<>();
        TreeMap<Integer, Map<String, Integer>> treeMapOrderByKey = new TreeMap<>();
        for (Map<String, Integer> keyOfRecord : records) {
            if (keyOfRecord.containsKey(key)) {
                treeMapOrderByKey.put(keyOfRecord.get(key), keyOfRecord);
            } else {
                treeMapOrderByKey.put(0, keyOfRecord);
            }
        }
        if (treeMapOrderByKey.size() == 0) return new HashMap<>();
        if (direction.equals("asc")) return treeMapOrderByKey.firstEntry().getValue();
        else return treeMapOrderByKey.lastEntry().getValue();
    }

}
