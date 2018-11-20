import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        // Intutition:
        // as in Approach #1, at least one worker is paid their mimimum wage expectation.
        // Additionally, every worker has some minimum rario of dollars to quality that
        // they damand. For example, if wage[0] = 100 and quality[0] = 20, the the ratio
        // for worker 0 is 5.0.
        // The key insight is to iterate over the ratio. Let's say we hire workers with a ratio R or lower.
        // Then, we would want to know the K workers with the lowest quality, and the sum of that quality.
        // We can use a heap to maintain these variables.
        // Algorithm
        // Maintain a max heap of quality. We're using a minheap, with negative values. We'll also maitain
        // sumq, the sum of heap. ?
        // For each worker in order of ratio, we know all currently considered workers have lower ratio.
        // This worker will be the 'captain', as describe in Approach #1. We calculate the candidate answer
        // as this ratio times the sum of the smallest K workers in quality.
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);
        double ans = 1e9;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue<>();
        for(Worker worker: workers) {
            pool.offer(-worker.quality);
            sumq += worker.quality;
            if(pool.size() > K)
            {
                sumq += pool.poll();
            }
            if(pool.size() == K) {
                ans = Math.min(ans, sumq * worker.ratio());
            }
        }
        return ans;


    }

    class Worker implements Comparable<Worker> {
        public int quality, wage;
        public Worker(int q, int w) {
            quality = q;
            wage = w;
        }
        public double ratio() {
            return (double) wage / quality;
        }

        public int compareTo(Worker other) {
            return Double.compare(ratio(), other.ratio());
        }
    }

}

