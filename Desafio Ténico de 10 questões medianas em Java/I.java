// Questão 1: Implemente um algoritmo para encontrar o k-ésimo menor elemento em uma árvore binária de busca.
public class KthSmallestElement {
    static int count = 0;
    static int result = Integer.MIN_VALUE;

    public static int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }

    private static void inorderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorderTraversal(node.right, k);
    }
}
