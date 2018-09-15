import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnalyticalDatatbasesTest {
    @Test
    void testSomeSmallKeys() {
        AnalyticalDatatbases analyticalDatatbases = new AnalyticalDatatbases();
        List<Map<String, Integer>> mapList1 = new ArrayList<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("a", 2);
        mapList1.add(map1);
        mapList1.add(map2);
        Map<String, Integer> resMap1 = analyticalDatatbases.minByKey("a", mapList1);
        assertTrue(resMap1.get("a") == 1);
        assertTrue(resMap1.get("b") == 2);
        //
        Map<String, Integer> resMap3 = analyticalDatatbases.minByKey("b", mapList1);
        assertTrue(resMap3.get("a") == 2);

        // second cases
        List<Map<String, Integer>> mapList2 = new ArrayList<>();
        HashMap<String, Integer> map3 = new HashMap<>();
        map3.put("a", 2);
        HashMap<String, Integer> map4 = new HashMap<>();
        map4.put("a", 1);
        map4.put("b", 2);
        mapList2.add(map3);
        mapList2.add(map4);
        Map<String, Integer> resMap2 = analyticalDatatbases.minByKey("a", mapList2);
        assertTrue(resMap2.get("a") == 1);
        assertTrue(resMap2.get("b") == 2);

        // empty cases
        assertTrue(analyticalDatatbases.minByKey("a", new ArrayList<Map<String, Integer>>()).size() == 0);
        // test negative cases
        List<Map<String, Integer>> mapList3 = new ArrayList<>();
        HashMap<String, Integer> map5 = new HashMap<>();
        HashMap<String, Integer> map6 = new HashMap<>();
        map5.put("a", -1);
        map6.put("b", -1);
        mapList3.add(map5);
        mapList3.add(map6);
        Map<String, Integer> resMap4 = analyticalDatatbases.minByKey("b", mapList3);
        assertTrue(resMap4.get("b") == -1);

    }

    @Test
    void testFirstByKey() {
        AnalyticalDatatbases analyticalDatatbases = new AnalyticalDatatbases();
        List<Map<String, Integer>> mapList1 = new ArrayList<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        mapList1.add(map1);
        Map<String, Integer> res1 = analyticalDatatbases.firstByKey("a", "asc", mapList1);
        assertTrue(res1.get("a") == 1);
    }

    @Test
    void testFirstByKeyNegative() {
        AnalyticalDatatbases analyticalDatatbases = new AnalyticalDatatbases();
        // test negative
        List<Map<String, Integer>> mapList2 = new ArrayList<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> map3 = new HashMap<>();
        map2.put("b", 1);
        map3.put("b", -2);
        HashMap<String, Integer> map4 = new HashMap<>();
        map4.put("a", 10);
        mapList2.add(map2);
        mapList2.add(map3);
        mapList2.add(map4);
        Map<String, Integer> res = analyticalDatatbases.firstByKey("a", "asc", mapList2);
        assertTrue(res.get("b") == -2);
        Map<String, Integer> resDes = analyticalDatatbases.firstByKey("a", "desc", mapList2);
        assertTrue(resDes.get("a") == 10);
        Map<String, Integer> bAsc = analyticalDatatbases.firstByKey("b", "asc", mapList2);
        assertTrue(bAsc.get("b")==-2);
        Map<String, Integer> bDsc = analyticalDatatbases.firstByKey("b", "desc", mapList2);
        assertTrue(bDsc.get("b")==1);

    }

    @Test
    void testFirstKeyEmtpy() {
        AnalyticalDatatbases analyticalDatatbases = new AnalyticalDatatbases();
        List<Map<String, Integer>> mapList = new ArrayList<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> map3 = new HashMap<>();
        HashMap<String, Integer> map4 = new HashMap<>();
        map2.put("a",10);
        map2.put("b",-10);
        map4.put("a",3);
        map4.put("c",3);
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        mapList.add(map4);
        Map<String, Integer> res = analyticalDatatbases.firstByKey("a", "desc", mapList);
        assertTrue(res.get("a") == 10);
        assertTrue(res.get("b") == -10);
    }

}