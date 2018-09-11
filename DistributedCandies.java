import java.util.HashMap;
import java.util.HashSet;

public class DistributedCandies {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> uniqueCandies = new HashSet<>();
        for (int candie : candies) uniqueCandies.add(candie);
        return Math.min(candies.length / 2, uniqueCandies.size());
    }
}
