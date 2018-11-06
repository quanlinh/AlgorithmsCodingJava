import java.util.ArrayList;
import java.util.List;

public class ZigZagStringConversion {
    public String convert(String s, int numRows) {
        List<StringBuilder> listSb = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++) {
            listSb.add(new StringBuilder());
        }
        listSb.get(0).append(s.charAt(0));
        int i = 1;
        boolean increase = true;
        while (i < s.length()) {
            if(increase) {
                for(int j = 1; j < numRows && i < s.length(); j++, i++) {
                    listSb.get(j).append(s.charAt(i));

                }
                increase = false;
            } else {
                for(int j = numRows - 2; j > -1 && i < s.length(); j--, i++) {
                    listSb.get(j).append(s.charAt(i));
                }
                increase = true;
            }
        }
        StringBuilder res = listSb.get(0);
        for(int k = 1; k < numRows; k++) {
            res.append(listSb.get(k));
        }
        return res.toString();
    }
}
