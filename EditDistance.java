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

    public int minimumEditDistance(String m,String n) {
        int rows = m.length(), cols = n.length();
        int[][] editTable = new int[m.length() + 1][n.length() + 1];
        // Initialization
        initialize(editTable,rows,cols);
        for(int r = 1; r <= rows; r++ ) {
            for (int c = 1; c <= cols; c++) {
                int insertCost = editTable[r-1][c] + 1;
                int deleteCost = editTable[r][c-1] + 1;
                int subCost =  editTable[r-1][c-1];
                if(m.charAt(r-1) != n.charAt(c-1)) {
                    subCost += 1;
                }
                int minCost = Math.min(Math.min(insertCost,deleteCost),subCost);
                editTable[r][c] = minCost;
            }
        }
        return editTable[rows][cols];
    }

    private void initialize(int[][] editTable, int rows, int cols) {
        for (int r = 0; r <= rows; r++) {
            editTable[r][0] = r;
        }
        // skip one [0,0]
        for(int c = 1; c <= cols; c++) {
            editTable[0][c] = c;
        }
    }
}
