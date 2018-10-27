import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountryCodeToCountry {
    /**
     *

     */

    private Map<String, String> codeCountryName = new HashMap<>();

    public CountryCodeToCountry() {
        this.codeCountryName = new HashMap<>();
        setUp();

    }

    private void setUp() {
        codeCountryName.put("GBR","United Kingdom of Great Britain and Northern Ireland");
        codeCountryName.put("IDN","Indonesia");
        codeCountryName.put("IND","India");
    }

    private String getCountryCode(String code) {
        if (code.length() > 3) {
            for (String key : codeCountryName.keySet()) {
                if (codeCountryName.get(key).equals(code)) {
                    return key;
                }
            }
        }
        return codeCountryName.get(code);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 0 to exit");
        String input = "";
        while (true) {
            System.out.println("Enter country code you want to get:");
            input = scanner.next();
            if(input.equals("0")) break;
            CountryCodeToCountry countryCodeToCountry = new CountryCodeToCountry();
            System.out.println(countryCodeToCountry.getCountryCode(input));

        }

    }
}
