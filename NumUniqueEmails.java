import java.util.HashSet;

public class NumUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        // first Scan
        // second Scan
        HashSet<String> set = new HashSet<>();
        for(String email: emails) {
            set.add(filtedEmail(email));
        }
        return set.size();
    }

    private String filtedEmail(String email) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // first scan that remove . and skip +
        while(i < email.length() && email.charAt(i) != '@') {
            // skip all letter if we have +
            if(email.charAt(i) == '+') {
                while(i < email.length() && email.charAt(i) != '@') {
                    i++;
                }
                break;
            }
            if(email.charAt(i) != '.') sb.append(email.charAt(i));
            i++;
        }
        // second scan all the domain
        while(i < email.length()) {
            sb.append(email.charAt(i++));
        }
        return sb.toString();
    }
}
