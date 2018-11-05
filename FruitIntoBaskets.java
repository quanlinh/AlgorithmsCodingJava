public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length < 3) return tree.length;
        int basket1, basket2;
        int max = 0;
        for (int i = 0; i < tree.length && max < tree.length - i; i++) {
            basket1 = tree[i];
            int j = i + 1;
            while(j < tree.length && basket1 == tree[j]) {
                j++;
            }
            if(j == tree.length) {
                return Math.max(max,j-i );
            } else {
                basket2 = tree[j++];
                while (j < tree.length && (tree[j] == basket1 || tree[j] == basket2)) {
                    j++;
                }
                max = Math.max(max,j-i);
            }

        }
        return max;
    }
}
