import java.util.HashMap;
import java.util.Random;

public class DesignTinyURL {
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String,String> mapURL = new HashMap<>();
    private final String url = "http://tinyurl.com/";
    String key = getRandom();
    Random rand ;
    public String encode(String longString) {
        while (mapURL.containsKey(key)) {
            key = getRandom();
        }
        mapURL.put(key,longString);
        return url+key;
    }
    public String decode(String shortString){
        return mapURL.get(shortString.substring(url.length()));
    }
    private String getRandom() {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < 6; i++) {
            rand = new Random();
            sb.append(chars.charAt(rand.nextInt(62)));
        }
        return sb.toString();

    }
}
