package BOJ.clazz.lv4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * uri = https://www.acmicpc.net/problem/1991
 * name = 트리 순회
 * tier = silver 1
 */

public class bj1991 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Node root = new Node("A");
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node.insert(root, st.nextToken(), st.nextToken(), st.nextToken());
        }

        StringBuilder preString = new StringBuilder();
        StringBuilder inString = new StringBuilder();
        StringBuilder postString = new StringBuilder();

        Node.preOrder(root, preString);
        Node.inOrder(root, inString);
        Node.postOrder(root, postString);

        bw.write(preString.toString() + "\n");
        bw.write(inString.toString() + "\n");
        bw.write(postString.toString());
        bw.flush();
        bw.close();
    }

    static class Node {
        private String data;
        private Node left;
        private Node right;

        public Node(String data) {
            this.data = data;
        }

        public static void insert(Node curNode, String parent, String left, String right) {
            if (curNode == null)
                return ;
            if (curNode.data.equals(parent)) {
                if (!left.equals("."))
                    curNode.left = new Node(left);
                if (!right.equals("."))
                    curNode.right = new Node(right);
                return ;
            }
            insert(curNode.left, parent, left, right);
            insert(curNode.right, parent, left, right);
        }

        public static void preOrder(Node node, StringBuilder sb) {
            sb.append(node.data);
            if (node.left != null) preOrder(node.left, sb);
            if (node.right != null) preOrder(node.right, sb);
        }

        public static void inOrder(Node node, StringBuilder sb) {
            if (node.left != null) inOrder(node.left, sb);
            sb.append(node.data);
            if (node.right != null) inOrder(node.right, sb);
        }

        public static void postOrder(Node node, StringBuilder sb) {
            if (node.left != null) postOrder(node.left, sb);
            if (node.right != null) postOrder(node.right, sb);
            sb.append(node.data);
        }
    }
}

