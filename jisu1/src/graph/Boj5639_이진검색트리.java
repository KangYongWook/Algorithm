package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5639_이진검색트리 {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node tree = new Node();
        while (true) {
            String s = br.readLine();

            if (s == null || s.equals("")) {
                break;
            }

            int num = Integer.parseInt(s);
            tree.add(num);
        }

        postOrder(tree);
        System.out.println(answer);

    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        answer.append(node.num).append("\n");
    }

    static class Node {
        int num;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void add(int num) {
            if (this.num == 0) { // 양의 정수로 들어온다고 했음
                this.num = num;
                this.left = null;
                this.right = null;

            } else if (this.num > num) {
                if (this.left == null) {
                    this.left = new Node(num, null, null);
                } else {
                    this.left.add(num);
                }

            } else if (this.num < num) {
                if (this.right == null) {
                    this.right = new Node(num, null, null);
                } else {
                    this.right.add(num);
                }
            }
        }
    }
}
