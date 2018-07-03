public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}

    public int minDepth(TreeNode root)
    {
        if (root == null) return 0;
        int left = minDepthLeft(root.left, 1);
        //System.out.println(left);
        int right = minDepthRight(root.right, 1);
        //System.out.println(right);
        if (left == 1) return right;
        else if( right == 1) return left;
        else if (left < right ) return left;
        else return right;


    }
    private int minDepthLeft(TreeNode x , int sum)
    {
        if (x == null) return 1;
        return sum + minDepthLeft(x.left, sum);

    }
    private int minDepthRight(TreeNode x , int sum)
    {
        if (x == null) return 1;
        return sum + minDepthRight(x.right, sum);

    }
    private int minDepth()
    {
        return 0;
    }

}
