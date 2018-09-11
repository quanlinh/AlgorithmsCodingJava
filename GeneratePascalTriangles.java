import java.util.ArrayList;
import java.util.List;

/**
 * The ah ha moment here is that we add of the front
 */
public class GeneratePascalTriangles {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangles = new ArrayList<>();
        ArrayList<Integer> rowOfPascal = new ArrayList<>();
        for (int rowNumber = 0; rowNumber < numRows; rowNumber++) {
            rowOfPascal.add(0,1);
            for(int j = 1; j < rowOfPascal.size()-1; j++) {
                rowOfPascal.set(j,rowOfPascal.get(j) + rowOfPascal.get(j+1));
            }
            pascalTriangles.add(new ArrayList<>(rowOfPascal));
        }
        return pascalTriangles;
    }
}
