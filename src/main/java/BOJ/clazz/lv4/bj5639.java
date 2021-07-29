package BOJ.clazz.lv4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/5639
 * name = 이진 검색 트리
 * tier = silver 1
 */

public class bj5639 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        Node root = null;
        while((s = br.readLine()) != null && !s.equals("")) {
            int val = Integer.parseInt(s);
            if (root == null) root = new Node(val);
            else root.insert(val);
        }

        StringBuilder sb = new StringBuilder();
        if (root != null) {
            postOrder(sb, root);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void postOrder(StringBuilder sb, Node node) {
        if (node == null) return;

        postOrder(sb, node.left);
        postOrder(sb, node.right);
        sb.append(node.value + "\n");
    }

    static class Node {

        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void insert(int val) {
            if (this.value > val) { // go left
                if (this.left == null) this.left = new Node(val);
                else this.left.insert(val);
            } else {
                if (this.right == null) this.right = new Node(val);
                else this.right.insert(val);
            }
        }
    } // end of class
}
