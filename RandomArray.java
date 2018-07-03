import java.util.Random;

public final class RandomArray {
    private int capacity;
    public RandomArray(int capacity) {
        this.capacity = capacity;
    }

    public int[] randomInteger() {
        Random random = new Random();
        int[] randomArray = new int[this.capacity];
        for (int i = 0; i < capacity; i++)
        {
            randomArray[i] = random.nextInt(100000);
        }
        return randomArray;
    }
    public double[] randomDouble() {
        Random random = new Random();
        double[] randomArray = new double[this.capacity];
        for (int i = 0; i < capacity; i++)
        {
            randomArray[i] = random.nextDouble();
        }
        return randomArray;
    }


}
