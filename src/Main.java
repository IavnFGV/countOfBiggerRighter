import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] smaller = Main.smaller(new int[]{5, 4, 7, 9, 2, 4, 4, 5, 6});
        System.out.println(Arrays.toString(smaller));
    }


    public static int[] smaller(int[] unsorted) {
        int[] result = new int[unsorted.length];
        BstNode root = null;
        for (int i = unsorted.length - 1; i >= 0; i--)
            root = insert(root, unsorted[i], result, 0, i);
        return result;

    }

    public static BstNode insert(BstNode root, int val, int[] result, int sum, int i) {
        if (root == null) {
            result[i] = sum;
            return new BstNode(val);
        }

        if (root.val == val) {
            root.duplicationFactor++;
            result[i] = sum + root.countElementsLeft;
        } else if (root.val > val) {
            root.countElementsLeft++;
            root.left = insert(root.left, val, result, sum, i);
        } else {
            root.right = insert(root.right, val, result, sum + root.countElementsLeft + root.duplicationFactor, i);

        }
        return root;
    }
}


class BstNode {
    int duplicationFactor = 1;
    BstNode left;
    BstNode right;
    final int val;
    int countElementsLeft = 0;
    BstNode(int val) {
        this.val = val;
    }
}