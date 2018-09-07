import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese
{
    public List<String> generateParenthesis(int n) {
        List<String> allParenthese = new ArrayList<>();
        generate(allParenthese,"", 0, 0, n);
        return allParenthese;
    }
    private void generate(List<String> allParenthese, String cur, int open, int closed, int max) {
        if(cur.length() == max * 2) {
            allParenthese.add(cur);
            return;
        }
        if(open < max) {
            generate(allParenthese, cur+"(", open+1, closed,max);
        }
        if(closed < open) {
            generate(allParenthese, cur+")",open, closed+1,max);
        }
    }


}
