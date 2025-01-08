import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1991_트리순회 {
    static Node[] binaryTree;
    static StringBuilder preOrder = new StringBuilder();
    static StringBuilder inOrder = new StringBuilder();
    static StringBuilder postOrder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        binaryTree = new Node[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char val = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            binaryTree[val - 'A'] = new Node(left, right);
        }

        preOrder('A');
        System.out.println(preOrder);

        inOrder('A');
        System.out.println(inOrder);

        postOrder('A');
        System.out.println(postOrder);
    }

    private static void preOrder(char root) {
        // value 출력
        preOrder.append(root);

        int idx = root - 'A';
        // left 이동
        if (binaryTree[idx].left != '.') {
            preOrder(binaryTree[idx].left);
        }

        // right 이동
        if (binaryTree[idx].right != '.') {
            preOrder(binaryTree[idx].right);
        }
    }

    private static void inOrder(char root) {
        int idx = root - 'A';
        // left 이동
        if (binaryTree[idx].left != '.') {
            inOrder(binaryTree[idx].left);
        }

        // value 출력
        inOrder.append(root);

        // right 이동
        if (binaryTree[idx].right != '.') {
            inOrder(binaryTree[idx].right);
        }
    }

    private static void postOrder(char root) {
        int idx = root - 'A';
        // left 이동
        if (binaryTree[idx].left != '.') {
            postOrder(binaryTree[idx].left);
        }

        // right 이동
        if (binaryTree[idx].right != '.') {
            postOrder(binaryTree[idx].right);
        }

        // value 출력
        postOrder.append(root);
    }

    static class Node {
        char left;
        char right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
}
