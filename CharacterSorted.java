import java.util.ArrayList;
import java.util.TreeMap;

public class CharacterSorted {
    public String frequencyString(String s) {
        char[] cS = s.toCharArray();
        int[] frequency = new int[128];
        for(char c: cS) frequency[c]++;
        TreeMap<Integer, ArrayList<Character>> frequencyMap = new TreeMap<>();
        for(int i = 0 ; i < 128; i ++) {
            if(frequency[i] != 0) {
                if(frequencyMap.containsKey(frequency[i])) {
                    ArrayList<Character> values  = frequencyMap.get(frequency[i]);
                    values.add(Character.valueOf((char)i));
                } else {
                    ArrayList<Character> values = new ArrayList<>();
                    values.add(Character.valueOf((char)i));
                    frequencyMap.put(frequency[i],values);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Integer freq: frequencyMap.keySet()) {
            if(freq == 0) break;
            ArrayList<Character> characterArrayList =  frequencyMap.get(freq);
            for(Character c: characterArrayList) {
                int runner = 0;
                while (runner < freq) {
                    sb.append(c);
                    runner++;
                }
            }

        }
        return sb.reverse().toString();
    }
}
