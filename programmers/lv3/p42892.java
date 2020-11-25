package programmers.lv3;

import java.util.ArrayList;
import java.util.List;

public class p42892 {

    public static void main(String[] args) {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};

        p42892 p = new p42892();
        int[][] result = p.solution(nodeinfo);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodeList.add(createNode(nodeinfo[i], i + 1));
        }

        nodeList.sort((o1, o2) -> o2.getPosition().getY() == o1.getPosition().getY() ?
                o1.getPosition().getX() - o2.getPosition().getX() :
                o2.getPosition().getY() - o1.getPosition().getY());

        Node root = nodeList.get(0);

        for (int i = 1; i < nodeList.size(); i++) {
            insert(root, nodeList.get(i));
        }


        List<Node> prelist = new ArrayList<>();
        List<Node> postlist = new ArrayList<>();

        preorder(root, prelist);
        postorder(root, postlist);

        return new int[][] {
                prelist.stream().mapToInt(Node::getValue).toArray(),
                postlist.stream().mapToInt(Node::getValue).toArray()
        };

    }

    private void postorder(Node root, List<Node> postlist) {
        if (root.getLeft() != null) postorder(root.getLeft(), postlist);
        if (root.getRight() != null) postorder(root.getRight(), postlist);
        postlist.add(root);
    }

    private void preorder(Node root, List<Node> prelist) {
        prelist.add(root);
        if (root.getLeft() != null) preorder(root.getLeft(), prelist);
        if (root.getRight() != null) preorder(root.getRight(), prelist);
    }

    private void insert(Node parent, Node child) {
        if (parent.getPosition().getX() < child.getPosition().getX()) { // to right
            if (parent.getRight() == null) parent.addRight(child);
            else insert(parent.getRight(), child);
        } else { // to left
            if (parent.getLeft() == null) parent.addLeft(child);
            else insert(parent.getLeft(), child);
        }
    }

    private Node createNode(int[] info, int value) {
        return new Node(new Position(info[0], info[1]), value);
    }


}

class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Node {
    private final Position position;
    private final int value;

    private Node left;
    private Node right;

    public Node(Position position, int value) {
        this.position = position;
        this.value = value;
    }

    public int addLeft(Node left) {
        this.left = left;
        return this.left.value;
    }

    public int addRight(Node right) {
        this.right = right;
        return this.right.value;
    }

    public Position getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
