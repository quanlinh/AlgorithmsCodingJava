public class BackSpaceCompare {
    public boolean backspaceCompare(String S, String T) {
        return backSpace(S).equals(backSpace(T));
    }
    private String backSpace(String S) {
        StringBuilder sb = new StringBuilder();
        int i = S.length()-1;
        int delete = 0;
        while(i > -1) {
            if(S.charAt(i) == '#') {
                delete++;
                i--;
            } else {
                if(delete > 0){
                    delete--;
                    i--;
                } else {
                    sb.append(S.charAt(i));
                    i--;
                }
            }

        }


        return sb.toString();
    }
}
