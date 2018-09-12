public class EditDistance {
    public boolean oneEditAway(String first,String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        } else {
            int[] stringArray = new int[256];
            for (int i = 0; i < first.length(); i++) {
                stringArray[first.charAt(i)]++;
            }
            int changeTwo = 0;
            for (int i = 0; i < second.length(); i++) {
                stringArray[second.charAt(i)]--;
                if (stringArray[second.charAt(i)] == -1) {
                    changeTwo++;
                    if (changeTwo == 2) return false;
                }
            }

        }
        return true;
    }
}
