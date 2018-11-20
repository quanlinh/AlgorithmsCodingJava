import java.util.HashMap;
import java.util.Map;

public class EvaluateEquations {

    /*
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Graph g = new Graph();
        g.buildGraph(equations, values);
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            res[i] = g.findEdge(queries[i][0],queries[i][1]);
        }
        return res;
    }
    class Graph {
        private HashMap<String, HashMap<String,Double>> adjList;
        public Graph() {
            adjList = new HashMap<>();
        }

        public void buildGraph(String[][] equations, double[] values) {
            // proceed eq. with value
            for(int i = 0; i < equations.length; i++) {
                constructEdge(equations[i][0], equations[i][1],values[i]);
                constructEdge(equations[i][1], equations[i][0],1/values[i]);
            }
        }

        public void constructEdge(String start, String end, Double value) {
            if(adjList.containsKey(start)) {
                HashMap<String,Double> neigbors = adjList.get(start);
                if(!neigbors.containsKey(end)) {
                    neigbors.put(end,value);
                    adjList.put(start,neigbors);
                }
            } else {
                HashMap<String,Double> neighbors = new HashMap<>();
                neighbors.put(end,value);
                adjList.put(start,neighbors);
            }
        }

        public double findEdge(String start, String end) {
            if(adjList.containsKey(start)) {
                HashMap<String,Double> neighbor =  adjList.get(start);
                if(neighbor.containsKey(end)) {
                    return neighbor.get(end);
                } else {
                    if(adjList.containsKey(end)) {
                        String denominatorOfStart = null;
                        double first = 0.0;
                        for(String s: neighbor.keySet()) if(!s.equals(end)) {
                            denominatorOfStart = s;
                            first = neighbor.get(s);
                            break;
                        }
                        // found denominator from a/denominator
                        HashMap<String,Double> neighbor2 = adjList.get(denominatorOfStart);
                        if(!neighbor2.containsKey(end)){
                            // THIS IS TOUGH BREAK POINT
                        }
                        double second = neighbor2.get(end);
                        return first*second;
                    }
                }
            }
            return -1.0;
        }
    }
    */

    // Nice try, but it not work correctly.

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        Map<String, String> root = new HashMap<>();
        Map<String, Double> dist = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String r1 = find(root, dist, equations[i][0]);
            String r2 = find(root, dist, equations[i][1]);
            root.put(r1, r2);
            dist.put(r1, dist.get(equations[i][1]) * values[i] / dist.get(equations[i][0]));
        }
        for (int i = 0; i < queries.length; i++) {
            if (!root.containsKey(queries[i][0]) || !root.containsKey(queries[i][1])) {
                res[i] = -1.0;
                continue;
            }
            String r1 = find(root, dist, queries[i][0]);
            String r2 = find(root, dist, queries[i][1]);
            if (!r1.equals(r2)) {
                res[i] = -1.0;
                continue;
            }
            res[i] = (double) dist.get(queries[i][0]) / dist.get(queries[i][1]);
        }
        return res;
    }

    private String find(Map<String, String> root, Map<String, Double> dist, String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }
        if (root.get(s).equals(s)) return s;
        String lastP = root.get(s);
        String p = find(root, dist, lastP);
        root.put(s, p);
        dist.put(s, dist.get(s) * dist.get(lastP));
        return p;
    }
}
