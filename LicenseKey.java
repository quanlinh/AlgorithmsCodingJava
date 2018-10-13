public class LicenseKey {
    public String licenseKeyFormatting(String S, int k) {
        StringBuilder sb = new StringBuilder();
        String SN = S.toUpperCase();
        for(int i = SN.length()-1; i > -1; i--) {
            int count = 0;
            while(i > -1 && count < k) {
                int charVal = SN.charAt(i--);
                if(charVal != '-') {
                    sb.append(Character.toString((char)charVal));
                    count++;
                }
            }
            if(i > -1) { sb.append(String.valueOf('-')); i+=1;}

        }
        return sb.reverse().toString();
    }
}
