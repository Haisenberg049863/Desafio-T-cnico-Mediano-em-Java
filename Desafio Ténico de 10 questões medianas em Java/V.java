// Questão 5: Implemente um algoritmo para encontrar o maior retângulo em uma matriz de 1s e 0s.
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                heights[i] = row[i] == '1' ? heights[i] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] stack = new int[heights.length + 1];
        int top = -1;
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length ? 0 : heights[i]);
            while (top != -1 && h < heights[stack[top]]) {
                int height = heights[stack[top--]];
                int width = (top == -1 ? i : i - 1 - stack[top]);
                maxArea = Math.max(maxArea, height * width);
            }
            stack[++top] = i;
        }
        return maxArea;
    }
}
